package no.bouvet.demofunk;

import io.vavr.control.Try;
import no.bouvet.demofunk.domene.Rolle;
import no.bouvet.demofunk.domene.TeamMedlem;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TryEksempelTest {

    @Test
    public void viErIkkeSåGladIKlovner() {
        List<TeamMedlem> brukbare =
                List.of(
                new TeamMedlem(Rolle.Scrum_master, "Rolf"),
                new TeamMedlem(Rolle.Teknisk_arkitekt, "Knut Erik"),
                new TeamMedlem(Rolle.Klovn, "Morten")
        );

                brukbare
                .stream()
                .filter(
                        teamMedlem -> {
                            try {
                                return teamMedlem.valider();
                            } catch (Exception re) {
                                return false;
                            }
                        }
                )
                .collect(Collectors.toList());

        assertEquals(List.of(new TeamMedlem(Rolle.Scrum_master, "Rolf"),
                        new TeamMedlem(Rolle.Teknisk_arkitekt, "Knut Erik")),
                brukbare);

    }












    @Test
    public void viErIkkeSåGladIKlovnerPåEnEnklereMåte() {
        io.vavr.collection.List<TeamMedlem> brukbare =
                io.vavr.collection.List.of( new TeamMedlem(Rolle.Scrum_master, "Rolf"),
                        new TeamMedlem(Rolle.Teknisk_arkitekt, "Knut Erik"),
                        new TeamMedlem(Rolle.Klovn, "Morten")
                );

                brukbare
                .filter(teamMedlem -> Try.of(teamMedlem::valider).getOrElse(false)
                );

        assertEquals(io.vavr.collection.List.of(new TeamMedlem(Rolle.Scrum_master, "Rolf"),
                new TeamMedlem(Rolle.Teknisk_arkitekt, "Knut Erik")),
                brukbare);
    }

}
