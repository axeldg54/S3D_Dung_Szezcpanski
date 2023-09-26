import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestGroupe {

    Groupe groupe;
    Etudiant etudiant1, etudiant2, etudiant3;
    Identite identite1, identite2, identite3;
    Formation formation1, formation2;

    @BeforeEach
    public void init() {
        groupe = new Groupe();
        identite1 = new Identite("N01", "Dung", "Axel");
        identite2 = new Identite("N02", "Szezcpanski", "Gaetan");
        identite3 = new Identite("N03", "Jean", "Didi");
        formation1 = new Formation("F1");
        formation2 = new Formation("F2");
        etudiant1 = new Etudiant(identite1, formation1);
        etudiant2 = new Etudiant(identite2, formation2);
        etudiant3 = new Etudiant(identite3, formation1);
    }

    @Test
    public void test_adjEtudiant_ok() throws FormationNotEqualsException, EtudiantException {
        groupe.adjEtudiant(etudiant1);
        assertEquals(groupe.getEtudiants().size(), 1);
        assertEquals(groupe.getEtudiants().get(0).getIdentite().getNip(), "N01");
        assertEquals(groupe.getEtudiants().get(0).getIdentite().getNom(), "Dung");
        assertEquals(groupe.getEtudiants().get(0).getIdentite().getPrenom(), "Axel");
        groupe.adjEtudiant(etudiant3);
        assertEquals(groupe.getEtudiants().size(), 2);
        assertEquals(groupe.getEtudiants().get(1).getIdentite().getNip(), "N03");
        assertEquals(groupe.getEtudiants().get(1).getIdentite().getNom(), "Jean");
        assertEquals(groupe.getEtudiants().get(1).getIdentite().getPrenom(), "Didi");
    }

    @Test
    public void test_adjEtudiant_FormationNotEqualsException() throws FormationNotEqualsException, EtudiantException {
        groupe.adjEtudiant(etudiant1);
        assertThrows(FormationNotEqualsException.class, () -> {groupe.adjEtudiant(etudiant2);});
    }

    @Test
    public void test_adjEtudiant_EtudiantException() throws FormationNotEqualsException, EtudiantException {
        groupe.adjEtudiant(etudiant1);
        assertThrows(EtudiantException.class, () -> {groupe.adjEtudiant(etudiant1);});
    }

    @Test
    public void test_supEtudiant_ok() throws FormationNotEqualsException, EtudiantException {
        groupe.adjEtudiant(etudiant1);
        groupe.adjEtudiant(etudiant3);
        assertEquals(groupe.getEtudiants().size(), 2);
        groupe.supEtudiant(etudiant1);
        assertEquals(groupe.getEtudiants().size(), 1);
    }

    @Test
    public void test_supEtudiant_EtudiantException() throws FormationNotEqualsException, EtudiantException {
        groupe.adjEtudiant(etudiant1);
        assertThrows(EtudiantException.class, () -> {groupe.supEtudiant(etudiant2);});
    }
}
