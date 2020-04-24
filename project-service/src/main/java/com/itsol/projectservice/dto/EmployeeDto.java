package com.itsol.projectservice.dto;

import lombok.*;

import javax.persistence.Column;
import java.util.Date;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private long id;
    private String userName;
    private String password;
    private String imgUrl;
    private Date lastAccess;
    private String fullName;
    private Date createdDate;
    private String email;
    private String phoneNumber;
    private String skypeAccount;
    private String userType;
    private String address;
    private String university;
    private int graduatedYear;
    private int isLeader;
    private int isManager;
    private int isActived;
    private int positionId;
    private int teamId;
    private int departmentId;
    private Date birthDay;

}
