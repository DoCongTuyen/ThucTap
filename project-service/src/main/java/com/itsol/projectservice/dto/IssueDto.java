package com.itsol.projectservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class IssueDto{
    private long id;
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    private Date endDate;
    private double dueDate;
    private long donePercent;
    private String type;
    private String priority;
    private String reason;
    private String description;
    private long projectId;
    private long statusId;

}
