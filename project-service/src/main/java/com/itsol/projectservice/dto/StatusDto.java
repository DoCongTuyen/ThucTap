package com.itsol.projectservice.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StatusDto {
    private long id;
    private String name;
    private StatusTypeDto statusType;
}
