CREATE TABLE users (
    
    id INTEGER PRIMARY KEY,
    ip VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(50) NOT NULL UNIQUE
    
);

CREATE TABLE games (
    
    id INTEGER PRIMARY KEY,
    state VARCHAR(50) NOT NULL,
    turn INTEGER NOT NULL 
    
);

CREATE TABLE moves (
    
    id INTEGER PRIMARY KEY,
    game_id INTEGER NOT NULL,
    player_id INTEGER NOT NULL,
    turn INTEGER NOT NULL,
    move VARCHAR(50) NOT NULL,
    
    FOREIGN KEY (game_id) REFERENCES games(id),
    FOREIGN KEY (player_id) REFERENCES users(id)
    
);