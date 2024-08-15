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

    public CategoryVo() {
    }

    public CategoryVo(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoryVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
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