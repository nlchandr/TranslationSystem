package models;

import java.util.Arrays;
import java.util.List;

public class QualityModeration {

    private final List<String> bannedWords = Arrays.asList(
            "badword1", "badword2" 
    );

    public boolean isAcceptable(String translatedText) {
        if (translatedText == null || translatedText.isBlank()) {
            return false; 
        }

        String lower = translatedText.toLowerCase();

        for (String banned : bannedWords) {
            if (lower.contains(banned)) {
                return false;
            }
        }

        if (translatedText.length() < 2) {
            return false;
        }

        return true;
    }
}
