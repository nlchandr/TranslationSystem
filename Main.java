import models.OCRService;
import models.LocaleFormatter;
import models.QualityModeration;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Testing MVC2 Model Classes ===");

        OCRService ocr = new OCRService();
        LocaleFormatter formatter = new LocaleFormatter();
        QualityModeration qm = new QualityModeration();

        System.out.println("\nOCR Test:");
        System.out.println(ocr.extractTextFromImage("welcome_sign.png"));

        System.out.println("\nLocale Format Tests:");
        System.out.println(formatter.formatCurrency(1234.56, "en_CA"));
        System.out.println(formatter.formatDate(LocalDate.of(2025,1,1), "fr_FR"));

        System.out.println("\nQuality Moderation Tests:");
        System.out.println(qm.isAcceptable("This is a clean translation"));
        System.out.println(qm.isAcceptable("This contains badword1"));
    }
}
