package models;

public class TranslationJob {
    private int jobID;
    private String jobStatus;
    private String sourceLanguage;
    private String selectedLanguage;
    private String textInput;
    private String textOutput;
    private float consistencyScore;

    private TranslationEngine translationEngine;

    public TranslationJob(int jobID, String selectedLanguage, String textInput, TranslationEngine translationEngine) {
        this.jobID = jobID;
        this.jobStatus = "In-Progress";
        this.sourceLanguage = null;
        this.selectedLanguage = selectedLanguage;
        this.textInput = textInput;
        this.textOutput = textInput;
        this.consistencyScore = -1;
        this.translationEngine = translationEngine;
    }

    public int getJobID() {
        return jobID;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String status) {
        jobStatus = status;
    }

    public String getSourceLanguage() {
        return sourceLanguage;
    }

    public void setSourceLanguage(String language) {
        sourceLanguage = language;
    }

    public String getSelectedLanguage() {
        return selectedLanguage;
    }

    public void setSelectedLanguage(String language) {
        selectedLanguage = language;
    }

    public float getConsistencyScore() {
        return consistencyScore;
    }

    public String getJobResult() {
        return textOutput;
    }

    public void setTextOutput(String output) {
        textOutput = output;
    }

    public String getTextInput() {
        return textInput;
    }

    public void translateInput() {      
        this.textOutput = translationEngine.translateText(textInput, sourceLanguage, selectedLanguage);

        setJobStatus("Finished");
    }

    public void getTranslationDetails() {
        System.out.printf("%s: %s -> %s | Language: %s | Status: %s | Score: %s\n",
            jobID, textInput, textOutput, selectedLanguage, jobStatus, consistencyScore);
    }
}
