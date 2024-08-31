package cn.wenzhuo4657.blog.admin.domain.vo;

import java.util.List;

public class PageVo {
    private List rows;
    private Long total;//当前页的总数


    public PageVo(List rows, Long total) {
        this.rows = rows;
        this.total = total;
    }

    public PageVo() {

    }

    @Override
    public String toString() {
        return "PageVo{" +
                "rows=" + rows +
                ", total=" + total +
                '}';
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}