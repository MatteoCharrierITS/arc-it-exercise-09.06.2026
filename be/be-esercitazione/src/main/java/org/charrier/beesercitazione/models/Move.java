package org.charrier.beesercitazione.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "moves")
@Getter
@Setter
public class Move {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "game_id")
    private Integer gameId;
    
    @Column(name = "user_id")
    private Integer userId;
    
    @Column(name = "turn")
    private Integer turn;
    
    @Column(name = "move")
    private String move;
    
}
