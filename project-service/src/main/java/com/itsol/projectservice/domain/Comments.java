package com.itsol.projectservice.domain;

import lombok.*;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.annotations.TermVector;
import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "COMMENTS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Indexed
public class Comments implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_COMMENTS")
    @SequenceGenerator(sequenceName = "AUTO_INCRE_SEQ_COMMENTS", allocationSize = 1, name = "SEQ_COMMENTS")
    private long id;

    @Column(name = "CONTENTS", length = 50)
    private String contents;

    @Column(name = "POSTDATE", length = 70)
    private Date postDate;


    @Column(name = "EMPLOYEE_ID", length = 50)
    private Long employeeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NEWS_ID")
    private News newsId;
}
