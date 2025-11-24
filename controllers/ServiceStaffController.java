package controllers;

import models.ServiceStaff;
import models.GlossaryManager;
import models.GlossaryTerm;
import models.FeedbackManager;
import models.TranslationEngine;

import java.util.List;

public class ServiceStaffController {
    private ServiceStaff serviceStaff;
    private GlossaryManager glossaryManager;
    private FeedbackManager feedbackManager;
    private TranslationEngine translationEngine;
    
    public ServiceStaffController(ServiceStaff serviceStaff, GlossaryManager glossaryManager, 
                                 FeedbackManager feedbackManager, TranslationEngine translationEngine) {
        this.serviceStaff = serviceStaff;
        this.glossaryManager = glossaryManager;
        this.feedbackManager = feedbackManager;
        this.translationEngine = translationEngine;
    }
    
    // Glossary Management Methods
    public void handleAddGlossaryTerm(String termName, String description, 
                                     String targetLanguage, List<GlossaryTerm> equivalentTerms) {
        serviceStaff.addGlossaryTerm(glossaryManager, termName, description, targetLanguage, equivalentTerms);
    }
    
    public void handleUpdateGlossaryTerm(String termName, String description,
                                        String targetLanguage, List<GlossaryTerm> equivalentTerms) {
        serviceStaff.updateGlossaryTerm(glossaryManager, termName, description, targetLanguage, equivalentTerms);
    }
    
    // Simplified method for common use case
    public void handleAddSimpleTerm(String termName, String translation, String targetLanguage) {
        serviceStaff.addSimpleGlossaryTerm(glossaryManager, termName, translation, targetLanguage);
    }
    
    public void handleResolveGlossaryConflict() {
        serviceStaff.resolveGlossaryConflict(glossaryManager);
    }
    
    // Quality Moderation Methods
    public void handleUpdateModerationRules(String newRules) {
        serviceStaff.updateModerationRules(newRules);
    }
    
    // Feedback Management Methods
    public void handleReviewFeedback(String translationId) {
        serviceStaff.reviewFeedback(feedbackManager, translationId);
    }
    
    public void handleReviewAllFeedback() {
        serviceStaff.reviewAllFeedback(feedbackManager);
    }
    
    // System Management Methods
    public void handleSystemMonitoring() {
        serviceStaff.monitorSystem(translationEngine);
    }
    
    // View Methods
    public void handleViewGlossaryTerms() {
        serviceStaff.viewGlossaryTerms(glossaryManager);
    }
    
    public void viewStaffTasks() {
        System.out.println("Tasks completed by " + serviceStaff.getStaffId() + " (" + serviceStaff.getRole() + "):");
        List<String> tasks = serviceStaff.getAssignedTasks();
        
        if (tasks.isEmpty()) {
            System.out.println("No tasks completed yet.");
        } else {
            for (String task : tasks) {
                System.out.println(" - " + task);
            }
        }
    }
    
    // Utility Methods
    public void clearStaffTasks() {
        serviceStaff.clearTasks();
    }
    
    // Staff Information
    public void displayStaffInfo() {
        System.out.println("Staff ID: " + serviceStaff.getStaffId());
        System.out.println("Role: " + serviceStaff.getRole());
        System.out.println("Total tasks completed: " + serviceStaff.getAssignedTasks().size());
    }
    
    // Feedback Statistics
    public void displayFeedbackStats() {
        List<models.Feedback> allFeedback = feedbackManager.getFeedbackList();
        System.out.println("Feedback Statistics:");
        System.out.println("Total feedback entries: " + allFeedback.size());
        
        if (!allFeedback.isEmpty()) {
            double averageRating = 0.0;
            for (models.Feedback feedback : allFeedback) {
                averageRating += feedback.getRating();
            }
            averageRating /= allFeedback.size();
            System.out.println("Average rating: " + String.format("%.2f", averageRating) + "/5");
        }
    }
    
    // Getters
    public ServiceStaff getServiceStaff() { return serviceStaff; }
    public GlossaryManager getGlossaryManager() { return glossaryManager; }
    public FeedbackManager getFeedbackManager() { return feedbackManager; }
    public TranslationEngine getTranslationEngine() { return translationEngine; }
}