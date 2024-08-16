package cn.wenzhuo4657.blog.basic.domain.vo;

/**
 * @className: LinkVo
 * @author: wenzhuo4657
 * @date: 2024/8/16 14:20
 * @Version: 1.0
 * @description:
 */
public class LinkVo {
    private Long id;

    private String name;

    private String logo;

    private String description;
    //网站地址
    private String address;

    public LinkVo() {

    }

    public LinkVo(Long id, String name, String logo, String description, String address) {
        this.id = id;
        this.name = name;
        this.logo = logo;
        this.description = description;
        this.address = address;
    }

    @Override
    public String toString() {
        return "LinkVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}