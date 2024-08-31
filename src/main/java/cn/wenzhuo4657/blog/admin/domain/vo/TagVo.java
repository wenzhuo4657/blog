package cn.wenzhuo4657.blog.admin.domain.vo;

/**
 * @className: TagVo
 * @author: wenzhuo4657
 * @date: 2024/8/31 10:16
 * @Version: 1.0
 * @description:
 */
public class TagVo {

    private String name;

    private  String remark;

    public TagVo(String name, String remark) {
        this.name = name;
        this.remark = remark;
    }

    public TagVo() {
    }

    @Override
    public String toString() {
        return "TagVo{" +
                "name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}