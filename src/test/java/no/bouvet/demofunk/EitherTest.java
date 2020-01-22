package no.bouvet.demofunk;
import io.vavr.collection.List;
import io.vavr.control.Either;
import no.bouvet.demofunk.domene.Rolle;
import no.bouvet.demofunk.domene.TeamMedlem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EitherTest {

    @Test
    public void entenEller() {
      List<TeamMedlem> teamTufte = List.of(
                new TeamMedlem(Rolle.Scrum_master, "Rolf"),
                new TeamMedlem(Rolle.Teknisk_arkitekt, "Knut Erik"),
                new TeamMedlem(Rolle.Klovn, "Morten"),
                new TeamMedlem(Rolle.Teknisk_arkitekt, "Unni")
        );

       Either<String, String> enten = størrelseSuntTeam(teamTufte)
               .map(teamantall -> "Et sunt team med " + teamantall + " utviklere");

       System.out.println(enten.isRight() ? enten.get() : enten.getLeft());



    }

    static Either<String, Integer> størrelseSuntTeam(List<TeamMedlem> team) {
        if (team.map(TeamMedlem::getRolle)
            .contains(Rolle.Klovn))
            return Either.left("Vi kan ikke ha klovner med på laget");
        else
            return Either.right(team.size());
    }

}
