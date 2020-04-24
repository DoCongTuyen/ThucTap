package com.itsol.projectservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NewsDto {
    private long id;
    private String tieuDe;
    private String noiDung;
    private String tomTat;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String ngayDang;
    private String nguoiDang;
    private String imgUrl;

}
