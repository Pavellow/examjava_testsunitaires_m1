import org.example.GestionTache;
import org.example.Projet;
import org.example.Tache;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CIProjetGestionTest {

    private Tache tachetest = new Tache("class_tachetest", "tache de test", false, 2.0);
    private ArrayList<Tache> taches = new ArrayList<Tache>();
    private Projet projet = new Projet("projet_test", taches);
    private GestionTache gt = new GestionTache(projet);

    @BeforeEach
    public void setup() {
        System.out.println("Taches présentes dans Gestionnaire : " + gt.getTaches());
        System.out.println("Taches présentes dans Projet : " + projet.getTaches());
        System.out.println("Réinitialisation des tâches dans Projet et Gestionnaire");
        this.projet.resetTaches();
        this.gt.resetTaches();
    }

    @AfterEach
    public void reset() {
        System.out.println("Nettoyage du tableau de tache de Projet et Gestionnaire");
        this.projet.resetTaches();
        this.gt.resetTaches();
        System.out.println("Taches Gestionnaire : " + gt.getTaches() + "\n" + "Taches Projet : " + projet.getTaches() + "\n\n");
    }

    @Test
    public void gtAjout() {
        System.out.println("Début de test");
        assertTrue(gt.ajouterTache("tache_de_test", "test de l'ajout"));
        assertEquals(gt.getTaches(), projet.getTaches());
        assertEquals(projet.getTaches(), gt.getTaches());
        System.out.println("Fin de test");
    }

    @Test
    public void projetAjout() {
        System.out.println("Début de test");
        assertTrue(projet.ajouterTache("tache_de_test", "test de l'ajout"));
        assertEquals(projet.getTaches(), gt.getTaches());
        assertEquals(gt.getTaches(), projet.getTaches());
        System.out.println(projet.getTaches());
    }
    @Test
    public void gtAddClass() {
        System.out.println("Début de test");
        assertTrue(gt.ajouterClasseTache(tachetest));
        assertEquals(gt.getTaches(), projet.getTaches());
        System.out.println(this.gt.getTaches());
        System.out.println("Fin de test");
    }

    @Test
    public void projetAddClass() {
        System.out.println("Début de test");
        assertTrue(projet.ajouterClasseTache(tachetest));
        assertEquals(gt.getTaches(), projet.getTaches());
        assertEquals(projet.getTaches(), gt.getTaches());
        System.out.println("Fin de test");
    }

    @Test
    public void gtCompleterTache() {
        Tache tache = new Tache("class_test", "test", false, 2.0);
        this.gt.ajouterClasseTache(tache);
        assertEquals(0, this.gt.completerTache("class_test"));
        assertEquals(gt.getTaches(), projet.getTaches());
        assertEquals(projet.getTaches(), gt.getTaches());
    }

    @Test
    public void projetCompleterTache() {
        Tache tache = new Tache("class_test", "test", false, 2.0);
        this.projet.ajouterClasseTache(tache);
        assertEquals(0, this.gt.completerTache("class_test"));
        assertEquals(gt.getTaches(), projet.getTaches());
        assertEquals(projet.getTaches(), gt.getTaches());
    }

    @Test
    public void gtCompleterTacheInexistante() {
        Tache tache = new Tache("tache_1", "tache_1", false, 2.0);
        gt.ajouterClasseTache(tache);
        assertEquals(-1, this.gt.completerTache("tache inexistante"));
        assertEquals(gt.getTaches(), projet.getTaches());
        assertEquals(projet.getTaches(), gt.getTaches());
    }

    @Test
    public void projetCompleterTacheInexistante() {
        Tache tache = new Tache("tache_1", "tache_1", false, 2.0);
        projet.ajouterClasseTache(tache);
        assertEquals(-1, this.gt.completerTache("tache inexistante"));
        assertEquals(gt.getTaches(), projet.getTaches());
        assertEquals(projet.getTaches(), gt.getTaches());
    }

    @Test
    void gtVerifierTacheExistante() {
        Tache tache = new Tache("tache_1", "tache de test", false, 2.0);
        gt.ajouterClasseTache(tache);
        assertNotNull(gt.verifierTache("tache_1"), "La tâche devrait être trouvée.");
        assertEquals("tache_1", gt.verifierTache("tache_1").getTitre(), "Le titre de la tâche devrait être 'Tâche 1'.");
        assertEquals(gt.getTaches(), projet.getTaches());
        assertEquals(projet.getTaches(), gt.getTaches());
    }

    @Test
    void projetVerifierTacheExistante() {
        Tache tache = new Tache("tache_1", "tache de test", false, 2.0);
        projet.ajouterClasseTache(tache);
        assertNotNull(projet.verifierTache("tache_1"), "La tâche devrait être trouvée.");
        assertEquals("tache_1", projet.verifierTache("tache_1").getTitre(), "Le titre de la tâche devrait être 'Tâche 1'.");
        assertEquals(gt.getTaches(), projet.getTaches());
        assertEquals(projet.getTaches(), gt.getTaches());
    }

    @Test
    void gtVerifierTacheInexistante() {
        Tache tache = new Tache("tache_1", "tache de test", false, 2.0);
        gt.ajouterClasseTache(tache);
        assertNull(gt.verifierTache("tache_inexistante"), "La tâche devrait pas être trouvée.");
        assertEquals("tache_1", gt.verifierTache("tache_1").getTitre(), "Le titre de la tâche devrait être 'Tâche 1'.");
        assertEquals(gt.getTaches(), projet.getTaches());
        assertEquals(projet.getTaches(), gt.getTaches());
    }

    @Test
    void projetVerifierTacheInexistante() {
        Tache tache = new Tache("tache_1", "tache de test", false, 2.0);
        projet.ajouterClasseTache(tache);
        assertNull(projet.verifierTache("tache_inexistante"), "La tâche devrait pas être trouvée.");
        assertEquals("tache_1", projet.verifierTache("tache_1").getTitre(), "Le titre de la tâche devrait être 'Tâche 1'.");
        assertEquals(gt.getTaches(), projet.getTaches());
        assertEquals(projet.getTaches(), gt.getTaches());
    }

    @Test
    void projetCalculerDureeTotale() {
        Tache tache = new Tache("tache_1", "tache de test", false, 2.0);
        projet.ajouterClasseTache(tache);
        Tache tache2 = new Tache("tache_2", "tache de test", false, 4.0);
        projet.ajouterClasseTache(tache2);
        Tache tache3 = new Tache("tache_3", "tache de test", false, 1.5);
        projet.ajouterClasseTache(tache3);
        assertEquals(7.5, projet.calculerDureeTotale(projet.getTaches()));
        assertEquals(7.5, projet.calculerDureeTotale(gt.getTaches()));
        assertNotEquals(3, projet.calculerDureeTotale(projet.getTaches()));
        assertNotEquals(3, projet.calculerDureeTotale(gt.getTaches()));
        assertNotEquals(-2, projet.calculerDureeTotale(projet.getTaches()));
        assertNotEquals(-2, projet.calculerDureeTotale(gt.getTaches()));
    }

}
