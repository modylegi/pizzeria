package ru.itis.semesterwork.entities;

import lombok.*;
import org.hibernate.Hibernate;
import ru.itis.semesterwork.security.token.Token;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;
import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "User")
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "user_email_unique", columnNames = "email")
        }
)
public class User  {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "user_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;

    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @Email()
    private String email;

    @Column(
            name = "age",
            nullable = false,
            columnDefinition = "INTEGER"

    )
    private Integer age;

    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "TEXT"

    )
    private String password;
    @Enumerated(EnumType.STRING)
    @NonNull
    private UserRole userRole;
    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private List<Token> tokens;
    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<Order> order;





    public User(String firstName,
                String lastName,
                String email,
                Integer age,
                String password,
                UserRole userRole
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.password = password;
        this.userRole = userRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return getId() != null && Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
