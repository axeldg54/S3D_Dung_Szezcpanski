import java.util.ArrayList;

public class Groupe {
    private ArrayList<Etudiant> etudiants;

    public Groupe() {
        etudiants = new ArrayList<Etudiant>();
    }

    public void adjEtudiant(Etudiant e) throws FormationNotEqualsException, EtudiantException {
        if (etudiants.size() == 0) etudiants.add(e);
        else {
            if (etudiants.contains(e)) throw new EtudiantException("erreur : etudiant existe deja");
            if (!e.getFormation().equals(etudiants.get(0).getFormation())) throw new FormationNotEqualsException("erreur : les formations doivent être égales");
            etudiants.add(e);
        }
    }

    public void supEtudiant(Etudiant e) throws EtudiantException {
        if (!etudiants.contains(e)) throw new EtudiantException("erreur : etudiant introuvable");
        etudiants.remove(e);
    }

    public double calcMoy(String matiere) throws MatiereNotFoundException {
        double total = 0;
        for (Etudiant e : etudiants) {
            total += e.calcMoy(matiere);
        }
        return total/etudiants.size();
    }

    public double calcMoyG() throws MatiereNotFoundException {
        double total = 0;
        for (Etudiant e : etudiants) {
            total += e.calcMoyG();
        }
        return total/etudiants.size();
    }

    public ArrayList<Etudiant> getEtudiants() {
        return etudiants;
    }
}
