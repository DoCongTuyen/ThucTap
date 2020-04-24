package com.itsol.projectservice.dto.response;

import java.util.List;

public class GetListDataResponseDTO<T> extends BaseResponseDTO  {
    private List<T> datas;
    private Long totalRows = 0L;
    private Integer totalPages = 0;
    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public Long getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Long totalRows) {
        this.totalRows = totalRows;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    private void setSuccess(List<T> datas, Long totalRows, Integer totalPages) {
        super.setSuccess();
        this.datas = datas;
        this.totalRows = totalRows;
        this.totalPages = totalPages;
    }

    public void setResult(List<T> datas, Long totalRows, Integer totalPages) {
        if (datas != null) {
            this.setSuccess(datas, totalRows, totalPages);
        } else {
            super.setFailed();
        }
    }

    @Override
    public String toString() {
        return "GetListDataResponse { " +
                "datas = " + datas +
                ", totalRows = " + totalRows +
                ", totalPage = " + totalPages +
                " }";
    }
}
