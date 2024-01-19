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

    private Tache tachetest = new Tache("tester", "tache de test", false, 2.0);
    private ArrayList<Tache> taches = new ArrayList<Tache>();
    private Projet projet = new Projet("projet_test", taches);

    @BeforeEach
    public void setup() {
        System.out.println("Taches présentes : " + projet.getTaches());
        projet.getTaches().clear();
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
        Tache tache = new Tache("tache_test", "tache_desc", false, 3.0);
        projet.ajouterClasseTache(tache);
        assertEquals(0, this.projet.completerTache("tache_test"));
    }

    @Test
    public void projetCompleterTacheInexistante() {
        assertEquals(-1, this.projet.completerTache("tache inexistante"));
    }

    @Test
    void projetVerifierTacheExistante() {
        Tache tache = new Tache("tache_test", "tache_desc", false, 3.0);
        projet.ajouterClasseTache(tache);
        assertNotNull(projet.verifierTache("tache_test"), "La tâche devrait être trouvée.");
        assertEquals("tache_test", projet.verifierTache("tache_test").getTitre(), "Le titre de la tâche devrait être 'Tâche 1'.");
    }

    @Test
    void projetVerifierTacheInexistante() {
        assertNull(projet.verifierTache("tache supraluminique"), "La tâche ne devrait pas être trouvée.");
    }

    @Test
    void projetCalculerDureeTotale() {
        Tache tache1 = new Tache("tache1", "tache1desc", false, 2.0);
        Tache tache2 = new Tache("tache2", "tache2desc", false, 1.5);
        Tache tache3 = new Tache("tache3", "tache3desc", false, 3.0);
        projet.ajouterClasseTache(tache1);
        projet.ajouterClasseTache(tache2);
        projet.ajouterClasseTache(tache3);
        assertEquals(6.5, projet.calculerDureeTotale(projet.getTaches()));
        assertNotEquals(13, projet.calculerDureeTotale(projet.getTaches()));
        assertNotEquals(-2, projet.calculerDureeTotale(projet.getTaches()));
    }

}