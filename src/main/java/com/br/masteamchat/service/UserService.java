package com.br.masteamchat.service;

import java.util.List;

import com.br.masteamchat.model.LoginUserDTO;
import com.br.masteamchat.model.Team;
import com.br.masteamchat.model.User;
import com.br.masteamchat.model.CreateUserDTO;
import com.br.masteamchat.repository.TeamRepository;
import com.br.masteamchat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    
    private final TeamRepository teamRepository;

    private final ModelMapper mapper;

    public User cadastrar(CreateUserDTO createUserDTO){

        User user = mapper.map(createUserDTO, User.class);

        return userRepository.save(user);
    }

    public User save(User user){
        return this.userRepository.save(user);
    }

    public User acharPorId(Long id){
        return userRepository.findById(id).orElse(null);
    }
    

    public List<User> achaUsuariosDoTeam(Long teamID){
        Team team = teamRepository.findById(teamID).orElse(null);
        
        if(team != null){
            return team.getUsuarios();
        }
        
        return null;
    }

    public User login(LoginUserDTO loginUserDTO){
        User user = userRepository.findByEmail(loginUserDTO.getEmail());

        if(user != null){

            if(user.getPassword().equals(loginUserDTO.getPassword())){
                return user;
            }
        }

        return null;
    }
}
