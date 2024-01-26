package br.com.shinobi.demo.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @OneToOne
    private String playerName;

    @Column
    private String villageName;

    @Column
    private String title;

}
