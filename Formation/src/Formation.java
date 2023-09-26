import java.util.HashMap;
import java.util.HashSet;

public class Formation {

    private String identifiant;

    private HashMap<String, Double> coefs;

    public  Formation(String id){
        this.identifiant = id;
        this.coefs = new HashMap<String, Double>();
    }

    public void ajouterFormation(String matiere, Double coef){
        if(!this.coefs.containsKey(matiere)){
            this.coefs.put(matiere, coef);
        }
    }

    public void supprimerFormation(String matiere) {

        this.coefs.remove(matiere);
    }

    public Double avoirCoef(String matiere) throws MatiereNotFoundException{
        Double valeur;
        if (!this.coefs.containsKey(matiere)){
            throw new MatiereNotFoundException("Matiere introuvable");
        }else{
            valeur = this.coefs.get(matiere);
        }
        return valeur;
    }

    public HashMap<String, Double> getCoefs() {
        return coefs;
    }
}
