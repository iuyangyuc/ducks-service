package yangyuc.ducksservice.repository;

import org.junit.jupiter.api.Test;
import yangyuc.ducksservice.model.Duck;
import yangyuc.ducksservice.model.Type;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DucksRepositoryTest {

    @Test
    void addDuck() throws IOException {
        Duck.DuckData duck = new Duck.DuckData(1, Type.MALLARD.toString());
        Duck.DuckData duck2 = new Duck.DuckData(2, Type.REDHEAD.toString());
        DucksRepository.addDuck(duck);
        DucksRepository.addDuck(duck2);
        assertEquals(duck, DucksRepository.getDuck(1));
        assertEquals(duck2, DucksRepository.getDuck(2));
    }

    @Test
    void addDuck_2() throws IOException {
        Duck.DuckData duck = new Duck.DuckData(3, Type.RUBBER_DUCK.toString());
        Duck.DuckData duck2 = new Duck.DuckData(4, Type.DECOY_DUCK.toString());
        DucksRepository.addDuck(duck);
        DucksRepository.addDuck(duck2);
        assertEquals(duck, DucksRepository.getDuck(3));
        assertEquals(duck2, DucksRepository.getDuck(4));
    }

    @Test
    void getDuck() throws FileNotFoundException {
        Duck.DuckData duck = new Duck.DuckData(1, Type.MALLARD.toString());
        Duck.DuckData duck2 = new Duck.DuckData(2, Type.REDHEAD.toString());
        assertEquals(duck, DucksRepository.getDuck(1));
        assertEquals(duck2, DucksRepository.getDuck(2));
    }

    @Test
    void getAllDucks() throws FileNotFoundException {
        Duck.DuckData duck = new Duck.DuckData(1, Type.MALLARD.toString());
        Duck.DuckData duck2 = new Duck.DuckData(2, Type.REDHEAD.toString());
        Duck.DuckData duck3 = new Duck.DuckData(3, Type.RUBBER_DUCK.toString());
        Duck.DuckData duck4 = new Duck.DuckData(4, Type.DECOY_DUCK.toString());
        ArrayList<Duck.DuckData> ducks = new ArrayList<>();
        ducks.add(duck);
        ducks.add(duck2);
        ducks.add(duck3);
        ducks.add(duck4);
        assertEquals(ducks, DucksRepository.getAllDucks());
    }

    @Test
    void searchDuck() throws FileNotFoundException {
        Duck.DuckData duck = new Duck.DuckData(1, Type.MALLARD.toString());
        Duck.DuckData duck2 = new Duck.DuckData(2, Type.REDHEAD.toString());
        Duck.DuckData duck3 = new Duck.DuckData(3, Type.RUBBER_DUCK.toString());
        Duck.DuckData duck4 = new Duck.DuckData(4, Type.DECOY_DUCK.toString());
        ArrayList<Duck.DuckData> ducks = new ArrayList<>();
        ducks.add(duck);
        ducks.add(duck2);
        ducks.add(duck3);
        ducks.add(duck4);
        assertEquals(ducks, DucksRepository.searchDuck(new Duck.DuckData(null, null)));
        assertEquals(duck, DucksRepository.searchDuck(new Duck.DuckData(1, null)).get(0));
        assertEquals(duck2, DucksRepository.searchDuck(new Duck.DuckData(null, Type.REDHEAD.toString())).get(0));
    }
}