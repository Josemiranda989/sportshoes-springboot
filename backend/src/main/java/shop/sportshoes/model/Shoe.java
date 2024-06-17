package shop.sportshoes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Shoe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int size;
    private int quantity;
    private String imageUrl;

    public Shoe(String name, int size, int quantity, String imageUrl) {
        this.name = name;
        this.size = size;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
    }

    public Shoe() {
    }

    public Shoe(Long id, String name, int size, int quantity, String imageUrl) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Shoe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", quantity=" + quantity +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
