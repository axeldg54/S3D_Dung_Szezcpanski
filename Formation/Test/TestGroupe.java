import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.Normalizer;

public class TestGroupe {

    Groupe groupe;
    Etudiant etudiant1, etudiant2;
    Identite identite1, identite2;
    Formation formation1, formation2;

    @BeforeEach
    public void init() {
        groupe = new Groupe();
        identite1 = new Identite("N01", "Dung", "Axel");
        identite2 = new Identite("N02", "Szezcpanski", "Gaetan");
        formation1 = new Formation("F1");
        formation2 = new Formation("F2");
        etudiant1 = new Etudiant(identite1, formation1);
        etudiant2 = new Etudiant(identite2, formation2);
    }

    @Test
    public void test_adjEtudiant_ok() throws FormationNotEqualsException {
        groupe.adjEtudiant(etudiant1);
    }
}
