package views;

import java.util.List;
import java.util.Scanner;

import models.GlossaryTerm;

public class ServiceStaffUI {
    private Scanner scanner;
    
    public ServiceStaffUI() {
        this.scanner = new Scanner(System.in);
    }
    
    // Main admin menu
    public int showAdminMenu() {
        System.out.println("\n=== Service Staff Admin Panel ===");
        System.out.println("1. Manage Glossary Terms");
        System.out.println("2. Review User Feedback");
        System.out.println("3. Monitor System Status");
        System.out.println("4. Update Moderation Rules");
        System.out.println("5. View Staff Tasks");
        System.out.println("6. Back to Main Menu");
        System.out.print("Choose option: ");
        return scanner.nextInt();
    }
    
    // Glossary management menu
    public int showGlossaryMenu() {
        System.out.println("\n--- Glossary Management ---");
        System.out.println("1. Add New Glossary Term");
        System.out.println("2. Update Existing Term");
        System.out.println("3. View All Terms");
        System.out.println("4. Resolve Conflicts");
        System.out.println("5. Back to Admin Menu");
        System.out.print("Choose option: ");
        return scanner.nextInt();
    }
    
    // Input methods for glossary terms
    public String getTermName() {
        scanner.nextLine(); // Clear buffer
        System.out.print("Enter term name: ");
        return scanner.nextLine();
    }
    
    public String getTermDescription() {
        System.out.print("Enter term description: ");
        return scanner.nextLine();
    }
    
    public String getTargetLanguage() {
        System.out.print("Enter target language: ");
        return scanner.nextLine();
    }
    
    public String getTranslation() {
        System.out.print("Enter translation: ");
        return scanner.nextLine();
    }
    
    // Display methods
    public void displayGlossaryTerms(List<GlossaryTerm> terms) {
        System.out.println("\n--- Current Glossary Terms ---");
        if (terms.isEmpty()) {
            System.out.println("No glossary terms found.");
        } else {
            for (GlossaryTerm term : terms) {
                term.getTermDetails();
            }
        }
    }
    
    public void displayFeedbackStats(int totalFeedback, double averageRating) {
        System.out.println("\n--- Feedback Statistics ---");
        System.out.println("Total feedback entries: " + totalFeedback);
        System.out.println("Average rating: " + String.format("%.2f", averageRating) + "/5");
    }
    
    public void displaySystemStatus(int queueSize, String systemHealth) {
        System.out.println("\n--- System Status ---");
        System.out.println("Jobs in queue: " + queueSize);
        System.out.println("System health: " + systemHealth);
    }
    
    public void displayStaffTasks(List<String> tasks) {
        System.out.println("\n--- Staff Tasks Completed ---");
        if (tasks.isEmpty()) {
            System.out.println("No tasks completed yet.");
        } else {
            for (String task : tasks) {
                System.out.println("✓ " + task);
            }
        }
    }
    
    // Feedback review
    public String getTranslationIdForReview() {
        scanner.nextLine(); // Clear buffer
        System.out.print("Enter translation ID to review: ");
        return scanner.nextLine();
    }
    
    public void displayFeedbackReview(String translationId, int rating, String comments) {
        System.out.println("\n--- Feedback Review ---");
        System.out.println("Translation ID: " + translationId);
        System.out.println("Rating: " + rating + "/5");
        System.out.println("Comments: " + comments);
    }
    
    // Moderation rules
    public String getNewModerationRules() {
        scanner.nextLine(); // Clear buffer
        System.out.print("Enter new moderation rules: ");
        return scanner.nextLine();
    }
    
    public void displayModerationUpdate(String rules) {
        System.out.println("Moderation rules updated to: " + rules);
    }
    
    // Success/error messages
    public void displaySuccess(String message) {
        System.out.println("✅ " + message);
    }
    
    public void displayError(String message) {
        System.out.println("❌ Error: " + message);
    }
    
    public void displayInfo(String message) {
        System.out.println("ℹ️ " + message);
    }
    
    // Utility method to clear buffer
    public void clearBuffer() {
        scanner.nextLine();
    }
}