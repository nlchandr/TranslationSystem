package views;

import java.util.Scanner;

public class SpeechIOView {
    private Scanner scanner;
    
    public SpeechIOView() {
        this.scanner = new Scanner(System.in);
    }
    
    // Main speech translation menu
    public int showSpeechMenu() {
        System.out.println("\n=== Speech Translation ===");
        System.out.println("1. Translate Speech from Audio File");
        System.out.println("2. Record and Translate (Simulated)");
        System.out.println("3. Play Translated Audio");
        System.out.println("4. Back to Main Menu");
        System.out.print("Choose option: ");
        return scanner.nextInt();
    }
    
    // Input methods
    public String getAudioFilePath() {
        scanner.nextLine(); // Clear buffer
        System.out.print("Enter audio file path (or 'demo' for demo): ");
        return scanner.nextLine();
    }
    
    public String getTargetLanguage() {
        System.out.print("Enter target language (en, fr, es, de, etc.): ");
        return scanner.nextLine();
    }
    
    public int getRecordingDuration() {
        System.out.print("Enter recording duration (seconds): ");
        return scanner.nextInt();
    }
    
    // Display methods for speech translation process
    public void displaySpeechToTextProgress(String audioFile) {
        System.out.println("🎤 Converting speech to text from: " + audioFile);
    }
    
    public void displayTranscribedText(String transcribedText) {
        System.out.println("📝 Transcribed text: " + transcribedText);
    }
    
    public void displayLanguageDetection(String detectedLanguage) {
        System.out.println("🌐 Detected language: " + detectedLanguage);
    }
    
    public void displayTranslationProgress() {
        System.out.println("🔄 Translating text...");
    }
    
    public void displayTranslatedText(String translatedText) {
        System.out.println("📄 Translated text: " + translatedText);
    }
    
    public void displayTextToSpeechProgress() {
        System.out.println("🔊 Converting text to speech...");
    }
    
    public void displayAudioOutput(String audioFilePath) {
        System.out.println("🎧 Audio output saved to: " + audioFilePath);
    }
    
    // Recording simulation
    public void displayRecordingProgress(int duration) {
        System.out.println("⏺️  Recording audio for " + duration + " seconds...");
        System.out.print("Recording: [");
        for (int i = 0; i < duration; i++) {
            System.out.print("█");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Continue
            }
        }
        System.out.println("] Complete!");
    }
    
    // Playback simulation
    public void displayPlaybackProgress(String audioFile) {
        System.out.println("▶️  Playing audio: " + audioFile);
        System.out.print("Playing: [██████████]");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // Continue
        }
        System.out.println(" Done!");
    }
    
    // Complete speech translation result
    public void displaySpeechTranslationResult(String originalAudio, String transcribed, 
                                             String translated, String outputAudio) {
        System.out.println("\n--- Speech Translation Complete ---");
        System.out.println("Original audio: " + originalAudio);
        System.out.println("Transcribed: " + transcribed);
        System.out.println("Translated: " + translated);
        System.out.println("Output audio: " + outputAudio);
        System.out.println("-----------------------------------");
    }
    
    // Demo file options
    public void displayDemoOptions() {
        System.out.println("\n--- Demo Audio Options ---");
        System.out.println("Using demo files with pre-recorded phrases:");
        System.out.println("• 'demo_french_audio.wav' - French greeting");
        System.out.println("• 'demo_spanish_audio.wav' - Spanish greeting"); 
        System.out.println("• 'demo_german_audio.wav' - German greeting");
        System.out.println("• Any other name - English greeting");
    }
    
    // Confirmation prompts
    public boolean confirmPlayAudio() {
        scanner.nextLine(); // Clear buffer
        System.out.print("Play translated audio? (y/n): ");
        String choice = scanner.nextLine();
        return choice.equalsIgnoreCase("y");
    }
    
    public boolean confirmDeleteAudio() {
        System.out.print("Delete audio files after playback? (y/n): ");
        String choice = scanner.nextLine();
        return choice.equalsIgnoreCase("y");
    }
    
    // Error messages
    public void displayAudioError(String message) {
        System.out.println("❌ Audio error: " + message);
    }
    
    public void displayTranscriptionError() {
        System.out.println("❌ Could not transcribe audio file");
    }
    
    public void displayTranslationError() {
        System.out.println("❌ Translation failed");
    }
    
    public void displayTtsError() {
        System.out.println("❌ Text-to-speech conversion failed");
    }
    
    // Success messages
    public void displayRecordingSuccess(String filePath) {
        System.out.println("✅ Recording saved to: " + filePath);
    }
    
    public void displayPlaybackComplete() {
        System.out.println("✅ Playback completed successfully");
    }
    
    // Utility method to clear buffer
    public void clearBuffer() {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}