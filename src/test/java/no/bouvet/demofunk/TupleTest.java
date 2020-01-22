package no.bouvet.demofunk;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.collection.List;
import io.vavr.collection.Stream;
import no.bouvet.demofunk.domene.Rolle;
import no.bouvet.demofunk.domene.Team;
import no.bouvet.demofunk.domene.TeamMedlem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TupleTest {

    @Test
    public void glidelås() {

        List<Rolle> roller = List.of(Rolle.Klovn, Rolle.Scrum_master, Rolle.Utvikler);

        List<String> navn = List.of("Per", "Gro", "Ida");

                roller
                .zip(navn)
                .map(tuppel -> new TeamMedlem(tuppel._1, tuppel._2))
                .forEach(
                    teamMedlem -> System.out.println(teamMedlem)
                );
    }

    @Test
    public void returnereToForskjelligeTing() {
       List<Team> teams =  List.of(
               new Team(
                       "Tufte",
                       java.util.List.of(
                               new TeamMedlem(Rolle.Scrum_master, "Rolf"),
                               new TeamMedlem(Rolle.Teknisk_arkitekt, "Knut Erik"),
                               new TeamMedlem(Rolle.Klovn, "Morten"),
                               new TeamMedlem(Rolle.Teknisk_arkitekt, "Unni")
                       )
               )
       );

       teams
               .map(team ->
                       Tuple.of(
                               team.getTeamNavn(),
                                team.getMedlemmer().size()
                               )
               )
               .forEach(
                       teamTuple -> System.out.println("Team " + teamTuple._1() + " har " + teamTuple._2() + " medlemmer.")
               );
    }

    @Test
    public void slidingWindow() {

       List<Integer> tallrekke =  List.of(1, 2, 1, 2, 1, 2, 1, 2, 1);

            Boolean erkontinuerlig =
                tallrekke
                .sliding(3)
                .map(trippel -> Tuple.of(trippel.get(), trippel.last()))
                .filterNot(par -> par._1() == par._2())
                .isEmpty();

        assertTrue(erkontinuerlig);

    }
}
