package models;
import com.github.pemistahl.lingua.api.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import kong.unirest.core.HttpResponse;
import kong.unirest.core.json.JSONObject;
import kong.unirest.core.Unirest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TranslationEngine {
    private List<String> supportedLanguages;
    private String targetLanguage;
    private List<TranslationJob> jobQueue;
    private final LanguageDetector detector;

    private GlossaryManager glossaryManager;

    private Map<String, String> iso = new HashMap<>();

    public TranslationEngine(List<String> supportedLanguages, String targetLanguage, GlossaryManager glossaryManager) {
        this.supportedLanguages = supportedLanguages;
        this.targetLanguage = targetLanguage;
        this.jobQueue = new ArrayList<>();
        this.glossaryManager = glossaryManager;
        detector = LanguageDetectorBuilder.fromAllLanguages().build();

        //Supported Languages
        iso.put("english", "en");
        iso.put("french", "fr");
        iso.put("german", "de");
        iso.put("spanish", "es");
        iso.put("chinese", "zh-Hans"); //Simple Chinese
        iso.put("dutch", "nl"); 
    }


    public List<String> getSupportedLanguages() {
        return supportedLanguages;
    }

    public String getTargetLanguage() {
        return targetLanguage;
    }

    public void setTargetLanguage(String target) {
        targetLanguage = target;
    }

    public List<TranslationJob> getJobQueue() {
        return jobQueue;
    }

    public void addJobQueue(TranslationJob job) {
        jobQueue.add(job);
    }

    public String detectLanguage(String input) {
        Language language = detector.detectLanguageOf(input);
        return language.toString().toLowerCase();
    }

    public TranslationJob createJob(int jobID, String selectedLanguage, String input) {
        TranslationJob job = new TranslationJob(jobID, selectedLanguage, input, this);
        addJobQueue(job);
        return job;
    }

    public String processTranslation(TranslationJob job) {
        String detectedLanguage = detectLanguage(job.getTextInput());
        job.setSourceLanguage(detectedLanguage);
        job.translateInput();

        String translated = job.getJobResult();
        translated = glossaryManager.applyGlossary(translated, detectedLanguage);

        job.setTextOutput(translated);

        return translated;
    }

    public String translateText(String text, String sourceLang, String targetLang) {
        if (!supportedLanguages.contains(sourceLang.toLowerCase())) {
            throw new IllegalArgumentException("Unsupported source language: " + sourceLang);
        }

        if (!supportedLanguages.contains(targetLang.toLowerCase())) {
            throw new IllegalArgumentException("Unsupported target language: " + targetLang);
        }

        String source = iso.get(sourceLang.toLowerCase());
        String target = iso.get(targetLang.toLowerCase());

        // 5. Call LibreTranslate from local host
        String url = "http://localhost:5000/translate";

        Unirest.config().setDefaultResponseEncoding("UTF-8");

        HttpResponse<String> response = Unirest.post(url)
            .field("q", text)
            .field("source", source)
            .field("target", target)
            .field("format", "text")
            .asString();

        if (response.getStatus() != 200) {
            throw new RuntimeException("Translation failed. HTTP " + response.getStatus());
        }

        String body = response.getBody();

        // Gson parsing
        JsonObject obj = JsonParser.parseString(body).getAsJsonObject();
        return obj.get("translatedText").getAsString();

        //Manual parsing
        //if (response.getBody() != null && !response.getBody().isEmpty()) {
            //String body = response.getBody();
            //System.out.println("Status = " + response.getStatus());
            //System.out.println("Raw response: " + response.getBody());
            //int start = body.indexOf("\"translatedText\":\"");
                //if (start != -1) {
                    //start += "\"translatedText\":\"".length();
                    //int end = body.indexOf("\"", start);
                    //if (end != -1) {
                        //return (body.substring(start, end));
                    //}
                //}
        //} else {
            //System.out.println("No body returned. Status: " + response.getStatus());
        //}
        //return null;
    }
}
