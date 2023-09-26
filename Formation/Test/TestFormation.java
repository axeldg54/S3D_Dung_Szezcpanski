import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestFormation {

    private String identifiant;
    private Formation formation;

    @BeforeEach
    public void init() {
        identifiant = "formation1";
        formation = new Formation(identifiant);
    }

    @Test
    public void test_constructeur_ok() {
        assertEquals(formation.getIdentifiant(), "formation1");
    }

    @Test
    public void test_ajouterFormation_ok() {
        formation.ajouterFormation("Mathematiques", 5.0);
        assertEquals(formation.getCoefs().get("Mathematiques"), 5.0);
    }

    @Test
    public void test_supprimerFormation_ok() {
        formation.ajouterFormation("Mathematiques", 5.0);
        formation.supprimerFormation("Mathematiques");
        assertEquals(formation.getCoefs().size(), 0);
    }

    @Test
    public void test_avoirCoef_ok() throws MatiereNotFoundException {
        formation.ajouterFormation("Mathematiques", 5.0);
        assertEquals(formation.avoirCoef("Mathematiques"), 5.0);
    }

    @Test
    public void test_avoirCoef_exception() {
<<<<<<< HEAD
        boolean exception = false;
=======
        Formation formation = new Formation(identifiant);
>>>>>>> e62b7c9aca8fce0ba3d2339cf5710e6cce858bdd
        formation.ajouterFormation("Mathematiques", 5.0);

        assertThrows(MatiereNotFoundException.class, () -> {formation.avoirCoef("francais");});
    }
}
