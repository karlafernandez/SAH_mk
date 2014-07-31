package com.demo.cmv.common.base;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;


public class Grid implements Serializable {

    private int page;
    private int total;
    private int pagination;
    private String records;
    private List rows;
    private HashMap<String,Object> userdata;

    public Grid() {
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getRecords() {
        return records;
    }

    public void setRecords(String records) {
        this.records = records;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public int getPagination() {
        return pagination;
    }

    public void setPagination(int pagination) {
        this.pagination = pagination;
    }

    public HashMap<String, Object> getUserdata() {
        return userdata;
    }

    public void setUserdata(HashMap<String, Object> userdata) {
        this.userdata = userdata;
    } 
}