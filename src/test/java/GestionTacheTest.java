import org.example.GestionTache;
import org.example.Projet;
import org.example.Tache;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GestionTacheTest {

    private Tache tachetest = new Tache("tester", "tache de test", false, 2.0);
    private ArrayList<Tache> taches = new ArrayList<Tache>();
    private Projet projet = new Projet("projet_test", taches);
    private GestionTache gt = new GestionTache(projet);

    @BeforeEach
    public void setup() {
        System.out.println("Taches présentes : " + gt.getTaches());
        System.out.println("Ajout de la tache de test");
        gt.ajouterClasseTache(tachetest);
        gt.ajouterTache("tache test 2", "tache de test 2");
        System.out.println("Taches présentes : " + gt.getTaches());
    }

    @AfterEach
    public void reset() {
        System.out.println("Nettoyage du tableau de taches");
        this.gt.resetTaches();
        System.out.println("Taches : " + gt.getTaches() + "\n");
    }

    @Test
    public void gtAjout() {
        assertTrue(gt.ajouterTache("titre ajout", "test de l'ajout"));
        System.out.println(this.gt.getTaches());
    }

    @Test
    public void gtAddClass() {
        assertTrue(gt.ajouterClasseTache(tachetest));
        System.out.println(this.gt.getTaches());
    }

    @Test
    public void gtCompleterTache() {
        assertEquals(0, this.gt.completerTache("tester"));
    }

    @Test
    public void gtCompleterTacheInexistante() {
        assertEquals(-1, this.gt.completerTache("tache inexistante"));
    }

    @Test
    void gtVerifierTacheExistante() {
        assertNotNull(gt.verifierTache("tester"), "La tâche devrait être trouvée.");
        assertEquals("tester", gt.verifierTache("tester").getTitre(), "Le titre de la tâche devrait être 'Tâche 1'.");
    }

    @Test
    void gtVerifierTacheInexistante() {
        assertNull(gt.verifierTache("tache supraluminique"), "La tâche ne devrait pas être trouvée.");
    }

}
