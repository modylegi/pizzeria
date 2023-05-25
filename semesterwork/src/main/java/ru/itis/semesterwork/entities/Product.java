package ru.itis.semesterwork.entities;


import lombok.*;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "Product")
@Table(name = "products")
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "product_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @Column(
            name = "description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String description;

    @Column(
            name = "price",
            nullable = false,
            columnDefinition = "INTEGER"
    )
    private int price;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;

    @Column(
            name = "path_to_photo",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String pathToPhoto;





}
