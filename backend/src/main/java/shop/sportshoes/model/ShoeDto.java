package shop.sportshoes.model;

import org.springframework.web.multipart.MultipartFile;

public class ShoeDto {

    private String name;
    private Integer size;
    private Integer quantity;
    private MultipartFile image;

    public String getName() {
        return name;
    }

    public Integer getSize() {
        return size;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public MultipartFile getImage() {
        return image;
    }

    public ShoeDto(String name, Integer size, Integer quantity, MultipartFile image) {
        this.name = name;
        this.size = size;
        this.quantity = quantity;
        this.image = image;
    }

    @Override
    public String toString() {
        return "ShoeDto{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", quantity=" + quantity +
                ", image=" + image +
                '}';
    }
}
