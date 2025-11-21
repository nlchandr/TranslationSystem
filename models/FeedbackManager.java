package models;

import java.util.List;
import java.util.ArrayList;

public class FeedbackManager {
    private List<Feedback> feedbackList;

    public FeedbackManager() {
        feedbackList = new ArrayList<>();
    }

    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public Feedback getFeedback(String translationID) {
        for (Feedback fb : feedbackList) {
            if (fb.getTranslationID().equals(translationID)) {
                return fb;
            }
        }
        return null;
    }

    public void addFeedback(String translationID, int rating, String comments) {
        Feedback feedback = new Feedback(translationID, rating, comments);
        feedbackList.add(feedback);
    }
}
