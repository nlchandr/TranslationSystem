package models;

import java.util.List;

public class GlossaryTerm {
    private String termName;
    private String description;
    private String targetLanguage;
    private List<GlossaryTerm> equivalentTerms;

    public GlossaryTerm(String termName, String description, String targetLanguage, List<GlossaryTerm> equivalentTerms) {
        this.termName = termName;
        this.description = description;
        this.targetLanguage = targetLanguage;
        this.equivalentTerms = equivalentTerms;
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

    public List<GlossaryTerm> getEquivalentTerms() {
        return equivalentTerms;
    }

    public void setEquivalentTerms(List<GlossaryTerm> terms) {
        equivalentTerms = terms;
    }

    public void getTermDetails() {
        System.out.printf("%s | %s | %s | [ ", termName, description, targetLanguage);
        for (GlossaryTerm term : equivalentTerms) {
            System.out.printf("%s ", term.getTermName());
        }
        System.out.print("]\n");
    }
}
