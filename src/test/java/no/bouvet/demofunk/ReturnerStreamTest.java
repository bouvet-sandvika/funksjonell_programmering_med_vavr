package no.bouvet.demofunk;

import no.bouvet.demofunk.domene.Rolle;
import no.bouvet.demofunk.domene.Team;
import no.bouvet.demofunk.domene.TeamMedlem;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

class ReturnerStreamTest {

    @Test
    public void enStreamKanBrukesKunEnGang() {

        Team team = new Team(
                "Tufte",
                List.of(
                        new TeamMedlem(Rolle.Scrum_master, "Rolf"),
                        new TeamMedlem(Rolle.Teknisk_arkitekt, "Knut Erik"),
                        new TeamMedlem(Rolle.Klovn, "Morten"),
                        new TeamMedlem(Rolle.Teknisk_arkitekt, "Unni")
                )
        );


         alleAktiveRoller(Stream.of(team))
                .forEach(
                        rolle ->System.out.println(rolle)
                );



    }





    Stream<Rolle> alleAktiveRoller(Stream<Team> teams) {
        Stream rolle = teams
                .flatMap(team -> team.getMedlemmer().stream())
                .map(TeamMedlem::getRolle)
                .distinct();

        rolle.forEach(
                rolleITeam -> System.out.println("Vi skal bare ta en titt: " + rolleITeam.toString())
        );

        return rolle;
    }

}