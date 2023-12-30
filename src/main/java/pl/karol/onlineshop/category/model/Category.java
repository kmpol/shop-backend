package pl.karol.onlineshop.category.model;

import jakarta.persistence.*;
import lombok.Getter;
import pl.karol.onlineshop.product.model.Product;

import java.util.List;

@Entity
@Getter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String slug;
}
