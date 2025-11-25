package models;
import com.github.pemistahl.lingua.api.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import kong.unirest.core.HttpResponse;
import kong.unirest.core.Unirest;
import kong.unirest.core.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestTranslation {

    private static final Map<String, String> ISO = new HashMap<>();

    static {
        ISO.put("english", "en");
        ISO.put("french", "fr");
        ISO.put("german", "de");
        ISO.put("spanish", "es");
        ISO.put("chinese", "zh-Hans");
        ISO.put("dutch", "nl");
    }

    public static void main(String[] args) {

        // 1. Setup Lingua detector
        LanguageDetector detector = LanguageDetectorBuilder.fromAllLanguages().build();

        // 2. Example input
        String text = "Hello, how are you today?";
        String targetLanguage = "english"; // full name format

        // 3. Detect language (Lingua returns enum -> "ENGLISH")
        Language detected = detector.detectLanguageOf(text);
        String detectedName = detected.toString().toLowerCase(); // "english"
        System.out.println("Detected language: " + detectedName);

        // 4. Convert to ISO for the API
        String sourceIso = ISO.get(detectedName);
        String targetIso = ISO.get(targetLanguage.toLowerCase());

        System.out.println("Source: " + sourceIso);
        System.out.println("Target: " + targetIso);

        if (sourceIso == null || targetIso == null) {
            System.out.println("Language not supported.");
            return;
        }

        // 5. Call LibreTranslate from local host
        String url = "http://localhost:5000/translate";

        Unirest.config().setDefaultResponseEncoding("UTF-8");

        HttpResponse<String> response = Unirest.post(url)
        .field("q", text)
        .field("source", sourceIso)
        .field("target", targetIso)
        .field("format", "text")
        .asString();

        if (response.getStatus() != 200) {
            throw new RuntimeException("Translation failed. HTTP " + response.getStatus());
        }

        String body = response.getBody();

        // Gson parsing
        JsonObject obj = JsonParser.parseString(body).getAsJsonObject();
        System.out.println("Translated: " + obj.get("translatedText").getAsString());

        //if (response.getBody() != null && !response.getBody().isEmpty()) {
            //String body = response.getBody();
            //System.out.println("Status = " + response.getStatus());
            //System.out.println("Raw response: " + response.getBody());
            //int start = body.indexOf("\"translatedText\":\"");
                //if (start != -1) {
                    //start += "\"translatedText\":\"".length();
                    //int end = body.indexOf("\"", start);
                    //if (end != -1) {
                        //System.out.println(body.substring(start, end));
                    //}
                //}
        //} else {
            //System.out.println("No body returned. Status: " + response.getStatus());
        //}
    }
}

