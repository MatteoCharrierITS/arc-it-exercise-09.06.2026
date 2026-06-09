package org.charrier.beesercitazione.service;

import lombok.AllArgsConstructor;
import org.charrier.beesercitazione.dto.UserDto;
import org.charrier.beesercitazione.dto.request.AddUserResponse;
import org.charrier.beesercitazione.dto.request.RemoveUserResponse;
import org.charrier.beesercitazione.models.User;
import org.charrier.beesercitazione.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ResourceBundle;

@Service
@AllArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;
    
    public List<UserDto> getUsers() {
        return userRepository.findAll().stream()
                .map(user -> new UserDto(
                        user.getId(),
                        user.getUsername(),
                        user.getIp()
                ))
                .toList();
    }
    
    public AddUserResponse addUser(String username, String ip) {
        try
        {
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setIp(ip);
            
            userRepository.save(newUser);
            return new AddUserResponse(username, ip, "SUCCESS");
        }
        catch (Exception e)
        {
            return new AddUserResponse("", "", "ERROR: " + e.getMessage());
        }
    }

    public RemoveUserResponse removeUser(int id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return new RemoveUserResponse("", "", "USER NOT FOUND");
        }
            
        userRepository.delete(user);
        
        return new RemoveUserResponse(
                user.getUsername(),
                user.getIp(),
                "USER REMOVED"
        );
    }
}
