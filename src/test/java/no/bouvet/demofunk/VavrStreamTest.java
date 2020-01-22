package no.bouvet.demofunk;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class VavrStreamTest {

    @Test
    public void jdkStream() {
        Stream<String> jdkStream = Stream.of("Per", "Hans", "Anne", "Sofie");

        jdkStream.forEach(String::toUpperCase);
        jdkStream.forEach(String::toLowerCase);
    }

    @Test
    public void vavrStream() {
        io.vavr.collection.Stream<String> vavrStream =  io.vavr.collection.Stream.of("Per", "Hans", "Anne", "Sofie");

        vavrStream.forEach(String::toUpperCase);
        vavrStream.forEach(String::toLowerCase);
    }
}
