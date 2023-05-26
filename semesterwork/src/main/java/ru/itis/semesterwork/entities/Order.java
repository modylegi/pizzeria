package ru.itis.semesterwork.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "Order")
@Table(name = "orders")
public class Order {

    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "order_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;

    @Column(
            name = "created_at",
            nullable = false,
            columnDefinition = "DATE"
    )
    private LocalDateTime time;
    @JsonIgnore
    @ManyToMany
    @JoinColumn(name = "product_id")
    private List<Product> products;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_email")
    private User user;


    @Column(
            name = "address",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String address;
}
