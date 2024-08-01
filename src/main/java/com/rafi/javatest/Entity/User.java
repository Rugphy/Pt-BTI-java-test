package com.rafi.javatest.Entity;



import javax.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user", schema = "javatest")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private long idUser;

    @Column(name = "username")
    private String username;

    @Column(name = "role")
    private String role;
}
