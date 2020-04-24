package com.itsol.projectservice.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "STATUS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Status implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUTO_INCRE_SEQ_STATUS")
    @SequenceGenerator(sequenceName = "AUTO_INCRE_SEQ_STATUS", allocationSize = 1, name = "AUTO_INCRE_SEQ_STATUS")
    private long id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TYPE_ID")
    private StatusType statusType;
}
