import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Etudiant extends HashMap {
    private Identite identite;
    private HashMap<String, ArrayList<Double>> resultats;
    private Formation formation;

    public Etudiant(Identite identite, Formation formation) {
        this.identite = identite;
        this.formation = formation;
        resultats = new HashMap<String, ArrayList<Double>>();
    }

    public void adjNote (String matiere, double note) throws MatiereNotFoundException, NoteWrongIntervalException {
        if (!formation.getCoefs().containsKey(matiere)) throw new MatiereNotFoundException("erreur : matière non trouvée");
        if (note > 20 || note < 0) throw new NoteWrongIntervalException("erreur : note doit se situer entre 0 et 20");
        if(resultats.containsKey(matiere)) {
            resultats.get(matiere).add(note);
        }else{
            ArrayList<Double> tab = new ArrayList<>();
            tab.add(note);
            resultats.put(matiere, tab);
        }
    }

    public double calcMoy(String matiere) throws MatiereNotFoundException{
        if (!resultats.containsKey(matiere)) throw new MatiereNotFoundException("erreur : matière non trouvée");
        double moy = 0;
        for (double i : resultats.get(matiere)) {
            moy += i;
        }
        moy /= resultats.get(matiere).size();
        return moy;
    }

    public double calcMoyG() throws MatiereNotFoundException {
        double moyg = 0;
        for (String m : resultats.keySet()) {
            moyg += calcMoy(m) * formation.getCoefs().get(m);
        }
        return moyg/resultats.keySet().size();
    }

    public HashMap<String, ArrayList<Double>> getResultats() {
        return resultats;
    }

    public Identite getIdentite() {
        return identite;
    }

    public Formation getFormation() {
        return formation;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Etudiant) return identite.equals(((Etudiant)o).getIdentite());
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), identite, resultats, formation);
    }
}
