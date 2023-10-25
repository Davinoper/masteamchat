package com.br.masteamchat.service;

import com.br.masteamchat.model.CreateTeamDTO;
import com.br.masteamchat.model.Team;
import com.br.masteamchat.model.TeamJoinDTO;
import com.br.masteamchat.model.User;
import com.br.masteamchat.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;

    private final UserService userService;

    private final ModelMapper mapper;

    public Team cadastrar(CreateTeamDTO createTeamDTO){
        Team team = mapper.map(createTeamDTO, Team.class);
        return teamRepository.save(team);
    }

    public Team entrarNoTime(TeamJoinDTO teamJoinDTO){
        User user = userService.acharPorId(teamJoinDTO.getUserID());

        Team team = this.achaPorId(teamJoinDTO.getTeamID());

        if (user != null && team != null){
            if(!team.getUsuarios().contains(user)){
                team.getUsuarios().add(user);
                userService.save(user);
            }

            if(!user.getTeams().contains(team)){
                user.getTeams().add(team);
                this.teamRepository.save(team);
            }

            return team;
        }

        return null;
    }

    public List<Team> acharTodos(){
        return this.teamRepository.findAll();
    }

    public Team achaPorId(Long id){
        return teamRepository.findById(id).orElse(null);
    }
}
