package models;

public class Feedback {
    private String translationID;
    private int rating;
    private String comments;

    public Feedback(String translationID, int rating, String comments) {
        this.translationID = translationID;
        this.rating = rating;
        this.comments = comments;
    }

    public String getTranslationID() {
        return translationID;
    }

    public int getRating() {
        return rating;
    }

    public String getComments() {
        return comments;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}

