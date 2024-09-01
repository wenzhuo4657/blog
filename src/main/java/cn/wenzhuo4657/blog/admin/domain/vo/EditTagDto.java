package cn.wenzhuo4657.blog.admin.domain.vo;

public class EditTagDto {

    private Long id;
    //备注
    private String remark;
    //标签名
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EditTagDto{" +
                "id=" + id +
                ", remark='" + remark + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public EditTagDto() {

    }

    public EditTagDto(Long id, String remark, String name) {
        this.id = id;
        this.remark = remark;
        this.name = name;
    }
}