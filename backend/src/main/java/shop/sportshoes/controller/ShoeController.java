package shop.sportshoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.sportshoes.model.Shoe;
import shop.sportshoes.model.ShoeDto;
import shop.sportshoes.repository.ShoeRepository;
import shop.sportshoes.service.ShoeService;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shoes")
public class ShoeController {

    @Autowired
    private ShoeService shoeService;

    @GetMapping
    public ResponseEntity<?> getAllShoes() {
        try {
            List<Shoe> shoes = shoeService.getAllShoes();
            System.out.println("SHOES" + shoes);
            return ResponseEntity.ok("TEST");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<String> createShoe(@ModelAttribute ShoeDto shoeDto) {
        System.out.println(shoeDto.toString());
        try {
            return ResponseEntity.ok(shoeService.saveImageStorage(shoeDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
