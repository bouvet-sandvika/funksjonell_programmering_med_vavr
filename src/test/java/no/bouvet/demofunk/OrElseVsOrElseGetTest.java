package no.bouvet.demofunk;

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class OrElseVsOrElseGetTest {

    @Test
    public void eksempel() {
        Optional<String> kanskjeEnTekst = Optional.of("Ja jeg er her");

        String teksten = kanskjeEnTekst
                .map(tekst -> kjørHvisDer(tekst))
                .orElse(kjørHvisIkkeDer());

        System.out.println(teksten);

    }

    String kjørHvisDer(String tekst) {
        System.out.println("Det var noe der");
        return tekst;
    }

    String kjørHvisIkkeDer() {
        System.out.println("Tomt, det var ikke noe der");
        return "Tomt";
    }
}
