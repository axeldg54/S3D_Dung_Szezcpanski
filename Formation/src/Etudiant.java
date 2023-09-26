import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Etudiant extends HashMap {
    private Identite identite;
    private HashMap<String, ArrayList<Double>> resultas;
    private Formation formation;

    public Etudiant(Identite identite, Formation formation) {
        this.identite = identite;
        this.formation = formation;
        resultas = new HashMap<String, ArrayList<Double>>();
    }

    public void adjNote (String matiere, double note) throws MatiereNotFoundException, NoteWrongIntervalException {
        if (!resultas.containsKey(matiere)) throw new MatiereNotFoundException("erreur : matière non trouvée");
        if (note > 20 || note < 0) throw new NoteWrongIntervalException("erreur : note doit se situer entre 0 et 20");
        resultas.get(matiere).add(note);
    }

    public double calcMoy(String matiere) throws MatiereNotFoundException{
        if (!resultas.containsKey(matiere)) throw new MatiereNotFoundException("erreur : matière non trouvée");
        double moy = 0;
        for (double i : resultas.get(matiere)) {
            moy += i;
        }
        moy /= resultas.get(matiere).size();
        return moy;
    }

    public double calcMoyG() throws MatiereNotFoundException {
        double moyg = 0;
        for (String m : resultas.keySet()) {
            moyg += calcMoy(m) * formation.getCoefs().get(m);
        }
        return moyg;
    }

    public HashMap<String, ArrayList<Double>> getResultas() {
        return resultas;
    }

    public Identite getIdentite() {
        return identite;
    }

    public Formation getFormation() {
        return formation;
    }
}
