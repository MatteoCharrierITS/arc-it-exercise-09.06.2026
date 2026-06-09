package org.charrier.beesercitazione.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "games")
@Getter @Setter
public class Game {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "state")
    private String state;
    
    @Column(name = "turn")
    private Integer turn;
    
}
