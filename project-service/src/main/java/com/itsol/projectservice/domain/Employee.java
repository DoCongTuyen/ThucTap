package com.itsol.projectservice.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "EMPLOYEE")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EMPLOYEE")
    @SequenceGenerator(sequenceName = "AUTO_INCRE_SEQ_EMPLOYEE",allocationSize = 1, name = "SEQ_EMPLOYEE")
    private long id;

    @Column(name ="USERNAME")
    private String userName;

    @Column(name ="PASSWORD")
    private String password;

    @Column(name ="IMAGE_URL")
    private String imgUrl;

    @Column(name ="LAST_ACCESS")
    private Date lastAccess;

    @Column(name ="FULLNAME")
    private String fullName;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "SKYPE_ACCOUNT")
    private String skypeAccount;

    @Column(name = "USER_TYPE")
    private String userType;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "UNIVERSITY")
    private String university;

    @Column(name = "GRADUATED_YEAR")
    private int graduatedYear;

    @Column(name = "IS_LEADER")
    private int isLeader;

    @Column(name = "IS_MANAGER")
    private int isManager;

    @Column(name = "IS_ACTIVED")
    private int isActived;

    @Column(name = "POSITION_ID")
    private int positionId;

    @Column(name = "TEAM_ID")
    private int teamId;

    @Column(name = "DEPARTMENT_ID")
    private int departmentId;

    @Column(name = "BIRTHDAY")
    private Date birthDay;

//    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE,CascadeType.PERSIST})
//    @JoinTable(
//            name = "EMPLOYEE_ROLE",
//            joinColumns = @JoinColumn(name = "EMPLOYEE_ID",referencedColumnName = "ID",nullable = false),
//            inverseJoinColumns = @JoinColumn(
//                    name = "ROLE_ID",referencedColumnName = "ID",nullable = false
//            )
//    )
//    private Set<Role> roles = new HashSet<>();

}
