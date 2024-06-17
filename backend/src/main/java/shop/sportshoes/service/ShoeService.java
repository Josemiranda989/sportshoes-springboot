package shop.sportshoes.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import shop.sportshoes.model.Shoe;
import shop.sportshoes.model.ShoeDto;
import shop.sportshoes.repository.ShoeRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Service
public class ShoeService {

    @Autowired
    private ShoeRepository shoeRepository;

    private static final Logger logger = LoggerFactory.getLogger(Shoe.class);

    private static final Path ROOT_LOCATION = Paths.get("src/main/resources/static/images");

    private String sanitizeFilename(String filename) {
        return filename.replaceAll("[^a-zA-Z0-9\\.\\-]", "_");
    }

    public List<Shoe> getAllShoes() throws Exception {
        try {
            return shoeRepository.findAll();
        } catch (Exception e) {
            throw new Exception("Failed to retrieve shoes: " + e.getMessage(), e);
        }
    }

    public String saveImageStorage(ShoeDto shoeDto) throws IOException {

        MultipartFile file = shoeDto.getImage();

        if (file.isEmpty()) {
            throw new IOException("Failed to store empty file.");
        }

        if (!Files.exists(ROOT_LOCATION)) {
            Files.createDirectories(ROOT_LOCATION);
        }

        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null) {
            throw new IOException("Name of file invalid");
        }

        String sanitizedFilename = sanitizeFilename(originalFilename);
        String fileName = UUID.randomUUID().toString() + "_" + sanitizedFilename;
        Path destinationFile = ROOT_LOCATION.resolve(Paths.get(fileName));

        try {
            Files.copy(file.getInputStream(),destinationFile);
        } catch (IOException e) {
            throw new IOException("Failed to store file " + fileName, e);
        }

        String fullPath = destinationFile.toAbsolutePath().toString();

        try {
            Shoe shoe = new Shoe(shoeDto.getName(), shoeDto.getSize(), shoeDto.getQuantity(), fullPath);
            shoeRepository.save(shoe);
        } catch (Exception e) {
            throw new IOException("Failed to save image URL to database: " + e.getMessage(), e);
        }

        return fullPath;
    }

}
