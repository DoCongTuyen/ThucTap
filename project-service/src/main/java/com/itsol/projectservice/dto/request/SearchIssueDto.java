package com.itsol.projectservice.dto.request;

import com.itsol.projectservice.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SearchIssueDto extends BaseDto {
    private long id;
    private String name;
    private Date startDate;
    private Date endDate;
    private double dueDate;
    private long donePercent;
    private String type;
    private String imgUrl;
    private String priority;
    private String reason;
    private String description;
    private long projectId;
    private long statusId;


}
