package com.itsol.projectservice.domain;

import lombok.*;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.annotations.TermVector;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "NEWS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class News implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_NEWS")
    @SequenceGenerator(sequenceName = "AUTO_INCRE_SEQ_NEWS", allocationSize = 1, name = "SEQ_NEWS")
    private long id;

    @Column(name = "TIEUDE")
//    @Field(termVector = TermVector.YES, index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String tieuDe;

    @Column(name = "NOIDUNG")
    private String noiDung;

    @Column(name = "TOMTAT")
    private String tomTat;

    @Column(name = "NGAYDANG")
    private Date ngayDang;

    @Column(name = "NGUOIDANG")
    private String nguoiDang;

    @Column(name = "IMGURL")
    private String imgUrl;
}
