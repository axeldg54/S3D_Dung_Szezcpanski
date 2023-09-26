import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void test_adjEtudiant_ok() throws FormationNotEqualsException, EtudiantException {
        groupe.adjEtudiant(etudiant1);
        assertEquals(groupe.getEtudiants().size(), 1);
        assertEquals(groupe.getEtudiants().get(0).getIdentite().getNip(), "N01");
        assertEquals(groupe.getEtudiants().get(0).getIdentite().getNom(), "Dung");
        assertEquals(groupe.getEtudiants().get(0).getIdentite().getPrenom(), "Axel");
    }

    @Test
    public void test_adjEtudiant_FormationNotEqualsException() throws FormationNotEqualsException, EtudiantException {
        groupe.adjEtudiant(etudiant1);
        boolean exception = false;
        try {
            groupe.adjEtudiant(etudiant2);
        } catch (FormationNotEqualsException e) {
            exception = true;
        }
        assertTrue(exception);
    }

    @Test
    public void test_adjEtudiant_EtudiantException() throws FormationNotEqualsException, EtudiantException {
        groupe.adjEtudiant(etudiant1);
        boolean exception = false;
        try {
            groupe.adjEtudiant(etudiant1);
        } catch (EtudiantException e) {
            exception = true;
        }
        assertTrue(exception);
    }

    @Test
    public void test_supEtudiant_ok() throws FormationNotEqualsException, EtudiantException {
        groupe.adjEtudiant(etudiant1);
        groupe.supEtudiant(etudiant1);
        assertEquals(groupe.getEtudiants().size(), 0);
    }

    @Test
    public void test_supEtudiant_EtudiantException() throws FormationNotEqualsException, EtudiantException {
        groupe.adjEtudiant(etudiant1);
        boolean exception = false;
        try {
            groupe.supEtudiant(etudiant2);
        } catch (EtudiantException e) {
            exception = true;
        }
        assertTrue(exception);
    }
}
