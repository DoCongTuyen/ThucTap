package com.itsol.projectservice.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "STATUS_TYPE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StatusType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUTO_INCRE_SEQ_STATUS_TYPE")
    @SequenceGenerator(sequenceName = "AUTO_INCRE_SEQ_STATUS_TYPE", allocationSize = 1, name = "AUTO_INCRE_SEQ_STATUS_TYPE")
    private long id;

    @Column(name = "name")
    private String name;
}
