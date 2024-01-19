import org.example.GestionTache;
import org.example.Projet;
import org.example.Tache;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ProjetTest {

    private Tache tachetest = new Tache("tester", "tache de test", false);
    private ArrayList<Tache> taches = new ArrayList<Tache>();
    private Projet projet = new Projet("projet_test", taches);

    @BeforeEach
    public void setup() {
        System.out.println("Taches présentes : " + projet.getTaches());
        System.out.println("Ajout de la tache de test");
        projet.ajouterClasseTache(tachetest);
        projet.ajouterTache("tache test 2", "tache de test 2");
        System.out.println("Taches présentes : " + projet.getTaches());
    }

    @AfterEach
    public void reset() {
        System.out.println("Nettoyage du tableau de taches");
        this.projet.resetTaches();
        System.out.println("Taches : " + projet.getTaches() + "\n");
    }

    @Test
    public void projetAjout() {
        assertTrue(projet.ajouterTache("titre ajout", "test de l'ajout"));
        System.out.println(this.projet.getTaches());
    }

    @Test
    public void projetAddClass() {
        assertTrue(projet.ajouterClasseTache(tachetest));
        System.out.println(this.projet.getTaches());
    }

    @Test
    public void projetCompleterTache() {
        assertEquals(0, this.projet.completerTache("tester"));
    }

    @Test
    public void projetCompleterTacheInexistante() {
        assertEquals(-1, this.projet.completerTache("tache inexistante"));
    }

    @Test
    void projetVerifierTacheExistante() {
        assertNotNull(projet.verifierTache("tester"), "La tâche devrait être trouvée.");
        assertEquals("tester", projet.verifierTache("tester").getTitre(), "Le titre de la tâche devrait être 'Tâche 1'.");
    }

    @Test
    void projetVerifierTacheInexistante() {
        assertNull(projet.verifierTache("tache supraluminique"), "La tâche ne devrait pas être trouvée.");
    }

}