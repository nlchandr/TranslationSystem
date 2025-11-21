package controllers;

import java.util.List;

import views.TouristUserUI;
import models.TouristUser;
import models.GlossaryManager;
import models.GlossaryTerm;
import models.FeedbackManager;
import models.TranslationJob;

public class TouristUserController {
    private TouristUserUI touristUI;
    private TouristUser touristUser;
    private GlossaryManager glossaryManager;
    private FeedbackManager feedbackManager;

    public TouristUserController(TouristUserUI touristUI, TouristUser touristUser, GlossaryManager glossaryManager, FeedbackManager feedbackManager) {
        this.touristUI = touristUI;
        this.touristUser = touristUser;
        this.glossaryManager = glossaryManager;
        this.feedbackManager = feedbackManager;
    }

    public void giveFeedback(String translationID, int rating, String comments) {
        feedbackManager.addFeedback(translationID, rating, comments);
    }

    public void getSessionHistory() {
        List<TranslationJob> session = touristUser.getSessionHistory();
        touristUI.displaySessionHistory(session);
    }

    public void deleteHistory() {
        touristUser.deleteSessionHistory();
    }

    public void getGlossary() {
        List<GlossaryTerm> list = glossaryManager.getTermList();
        touristUI.displayGlossary(list);
    }

    public void getTranslation(String input) {

    }
}