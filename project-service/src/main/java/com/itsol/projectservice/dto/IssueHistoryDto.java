package com.itsol.projectservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class IssueHistoryDto {
    private long id;

//    @JsonFormat(pattern = "yyyy-MM-dd hh/mm/s")
    private Timestamp updateDate;

    private String comments;

    private String issueChange;

    private Long issueId;

    private Long upLoadPersonId;

    private String issueOld;

}
