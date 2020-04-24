package com.itsol.projectservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


public class BaseDto implements Serializable {
    protected Integer pageSize = 5;
    protected Integer page = 0;
    protected String sort;
    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
