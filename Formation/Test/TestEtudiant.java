import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestEtudiant {
    private Formation formation;
    private Etudiant etudiant;

    private Identite identite;

    private String identifiant;

    @BeforeEach
    public void init(){
        identifiant = "AxelDg";
        formation = new Formation(identifiant);
        formation.ajouterFormation("maths", 1.0);
        formation.ajouterFormation("francais", 1.0);
        identite = new Identite("01", "Dung", "Axel");
        etudiant = new Etudiant(identite, formation);
    }

    @Test
    public void testAdjNote_OK() throws NoteWrongIntervalException, MatiereNotFoundException {

        etudiant.adjNote("maths", 10);
        etudiant.adjNote("francais", 8);
        etudiant.adjNote("francais", 18);


        assertEquals(etudiant.getResultats().size(), 2);
        assertEquals(etudiant.getResultats().get("francais").size(), 2);

    }

    @Test
    public void testCalcMoy_OK() throws NoteWrongIntervalException, MatiereNotFoundException {


        etudiant.adjNote("francais", 10);
        etudiant.adjNote("francais", 20);

        double moyenne = etudiant.calcMoy("francais");

        assertEquals(moyenne, 15);
    }


    @Test
    public void testCalcMoyG_OK() throws NoteWrongIntervalException, MatiereNotFoundException{
        etudiant.adjNote("maths", 20);
        etudiant.adjNote("maths", 0);
        etudiant.adjNote("francais", 10);
        etudiant.adjNote("francais", 20);

        double moyenne = etudiant.calcMoyG();

        assertEquals(moyenne, 12.5);

    }

    @Test
    public void test_adjNote_exception() throws NoteWrongIntervalException, MatiereNotFoundException {

        assertThrows(MatiereNotFoundException.class, () -> {etudiant.adjNote("espagnol", 7);});
        assertThrows(NoteWrongIntervalException.class, () -> {etudiant.adjNote("maths", -1);});
        assertThrows(NoteWrongIntervalException.class, () -> {etudiant.adjNote("maths", 21);});

    }

}
