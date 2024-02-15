package br.com.shinobi.demo.models;


import br.com.shinobi.demo.repository.PlayerRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Player
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String name;

    @OneToOne(mappedBy = "playerName")
    private Usuario user;

    @Column
    private int level;

    public Player(String name, int level)
    {
        this.name=name;
        this.level=level;
    }

}
