import java.util.Objects;

public class Identite {
    private String nip;
    private String nom;
    private String prenom;

    public Identite(String nip, String nom, String prenom) {
        this.nip = nip;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNip() {
        return nip;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Identite) return ((Identite) o).getNip().equals(nip);
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nip, nom, prenom);
    }
}
