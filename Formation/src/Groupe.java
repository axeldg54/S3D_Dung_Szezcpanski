import java.util.ArrayList;

public class Groupe {
    private ArrayList<Etudiant> etudiants;

    public Groupe(Formation f) {
        etudiants = new ArrayList<Etudiant>();
    }

    public void adjEtudiant(Etudiant e) throws FormationNotEqualsException {
        if (etudiants.size() == 0) etudiants.add(e);
        else if (!e.getFormation().equals(etudiants.get(0).getFormation())) {
            throw new FormationNotEqualsException("erreur : les formations doivent être égales");
        }
    }
}
