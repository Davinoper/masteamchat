package com.br.masteamchat.service;

import com.br.masteamchat.model.*;
import com.br.masteamchat.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;

    private final UserService userService;

    private final TeamService teamService;

    private final ModelMapper mapper;


    public Message enviar(MessageSendDTO messageSendDTO){
        User user = userService.acharPorId(messageSendDTO.getUserID());

        Team team = teamService.achaPorId(messageSendDTO.getTeamID());

        if(user != null && team != null){
            Message message = new Message(null, user, LocalDateTime.now(), team, messageSendDTO.getMessage());

            return messageRepository.save(message);
        }
        return null;
    }

    public List<MessageReturnDTO> buscarMensPorGrupo(Long teamID){
        return this.messageRepository.findByTeamId(teamID).stream().map(MessageReturnDTO::converterMessageParaMessageDTO).collect(Collectors.toList());
    }

}
