package com.itsol.projectservice.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ROLE_ID_SEQ")
    @SequenceGenerator(name = "ROLE_ID_SEQ",sequenceName = "AUTO_INCRE_SEQ_ROLE",initialValue = 1,allocationSize = 1)
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME")
    private String name;

//    @ManyToMany(mappedBy = "roles")
//    private Set<Employee> employees  = new HashSet<>();
}
