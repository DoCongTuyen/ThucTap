package com.itsol.projectservice.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PROJECT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUTO_INCRE_SEQ_PROJECT")
    @SequenceGenerator(sequenceName = "AUTO_INCRE_SEQ_PROJECT", allocationSize = 1, name = "AUTO_INCRE_SEQ_PROJECT")
    private long id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STATUS_ID")
    private Status status;
}
