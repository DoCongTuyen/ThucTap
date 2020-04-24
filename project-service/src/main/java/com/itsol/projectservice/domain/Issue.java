package com.itsol.projectservice.domain;

import lombok.*;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.annotations.TermVector;
import org.springframework.stereotype.Indexed;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ISSUE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Indexed
public class Issue implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ISSUE")
    @SequenceGenerator(sequenceName = "AUTO_INCRE_SEQ_ISSUE", allocationSize = 1, name = "SEQ_ISSUE")
    private long id;

    @Column(name = "NAME", length = 50)
    @Field(termVector = TermVector.YES, index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String name;

    @Column(name = "START_DATE", length = 70)
    private Date startDate;
    @Column(name = "END_DATE", length = 70)
    private Date endDate;
    @Column(name = "DUE_DATE", length = 250)
    private Double dueDate;

    @Column(name = "DONE_PERCENT", length = 50)
    private Long donePercent;

    @Column(name = "PRIORITY", length = 70)
    private String priority;

    @Column(name = "REASON", length = 50)
    private String reason;
    @Column(name = "TYPE", length = 50)
    private String type;


    @Column(name = "DESCRIPTION", length = 50)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJECT_ID")
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STATUS_ID")
    private Status status;

}
