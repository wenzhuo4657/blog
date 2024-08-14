package cn.wenzhuo4657.blog.basic.domain.vo;

import java.util.List;

/**
 * @className: pageVo
 * @author: wenzhuo4657
 * @date: 2024/8/14 13:52
 * @Version: 1.0
 * @description:
 */

public class pageVo {
    private List rows;
    private Long total;//当前页的总数

    public pageVo() {
    }

    public pageVo(List rows, Long total) {
        this.rows = rows;
        this.total = total;
    }

    @Override
    public String toString() {
        return "pageVo{" +
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