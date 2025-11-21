package models;

public class GlossaryTerm {
    private String termName;
    private String description;
    private String targetLanguage;

    public GlossaryTerm(String termName, String description, String targetLanguage) {
        this.termName = termName;
        this.description = description;
        this.targetLanguage = targetLanguage;
    }

    public String getTermName() {
        return termName;
    }

    public String getDescription() {
        return description;
    }

    public String getTargetLanguage() {
        return targetLanguage;
    }

    public void setDescription(String desc) {
        description = desc;
    }

    public void setTargetLanguage(String language) {
        targetLanguage = language;
    }
}
