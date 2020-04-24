package com.itsol.projectservice.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommentsDto {
    private long id;

    private String contents;

    private Date postDate;

    private Long employeeId;

    private Long newsId;
}
