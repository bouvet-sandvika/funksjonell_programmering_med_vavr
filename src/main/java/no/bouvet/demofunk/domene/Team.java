package no.bouvet.demofunk.domene;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class Team {
    private final String teamNavn;
    private final List<TeamMedlem> medlemmer;

    public Team(String teamNavn, List<TeamMedlem> medlemmer) {
        this.teamNavn = requireNonNull(teamNavn);
        this.medlemmer = requireNonNull(medlemmer);
    }

    public String getTeamNavn() {
        return teamNavn;
    }

    public List<TeamMedlem> getMedlemmer() {
        return medlemmer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (!teamNavn.equals(team.teamNavn)) return false;
        return medlemmer.equals(team.medlemmer);
    }

    @Override
    public int hashCode() {
        int result = teamNavn.hashCode();
        result = 31 * result + medlemmer.hashCode();
        return result;
    }
}
