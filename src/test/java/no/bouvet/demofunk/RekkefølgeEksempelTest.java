package no.bouvet.demofunk;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class RekkefølgeEksempelTest {

    @Test
    public void rekkefølgeIEnStreamFraEnListeEksempel() {

       String tall = List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")
                .stream()
                .parallel()
                .findFirst()
                .orElse("");

       assertEquals("0", tall);
    }

    @Test
    public void rekkefølgeIEnStreamFraEtHashSetEksempel() {

        String tall = new HashSet<String>(List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"))
                .stream()
                .findFirst()
                .orElse("");

        assertEquals("0", tall);
    }

    @Test
    public void rekkefølgeIEnSammensattStream() {
        String tall = Stream.concat(
                List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9").stream(),
                new HashSet<String>(List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")).stream()
        )
                .findFirst()
                .orElse("");

        assertEquals("0", tall);
    }
}
