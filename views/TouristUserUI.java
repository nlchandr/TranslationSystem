package views;
    
import java.util.List;

import controllers.TouristUserController;

import models.GlossaryTerm;
import models.TranslationJob;

public class TouristUserUI {
    
    private TouristUserController touristController;

    public TouristUserUI(TouristUserController touristController) {
        this.touristController = touristController;
    }

    public void displayTranslation(String output) {
        System.out.println("Translation: " + output);
    }

    public void displayGlossary(List<GlossaryTerm> terms) {
        for (GlossaryTerm term : terms) {
            System.out.println(term);
        }
    }

    public void displaySessionHistory(List<TranslationJob> sessionList) {
        for (TranslationJob job : sessionList) {
            System.out.println(job.showDetails());
        }
    }
}
