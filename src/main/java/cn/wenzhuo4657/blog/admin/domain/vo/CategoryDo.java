package cn.wenzhuo4657.blog.admin.domain.vo;

/**
 * @className: CategoryDo
 * @author: wenzhuo4657
 * @date: 2024/9/3 10:00
 * @Version: 1.0
 * @description:
 */
public class CategoryDo {
    private Long id;

    private String status;

    public CategoryDo() {

    }

    public CategoryDo(Long id, String status) {
        this.id = id;
        this.status = status;
    }

    @Override
    public String toString() {
        return "CategoryDo{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}