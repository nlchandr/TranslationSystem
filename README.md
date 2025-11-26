# TranslationSystem
Translation System developed for CPS 731- Intro to Software Engineering. 

Members: Nathan Chandra, Vishal Bharti, Jaysun Simkhada 

The goal of the system is to provide reliable text translation to tourists on the fly. Translations should also take into consideration locale formats for dates, currency and other units, while being culturally appropriate.

Commit 2.1 Changes
Updated Files:
GlossaryTerm
GlossaryManager
TouristUserController
TouristUserUI
(possibly more)

Added/Heavily Modified Files:
TranslationView
TranslationEngine
TranslationJob
Lib/Lingua (for language detection)
Lib/unirest (for language translation)

Use 'git pull' to pull over the latest repository to your computer (probably need to have git installed and already have cloned the repository onto your computer)

**Newly Added Components:**
- **SpeechIO & SpeechIOController** - Complete speech translation pipeline with audio input/output simulation
- **ServiceStaff & ServiceStaffController** - Admin system for glossary management, feedback review, and system monitoring
- **Enhanced MVC Architecture** - Full separation of models, controllers, and views

**Key Features Implemented:**
- Multi-modal translation (text, speech, OCR)
- Automated language detection using Lingua
- LibreTranslate API integration via Unirest
- Glossary management with custom terminology
- Quality moderation system
- User feedback and rating system
- Administrative oversight capabilities
Use 'git pull' to pull over the latest repository to your computer (probably need to have git installed and already have cloned the repository onto your computer)
