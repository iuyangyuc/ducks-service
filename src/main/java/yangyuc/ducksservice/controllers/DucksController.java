package yangyuc.ducksservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import yangyuc.ducksservice.model.Duck;
import yangyuc.ducksservice.repository.DucksRepository;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@CrossOrigin
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
    public boolean addImage(@PathVariable int id, @RequestParam MultipartFile image) throws IOException {
        return DucksRepository.addImage(id, image);
    }

    @GetMapping("/get/{id}/image")
    public ResponseEntity<?> getImage(@PathVariable int id) throws IOException {
        byte[] image = DucksRepository.getImage(id);
        return ResponseEntity.status(HttpStatus.FOUND).contentType(MediaType.IMAGE_PNG).body(image);
    }

    @PostMapping("/add/{id}/audio")
    public boolean addAudio(@PathVariable int id, @RequestParam MultipartFile audio) throws IOException {
        return DucksRepository.addAudio(id, audio);
    }

    @GetMapping("/get/{id}/audio")
    public ResponseEntity<?> getAudio(@PathVariable int id) throws IOException {
        byte[] audio = DucksRepository.getAudio(id);
        return ResponseEntity.status(HttpStatus.FOUND).contentType(MediaType.APPLICATION_OCTET_STREAM).body(audio);
    }
}
