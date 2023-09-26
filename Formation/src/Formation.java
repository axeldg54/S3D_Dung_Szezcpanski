import java.util.HashMap;

public class Formation {

    private String identifiant;

    private HashMap<String, Integer> coefs;

    public  Formation(String id){
        this.identifiant = id;
        this.coefs = new HashMap<String, Integer>();
    }

    public void ajouterFormation(String matiere, int coef){
        if(!this.coefs.containsKey(matiere)){
            this.coefs.put(matiere, coef);
        }
    }

    public void supprimerFormation(String matiere) {

        this.coefs.remove(matiere);
    }

    public int avoirCoef(String matiere) throws MatiereNotFoundException{
        int valeur = 0;
        if (!this.coefs.containsKey(matiere)){
            throw new MatiereNotFoundException("Matiere introuvable");
        }else{
            valeur = this.coefs.get(matiere);
        }
        return valeur;
    }

    public HashMap<String, Integer> getCoefs() {
        return coefs;
    }
}
