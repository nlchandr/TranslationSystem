package models;
import com.github.pemistahl.lingua.api.*;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import java.util.ArrayList;
import java.util.List;

public class TranslationEngine {
    private List<String> supportedLanguages;
    private String targetLanguage;
    private List<TranslationJob> jobQueue;
    private final LanguageDetector detector;

    private GlossaryManager glossaryManager;

    public TranslationEngine(List<String> supportedLanguages, String targetLanguage, GlossaryManager glossaryManager) {
        this.supportedLanguages = supportedLanguages;
        this.targetLanguage = targetLanguage;
        this.jobQueue = new ArrayList<>();
        this.glossaryManager = glossaryManager;
        detector = LanguageDetectorBuilder.fromAllLanguages().build();
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
        HttpResponse<JsonNode> response = Unirest.post("https://libretranslate.de/translate")
            .field("q", text)
            .field("source", sourceLang)
            .field("target", targetLang)
            .field("format", "text")
            .asJson();

        return response.getBody().getObject().getString("translatedText");
    }
}
