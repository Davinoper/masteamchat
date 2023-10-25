package com.br.masteamchat.api;

import java.util.List;

import com.br.masteamchat.model.CreateUserDTO;
import com.br.masteamchat.model.LoginUserDTO;
import com.br.masteamchat.model.User;
import com.br.masteamchat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserAPI {
    private final UserService userService;


    @PostMapping("/cadastrar")
    public ResponseEntity<User> cadastrar(@RequestBody CreateUserDTO createUserDTO){
        return new ResponseEntity<>(
                userService.cadastrar(createUserDTO),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/login")
    public ResponseEntity<User> logar(@RequestBody LoginUserDTO loginUserDTO){
        return new ResponseEntity<>(
                userService.login(loginUserDTO),
                HttpStatus.OK
        );
    }
    
    @GetMapping("/team/{id}")
    public ResponseEntity<List<User>> acharUsuariosDoTIme(@PathVariable Long id){
        return new ResponseEntity<>(
                userService.achaUsuariosDoTeam(id),
                HttpStatus.OK
        );
    }
 
}
