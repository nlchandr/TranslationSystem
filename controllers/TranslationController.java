package controllers;
import java.util.List;

import models.TranslationEngine;
import models.TranslationJob;

public class TranslationController {
    private TranslationEngine engine;

    public TranslationController(TranslationEngine engine) {
        this.engine = engine;
    }

    public List<String> getSupportedLanguages() {
        return engine.getSupportedLanguages();
    }

    public TranslationJob translate(int jobID, String input, String targetLanguage) {
        TranslationJob job = engine.createJob(jobID, targetLanguage, input);
        engine.processTranslation(job);
        return job;
    }
}