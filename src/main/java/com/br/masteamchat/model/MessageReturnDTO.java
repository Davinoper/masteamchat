package com.br.masteamchat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageReturnDTO {
    private String userName;

    private String message;

    private LocalTime time;


    public static MessageReturnDTO converterMessageParaMessageDTO(Message message){
        return new MessageReturnDTO(
                message.getUsuario().getName(),
                message.getMessage(),
                LocalTime.now()
        );
    }

}
