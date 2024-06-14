package shop.sportshoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import shop.sportshoes.model.Shoe;
import shop.sportshoes.repository.ShoeRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/shoes")
public class ShoeController {

    @Autowired
    private ShoeRepository shoeRepository;

    @GetMapping
    public List<Shoe> getAllShoes() {
        return shoeRepository.findAll();
    }

    @PostMapping
    public Shoe createShoe(@RequestParam String name,
                           @RequestParam int size,
                           @RequestParam int quantity,
                           @RequestParam("image") MultipartFile image) throws IOException {
        String imageUrl = saveImage(image);
        Shoe shoe = new Shoe();
        shoe.setName(name);
        shoe.setSize(size);
        shoe.setQuantity(quantity);
        shoe.setImageUrl(imageUrl);
        return shoeRepository.save(shoe);
    }

    private String saveImage(MultipartFile image) throws IOException {
        String uploadDir = "images/";
        File uploadDirFile = new File(uploadDir);
        if (!uploadDirFile.exists()) {
            uploadDirFile.mkdirs();
        }
        String imagePath = uploadDir + image.getOriginalFilename();
        File imageFile = new File(imagePath);
        image.transferTo(imageFile);
        return imagePath;
    }
}
