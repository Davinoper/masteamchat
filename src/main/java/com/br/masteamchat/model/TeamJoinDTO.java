package com.br.masteamchat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamJoinDTO {
    private Long teamID;
    private Long userID;
}
