import java.util.HashMap;
import java.util.Objects;

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
            throw new MatiereNotFoundException("erreur : matière non trouvée");
        }else{
            valeur = this.coefs.get(matiere);
        }
        return valeur;
    }

    public HashMap<String, Double> getCoefs() {
        return coefs;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Formation formation = (Formation) o;
        return Objects.equals(identifiant, formation.identifiant) && Objects.equals(coefs, formation.coefs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifiant, coefs);
    }
}
