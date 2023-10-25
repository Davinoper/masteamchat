package com.br.masteamchat.api;

import com.br.masteamchat.model.CreateTeamDTO;
import com.br.masteamchat.model.Team;
import com.br.masteamchat.model.TeamJoinDTO;
import com.br.masteamchat.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
@RequiredArgsConstructor
public class TeamAPI {
    private final TeamService teamService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Team> cadastrar(@RequestBody CreateTeamDTO createTeamDTO){
        return new ResponseEntity<>(
                teamService.cadastrar(createTeamDTO),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/entrar")
    public ResponseEntity<Team> entrar(@RequestBody TeamJoinDTO joinDTO){
        return new ResponseEntity<>(
                teamService.entrarNoTime(joinDTO),
                HttpStatus.OK
        );
    }


    @GetMapping
    public ResponseEntity<List<Team>> acharTodos(){
        return new ResponseEntity<>(
                this.teamService.acharTodos(),
                HttpStatus.OK
        );
    }


}
