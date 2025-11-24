package controllers;

import models.SpeechIO;
import models.TranslationEngine;

public class SpeechIOController {
    private SpeechIO speechIO;
    
    public SpeechIOController(TranslationEngine translationEngine) {
        this.speechIO = new SpeechIO(translationEngine);
    }
    
    public SpeechIO.SpeechTranslationResult handleSpeechTranslation(String audioFilePath, String targetLanguage) {
        System.out.println("Processing speech translation request...");
        return speechIO.translateSpeech(audioFilePath, targetLanguage);
    }
    
    public String handleAudioRecording(int durationSeconds) {
        return speechIO.recordAudio(durationSeconds);
    }
    
    public void handleAudioPlayback(String audioFilePath) {
        speechIO.playAudio(audioFilePath);
    }
    
    public String handleSpeechToText(String audioFilePath) {
        return speechIO.speechToText(audioFilePath);
    }
    
    public String handleTextToSpeech(String text, String language) {
        return speechIO.textToSpeech(text, language);
    }
    
    public SpeechIO getSpeechIO() {
        return speechIO;
    }
}