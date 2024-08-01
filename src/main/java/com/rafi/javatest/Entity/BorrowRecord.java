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
@Table(name = "borrow_record", schema = "javatest")
public class BorrowRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_borrow")
    private Long idBorrow;

    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "id_inventory")
    private Long idInventory;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "returned")
    private boolean returned;

}
