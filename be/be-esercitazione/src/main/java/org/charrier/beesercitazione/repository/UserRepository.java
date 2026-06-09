package org.charrier.beesercitazione.repository;

import org.charrier.beesercitazione.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    
    
    
}
