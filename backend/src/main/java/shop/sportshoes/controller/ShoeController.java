package shop.sportshoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import shop.sportshoes.model.Shoe;
import shop.sportshoes.repository.ShoeRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

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
        // Guardar la imagen y obtener su URL
        String imageUrl = saveImage(image);
        // Crear una nueva instancia de Shoe
        Shoe shoe = new Shoe();
        // Establecer los atributos del zapato
        shoe.setName(name);
        shoe.setSize(size);
        shoe.setQuantity(quantity);
        shoe.setImageUrl(imageUrl);
        // Guardar el zapato en la base de datos y devolverlo
        return shoeRepository.save(shoe);
    }

    private String saveImage(MultipartFile image) throws IOException {
        // Obtener la ruta base de la aplicación
        Path baseDir = Paths.get(System.getProperty("user.dir"));
        // Definir la ruta relativa al directorio de imágenes
        Path uploadDir = baseDir.resolve(Paths.get("src", "main", "resources", "static", "images"));
        // Crear el directorio si no existe
        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }
        // Generar un UUID para asegurar que el nombre del archivo sea único
        String originalFilename = image.getOriginalFilename();
        String newFilename = UUID.randomUUID().toString() + "_" + originalFilename;
        // Construir la ruta completa del archivo de imagen
        Path imagePath = uploadDir.resolve(newFilename);
        // Guardar la imagen en el directorio
        Files.copy(image.getInputStream(), imagePath);
        // Retornar la url del recurso estático
        return "/images/" + newFilename;
    }
}
