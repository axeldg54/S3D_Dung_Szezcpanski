import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

<<<<<<< HEAD
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
=======
    public void triAlpha() {
        Collections.sort(etudiants, new Comparator<Etudiant>() {
            @Override
            public int compare(Etudiant etudiant1, Etudiant etudiant2) {
                String nom1 = etudiant1.getIdentite().getNom();
                String nom2 = etudiant2.getIdentite().getNom();
                return nom1.compareTo(nom2);
            }
        });
    }

    public void triAntiAlpha() {
        Collections.sort(etudiants, new Comparator<Etudiant>() {
            @Override
            public int compare(Etudiant etudiant1, Etudiant etudiant2) {
                String nom1 = etudiant1.getIdentite().getNom();
                String nom2 = etudiant2.getIdentite().getNom();
                return nom2.compareTo(nom1);
            }
        });
>>>>>>> 209176bfc0c1cf28ba1ce3843f1917581a094cf2
    }

    public ArrayList<Etudiant> getEtudiants() {
        return etudiants;
    }
}
