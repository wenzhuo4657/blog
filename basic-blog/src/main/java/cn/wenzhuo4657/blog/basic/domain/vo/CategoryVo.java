package cn.wenzhuo4657.blog.basic.domain.vo;

/**
 * @className: CategoryVo
 * @author: wenzhuo4657
 * @date: 2024/8/15 10:24
 * @Version: 1.0
 * @description:
 */
public class CategoryVo {

    private Long id;

    private String name;
    private String description;
    private  String status;

    public CategoryVo() {
    }


    public CategoryVo(Long id, String name, String description, String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
    }


    @Override
    public String toString() {
        return "CategoryVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}