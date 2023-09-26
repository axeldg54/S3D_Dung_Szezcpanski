import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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


        assertEquals(etudiant.getResultas().size(), 2);
        assertEquals(etudiant.getResultas().get("francais").size(), 2);

    }
}
