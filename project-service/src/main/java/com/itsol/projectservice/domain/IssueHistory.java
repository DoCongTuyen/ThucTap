package com.itsol.projectservice.domain;

import lombok.*;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.annotations.TermVector;
import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ISSUE_HISTORY")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Indexed
public class IssueHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ISSUE_HIS")
    @SequenceGenerator(sequenceName = "AUTO_INCRE_SEQ_ISSUE_HIS", allocationSize = 1, name = "SEQ_ISSUE_HIS")
    private long id;

    @Column(name = "UPDATE_DATE", length = 50)
    private Date updateDate;

    @Column(name = "COMMENTS")
    private String comments;

    @Column(name = "ISSUE_CHANGE")
    private String issueChange;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ISSUE_ID")
    private Issue issueId;

    @Column(name = "UPDATE_PERSON_ID")
    private Long upLoadPersonId;

    @Column(name = "ISSUE_OLD")
    private String issueOld;

}
