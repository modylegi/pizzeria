//package ru.itis.semesterwork.entities;
//
//import lombok.*;
//
//import javax.persistence.*;
//
//import static javax.persistence.GenerationType.SEQUENCE;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@Builder
//@Entity(name = "Product")
//@Table(name = "products")
//public class DeliveryAddress {
//    @Id
//    @SequenceGenerator(
//            name = "order_sequence",
//            sequenceName = "order_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = SEQUENCE,
//            generator = "order_sequence"
//    )
//    @Column(
//            name = "id"
//    )
//    private Long id;
//
//
//    @Column(
//            name = "address",
//            nullable = false,
//            columnDefinition = "TEXT"
//    )
//    private String address;
//
//}
