package models;

import java.util.List;
import java.util.ArrayList;

public class GlossaryManager {
    private List<GlossaryTerm> termList;
    private String version;

    public GlossaryManager(List<GlossaryTerm> termList, String version) {
        this.termList = termList;
        this.version = version;
    }

    public GlossaryManager() {
        this.termList = new ArrayList<>();
        this.version = "1.0";
    }

    public List<GlossaryTerm> getTermList() {
        return termList;
    }

    public String getVersion() {
        return version;
    }

    public void addTerm(String termName, String description, String targetLanguage, List<GlossaryTerm> equivalentTerms) {
        GlossaryTerm term = new GlossaryTerm(termName, description, targetLanguage, equivalentTerms);
        termList.add(term);
    }

    public void updateTerm(String termName, String description, String targetLanguage, List<GlossaryTerm> equivalentTerms) {
        for (GlossaryTerm term : termList) {
            if (term.getTermName().equals(termName)) {
                term.setDescription(description);
                term.setTargetLanguage(targetLanguage);
                term.setEquivalentTerms(equivalentTerms);
                return;
            }
        }
    }

    public String applyGlossary(String input, String targetLanguage) {
        String output = input;

        for (GlossaryTerm term : termList) {
            for (GlossaryTerm equivalent : term.getEquivalentTerms()) {
                if (equivalent.getTargetLanguage().equals(targetLanguage)) {
                    output = output.replace(term.getTermName(), equivalent.getTermName());
                }
            }
        }

        return output;
    }

    public void resolveConflict() {

    }
}