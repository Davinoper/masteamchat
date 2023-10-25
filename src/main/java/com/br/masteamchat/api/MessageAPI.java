package com.br.masteamchat.api;

import com.br.masteamchat.model.Message;
import com.br.masteamchat.model.MessageReturnDTO;
import com.br.masteamchat.model.MessageSendDTO;
import com.br.masteamchat.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("message")
public class MessageAPI {

    private final MessageService messageService;

    @PostMapping
    public ResponseEntity<Message> enviar(@RequestBody MessageSendDTO messageSendDTO){
        return new ResponseEntity<>(
                this.messageService.enviar(messageSendDTO),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<MessageReturnDTO>> buscarMensPorTeam(@PathVariable Long id){
        return new ResponseEntity<>(
                this.messageService.buscarMensPorGrupo(id),
                HttpStatus.OK
        );
    }

}
