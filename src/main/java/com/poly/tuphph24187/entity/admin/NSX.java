package com.poly.tuphph24187.entity.admin;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "n_s_x")
public class NSX {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String tenNSX;

    public NSX(String ma, String tenNSX) {
        this.ma = ma;
        this.tenNSX = tenNSX;
    }
}
