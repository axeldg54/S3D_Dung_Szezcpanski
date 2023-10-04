import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTri {

    Groupe groupe;
    Etudiant etudiant1, etudiant2, etudiant3;
    Identite identite1, identite2, identite3;
    Formation formation1, formation2;

    @BeforeEach
    public void init() throws FormationNotEqualsException, EtudiantException {
        groupe = new Groupe();
        identite1 = new Identite("N01", "Dung", "Axel");
        identite2 = new Identite("N02", "Szezcpanski", "Gaetan");
        identite3 = new Identite("N03", "Jean", "Didi");
        formation1 = new Formation("F1");
        etudiant1 = new Etudiant(identite1, formation1);
        etudiant2 = new Etudiant(identite2, formation1);
        etudiant3 = new Etudiant(identite3, formation1);
        groupe.adjEtudiant(etudiant1);
        groupe.adjEtudiant(etudiant2);
        groupe.adjEtudiant(etudiant3);
    }

    @Test
    public void TestTriAlpha(){
        groupe.triAlpha();
        assertEquals(groupe.getEtudiants().get(0), etudiant1);
        assertEquals(groupe.getEtudiants().get(1), etudiant3);
        assertEquals(groupe.getEtudiants().get(2), etudiant2);
    }

    public void TestAntiTriAlpha(){
        groupe.triAntiAlpha();
        assertEquals(groupe.getEtudiants().get(0), etudiant2);
        assertEquals(groupe.getEtudiants().get(1), etudiant3);
        assertEquals(groupe.getEtudiants().get(2), etudiant1);
    }
}
