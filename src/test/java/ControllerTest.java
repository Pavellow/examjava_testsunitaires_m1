import org.example.GestionTache;
import org.example.Projet;
import org.example.Tache;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class ControllerTest {
    private ArrayList<Tache> taches = new ArrayList<Tache>();
    private Projet projet = new Projet("projet_test", taches);
    private Controller controller = new Controller(projet);

    @BeforeEach
    public void setup() {
        Tache tache1 = new Tache("tache1", "desc1", false, 1.0);
        Tache tache2 = new Tache("tache2", "desc2", false, 2.0);
        Tache tache3 = new Tache("tache3", "desc3", false, 3.5);
        projet.ajouterClasseTache(tache1);
        projet.ajouterClasseTache(tache2);
        projet.ajouterClasseTache(tache3);
    }

    @AfterEach
    public void reset() {
        projet.getTaches().clear();
    }

    @Test
    public void getAllTasks() {
        assertEquals(projet.getTaches(), controller.getAllTasks(projet));
        assertEquals(controller.getAllTasks(projet), projet.getTaches());
    }

    @Test
    public void getTask() {
        //
    }
}
