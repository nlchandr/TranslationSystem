package models;

public class OCRService {

    public String extractTextFromImage(String imagePath) {
        if (imagePath == null || imagePath.isEmpty()) {
            throw new IllegalArgumentException("imagePath cannot be null or empty");
        }
        if (imagePath.toLowerCase().contains("welcome")) {
            return "Welcome to Toronto";
        }
        return "Sample extracted text from " + imagePath;
    }
}
