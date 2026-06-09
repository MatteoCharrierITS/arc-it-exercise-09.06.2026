package org.charrier.beesercitazione.controller;

import lombok.AllArgsConstructor;
import org.charrier.beesercitazione.dto.UserDto;
import org.charrier.beesercitazione.dto.request.AddUserRequestDto;
import org.charrier.beesercitazione.dto.request.AddUserResponse;
import org.charrier.beesercitazione.dto.request.RemoveUserResponse;
import org.charrier.beesercitazione.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    
    private final UserService userService;
    
    @GetMapping("")
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }
    
    @PostMapping("/add")
    public ResponseEntity<AddUserResponse> addUser(
            @RequestBody AddUserRequestDto request
    ) {
        return ResponseEntity.ok(userService.addUser(request.username(), request.ip()));
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<RemoveUserResponse> removeUser(
            @PathVariable("userId") int id
    ) {

        RemoveUserResponse response = userService.removeUser(id);
        return ResponseEntity.ok(response);
    }
    
    
}
