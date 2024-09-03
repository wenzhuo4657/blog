package cn.wenzhuo4657.blog.admin.domain.vo;

/**
 * @className: LinkVo
 * @author: wenzhuo4657
 * @date: 2024/9/1 11:36
 * @Version: 1.0
 * @description:
 */
public class LinkVo {
    private String name;

    private  String status;

    @Override
    public String toString() {
        return "LinkVo{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LinkVo() {
    }

    public LinkVo(String name, String status) {
        this.name = name;
        this.status = status;
    }
}