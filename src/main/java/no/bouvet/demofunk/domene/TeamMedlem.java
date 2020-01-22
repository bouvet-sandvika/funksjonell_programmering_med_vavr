package no.bouvet.demofunk.domene;

import static java.util.Objects.requireNonNull;

public class TeamMedlem {
    private final Rolle rolle;
    private final String navn;

    public TeamMedlem(Rolle rolle, String navn) {
        this.rolle = requireNonNull(rolle);
        this.navn = requireNonNull(navn);
    }

    public Rolle getRolle() {
        return rolle;
    }

    public String getNavn() {
        return navn;
    }

    public boolean valider() {
        if (rolle == Rolle.Klovn)
                throw new IllegalStateException("Kan ikke ha med klovner, " + navn + " er en klovn");
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamMedlem that = (TeamMedlem) o;

        if (rolle != that.rolle) return false;
        return navn != null ? navn.equals(that.navn) : that.navn == null;
    }

    @Override
    public int hashCode() {
        int result = rolle != null ? rolle.hashCode() : 0;
        result = 31 * result + (navn != null ? navn.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TeamMedlem{" +
                "rolle=" + rolle +
                ", navn='" + navn + '\'' +
                '}';
    }
}
