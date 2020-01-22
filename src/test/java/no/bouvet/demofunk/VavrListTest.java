package no.bouvet.demofunk;

import io.vavr.collection.List;
import org.junit.jupiter.api.Test;

public class VavrListTest {

    @Test
    public void prepend() {
        List<Integer> liste =  List.of(1,2,3);

        System.out.println(liste.tail());
    }




}
