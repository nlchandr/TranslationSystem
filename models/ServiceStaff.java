package models;

import java.util.ArrayList;
import java.util.List;

public class ServiceStaff {
    private String staffId;
    private String role;
    private List<String> assignedTasks;
    
    public ServiceStaff(String staffId, String role) {
        this.staffId = staffId;
        this.role = role;
        this.assignedTasks = new ArrayList<>();
    }
    
    // Glossary Management
    public void addGlossaryTerm(GlossaryManager glossaryManager, String termName, String description, 
                               String targetLanguage, List<GlossaryTerm> equivalentTerms) {
        System.out.println("Staff " + staffId + " adding glossary term: " + termName);
        glossaryManager.addTerm(termName, description, targetLanguage, equivalentTerms);
        assignedTasks.add("Added term: " + termName);
    }
    
    public void updateGlossaryTerm(GlossaryManager glossaryManager, String termName, String description,
                                  String targetLanguage, List<GlossaryTerm> equivalentTerms) {
        System.out.println("Staff " + staffId + " updating glossary term: " + termName);
        glossaryManager.updateTerm(termName, description, targetLanguage, equivalentTerms);
        assignedTasks.add("Updated term: " + termName);
    }
    
    // Simplified method for common case
    public void addSimpleGlossaryTerm(GlossaryManager glossaryManager, String termName, String translation, String targetLanguage) {
        System.out.println("Staff " + staffId + " adding simple glossary term: " + termName + " -> " + translation);
        
        // Create equivalent terms list with just the translation
        List<GlossaryTerm> equivalentTerms = new ArrayList<>();
        GlossaryTerm equivalent = new GlossaryTerm(translation, "Translation of " + termName, targetLanguage, new ArrayList<>());
        equivalentTerms.add(equivalent);
        
        glossaryManager.addTerm(termName, "Glossary term", targetLanguage, equivalentTerms);
        assignedTasks.add("Added simple term: " + termName);
    }
    
    public void resolveGlossaryConflict(GlossaryManager glossaryManager) {
        System.out.println("Staff " + staffId + " resolving glossary conflicts");
        glossaryManager.resolveConflict();
        assignedTasks.add("Resolved glossary conflicts");
    }
    
    // Quality Moderation Management (basic implementation since class is empty)
    public void updateModerationRules(String newRules) {
        System.out.println("Staff " + staffId + " updating moderation rules: " + newRules);
        // Since QualityModeration is empty, we'll just track the rule updates
        assignedTasks.add("Updated moderation rules: " + newRules);
    }
    
    // Feedback Review
    public void reviewFeedback(FeedbackManager feedbackManager, String translationId) {
        System.out.println("Staff " + staffId + " reviewing feedback for translation: " + translationId);
        
        // Get feedback using your existing FeedbackManager methods
        Feedback feedback = feedbackManager.getFeedback(translationId);
        
        if (feedback != null) {
            System.out.println("Feedback found - Rating: " + feedback.getRating() + "/5");
            System.out.println("Comments: " + feedback.getComments());
            
            // Analyze feedback for patterns
            if (feedback.getRating() < 3) {
                System.out.println("⚠️  Low rating detected - consider glossary updates");
            }
            if (feedback.getComments().toLowerCase().contains("wrong") || 
                feedback.getComments().toLowerCase().contains("incorrect")) {
                System.out.println("⚠️  Translation accuracy issue reported");
            }
        } else {
            System.out.println("No feedback found for translation ID: " + translationId);
        }
        
        assignedTasks.add("Reviewed feedback for: " + translationId);
    }
    
    // Review all feedback in the system
    public void reviewAllFeedback(FeedbackManager feedbackManager) {
        System.out.println("Staff " + staffId + " reviewing all system feedback...");
        
        List<Feedback> allFeedback = feedbackManager.getFeedbackList();
        System.out.println("Total feedback entries: " + allFeedback.size());
        
        int lowRatings = 0;
        for (Feedback feedback : allFeedback) {
            if (feedback.getRating() < 3) {
                lowRatings++;
                System.out.println("Low rating - ID: " + feedback.getTranslationID() + 
                                 ", Rating: " + feedback.getRating());
            }
        }
        
        System.out.println("Summary: " + lowRatings + " low ratings out of " + allFeedback.size() + " total");
        assignedTasks.add("Reviewed all system feedback");
    }
    
    // System Monitoring
    public void monitorSystem(TranslationEngine translationEngine) {
        System.out.println("Staff " + staffId + " monitoring system...");
        
        List<TranslationJob> jobQueue = translationEngine.getJobQueue();
        System.out.println("Current job queue size: " + jobQueue.size());
        
        // Check job statuses using actual TranslationJob methods
        for (TranslationJob job : jobQueue) {
            System.out.println("Job " + job.getJobID() + 
                              " - Status: " + job.getJobStatus() +
                              " - Input: '" + job.getTextInput() + "'" +
                              " - Output: '" + job.getJobResult() + "'");
        }
        
        assignedTasks.add("System monitoring completed");
    }
    
    // View all glossary terms
    public void viewGlossaryTerms(GlossaryManager glossaryManager) {
        System.out.println("Current Glossary Terms (Version: " + glossaryManager.getVersion() + "):");
        List<GlossaryTerm> terms = glossaryManager.getTermList();
        
        if (terms.isEmpty()) {
            System.out.println("No glossary terms found.");
        } else {
            for (GlossaryTerm term : terms) {
                System.out.println(" - " + term.getTermName() + ": " + term.getDescription());
                for (GlossaryTerm equivalent : term.getEquivalentTerms()) {
                    System.out.println("   -> " + equivalent.getTermName() + " (" + equivalent.getTargetLanguage() + ")");
                }
            }
        }
    }
    
    // Clear assigned tasks (for testing/reset)
    public void clearTasks() {
        assignedTasks.clear();
        System.out.println("Tasks cleared for staff: " + staffId);
    }
    
    // Getters
    public String getStaffId() { return staffId; }
    public String getRole() { return role; }
    public List<String> getAssignedTasks() { return assignedTasks; }
}