package models;

import java.util.List;
import java.util.ArrayList;

public class TouristUser {
    private String deviceID;
    private String languageSelected;
    private List<TranslationJob> sessionHistory;

    private int lastJobID = 0;

    public TouristUser(String deviceID, String languageSelected) {
        this.deviceID = deviceID;
        this.languageSelected = languageSelected;
        this.sessionHistory = new ArrayList<>();
    }

    public String getDeviceID() {
        return deviceID;
    }

    public String getLanguageSelected() {
        return languageSelected;
    }

    public List<TranslationJob> getSessionHistory() {
        return sessionHistory;
    }

    public void selectLanguage(String language) {
        languageSelected = language;
    }

    public List<TranslationJob> viewSessionHistory() {
        return getSessionHistory();
    }

    public void addSessionHistory(TranslationJob translation) {
        sessionHistory.add(translation);
    }

    public void deleteSessionHistory() {
        sessionHistory = new ArrayList<>();
    }

    public int generateJobID() {
        return ++lastJobID;
    }
}
