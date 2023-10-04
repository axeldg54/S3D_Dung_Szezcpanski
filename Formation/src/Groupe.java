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
    }

    public ArrayList<Etudiant> getEtudiants() {
        return etudiants;
    }
}
