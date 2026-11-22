package ht.mbds.tarrouzi.tp3.llm;

import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GuideTouristiqueService {

    private GuideTouristique guide;

    @PostConstruct
    void initialiser() {
        var modele = GoogleGenAiChatModel.builder()
                .apiKey(System.getenv("GEMINI_API_KEY"))
                .modelName("gemini-3.5-flash")
                .build();

        guide = AiServices.create(GuideTouristique.class, modele);
    }

    public String conseiller(String lieu,int nb) {
        String message = "Lieu demandé : %s. Propose exactement %d endroits à visiter."
                .formatted(lieu, nb);
        String reponse = guide.conseiller(message);
        return reponse;}
    }
