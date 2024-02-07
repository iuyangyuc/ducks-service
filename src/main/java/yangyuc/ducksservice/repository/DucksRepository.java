package yangyuc.ducksservice.repository;

import org.springframework.stereotype.Component;
import yangyuc.ducksservice.model.Duck;
import yangyuc.ducksservice.model.Type;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

@Component
public class DucksRepository {
    private static final String DATABASE_NAME = "ducks.txt";

    private static ArrayList<Duck.DuckData> buildDuckList() throws FileNotFoundException {
        ArrayList<Duck.DuckData> duckList = new ArrayList<>();
        File file = new File(DATABASE_NAME);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String[] parts = scanner.nextLine().split(",");
            Duck.DuckData duck = new Duck.DuckData(Integer.parseInt(parts[0]), parts[1].toUpperCase());
            duckList.add(duck);
        }
        return duckList;
    }

    public static Duck.DuckData getDuck(int id) throws FileNotFoundException{
        ArrayList<Duck.DuckData> duckList = buildDuckList();
        for (Duck.DuckData duck : duckList) {
            if (duck.id() == id) {
                return duck;
            }
        }
        return null;
    }

    public static boolean addDuck(Duck.DuckData duck) throws IOException {
        Files.write(Path.of(DATABASE_NAME),
                (duck.id() + "," + duck.type().toString() + System.lineSeparator()).getBytes(),
                java.nio.file.StandardOpenOption.APPEND);
        return true;
    }

    public static ArrayList<Duck.DuckData> getAllDucks() throws FileNotFoundException {
        return buildDuckList();
    }

    public static ArrayList<Duck.DuckData> searchDuck(Duck.DuckData conditionDuck) throws FileNotFoundException {
        ArrayList<Duck.DuckData> result = new ArrayList<>();
        ArrayList<Duck.DuckData> allDucks = buildDuckList();
        for(Duck.DuckData duck : allDucks) {
            if((conditionDuck.id() == null || duck.id().equals(conditionDuck.id())) &&
               (conditionDuck.type() == null || duck.type().equals(conditionDuck.type()))) {
                result.add(duck);
            }
        }
        return result;
    }

    public static boolean addImage(int id, String image) {
        return false;
    }

    public static String getImage(int id) {
        return null;
    }

    public static boolean addAudio(int id, String audio) {
        return false;
    }

    public static String getAudio(int id) {
        return null;
    }
}
