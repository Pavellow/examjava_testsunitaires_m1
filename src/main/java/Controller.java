import org.example.Projet;
import org.example.Tache;

import java.util.ArrayList;

public class Controller {
    private Projet projet;

    public Controller(Projet projet) {
        this.projet = projet;
    }

    public ArrayList<Tache> getAllTasks(Projet projet) {
        return projet.getTaches();
    }

    public Tache getTask(String titre) {
        for(Tache tache : projet.getTaches()) {
            if(tache.getTitre().equals(titre)) {
                return tache;
            }
        }
        return null;
    }
}
