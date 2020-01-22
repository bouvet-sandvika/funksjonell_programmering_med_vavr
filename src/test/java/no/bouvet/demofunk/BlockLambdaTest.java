package no.bouvet.demofunk;

import no.bouvet.demofunk.domene.Rolle;
import no.bouvet.demofunk.domene.Team;
import no.bouvet.demofunk.domene.TeamMedlem;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toList;

public class BlockLambdaTest {

    private final List<Team> teams = List.of(
            new Team(
                    "Tufte",
                    List.of(
                            new TeamMedlem(Rolle.Scrum_master, "Rolf"),
                            new TeamMedlem(Rolle.Teknisk_arkitekt, "Knut Erik"),
                            new TeamMedlem(Rolle.Klovn, "Morten"),
                            new TeamMedlem(Rolle.Teknisk_arkitekt, "Unni")
                    )
            )
    );

    @Test
    public void alleAktiveRollerBlock() {
        teams.stream()
                .flatMap(
                        team -> {
                            List<Rolle> roller =  team.getMedlemmer()
                                    .stream()
                                    .map(TeamMedlem::getRolle)
                                    .collect(toList());

                            return roller.stream().
                                    map(Rolle::name);
                        }
                )
               .distinct()
               .forEach(
                       rolle -> System.out.println(rolle)
               );
    }

    @Test
    public void alleAktiveRoller() {
        teams.stream()
                .flatMap(team -> team.getMedlemmer().stream())
                .map(TeamMedlem::getRolle)
                .map(Rolle::name)
                .distinct()
                .forEach(
                        rolle -> System.out.println(rolle)
                );
    }

}
