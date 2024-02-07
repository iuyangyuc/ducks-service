package yangyuc.ducksservice.controllers;

import org.springframework.web.bind.annotation.*;
import yangyuc.ducksservice.model.Duck;
import yangyuc.ducksservice.repository.DucksRepository;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/ducks")
public class DucksController {

    private DucksRepository ducksRepository;
    public DucksController(DucksRepository ducksRepository) {
        this.ducksRepository = ducksRepository;
    }

    @GetMapping("/get/{id}")
    public Duck.DuckData getDuck(@PathVariable int id) throws IOException {
        return DucksRepository.getDuck(id);
    }

    @GetMapping("/getall")
    public ArrayList<Duck.DuckData> getAllDucks() throws IOException {
        return DucksRepository.getAllDucks();
    }

    @PostMapping("/add")
    public boolean addDuck(@RequestBody Duck.DuckData duck) throws IOException{
        return DucksRepository.addDuck(duck);
    }

    @GetMapping("/search")
    public ArrayList<Duck.DuckData> searchDuck(@RequestParam(required = false) Integer id, @RequestParam(required = false) String type) throws IOException {
        Duck.DuckData conditionDuck = new Duck.DuckData(id, type);
        return DucksRepository.searchDuck(conditionDuck);
    }

    @PostMapping("/add/{id}/image")
    public boolean addImage(@PathVariable int id, @RequestParam String image) {
        return false;
    }

    @GetMapping("/get/{id}/image")
    public String getImage(@PathVariable int id) {
        return null;
    }

    @PostMapping("/add/{id}/audio")
    public boolean addAudio(@PathVariable int id, @RequestParam String audio) {
        return false;
    }

    @GetMapping("/get/{id}/audio")
    public String getAudio(@PathVariable int id) {
        return null;
    }
}
