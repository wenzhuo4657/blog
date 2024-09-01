package cn.wenzhuo4657.blog.admin.domain.vo;

import com.alibaba.excel.annotation.ExcelProperty;


/**
 * @author 35238
 * @date 2023/8/8 0008 12:32
 */

public class ExcelCategoryVo {
    @ExcelProperty("分类名")
    private String name;
    //描述
    @ExcelProperty("描述")
    private String description;

    //状态0:正常,1禁用
    @ExcelProperty("状态0:正常,1禁用")
    private String status;

    @Override
    public String toString() {
        return "ExcelCategoryVo{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ExcelCategoryVo() {

    }

    public ExcelCategoryVo(String name, String description, String status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }
}