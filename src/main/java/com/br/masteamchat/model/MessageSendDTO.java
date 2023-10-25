package com.br.masteamchat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageSendDTO {
    private Long userID;
    private Long teamID;
    private String message;
}
