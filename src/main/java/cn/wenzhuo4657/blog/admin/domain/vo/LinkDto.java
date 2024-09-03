package cn.wenzhuo4657.blog.admin.domain.vo;

/**
 * @className: LinkDto
 * @author: wenzhuo4657
 * @date: 2024/9/3 8:50
 * @Version: 1.0
 * @description:
 */
public class LinkDto {
    private String address;
    private String description;
    private Long id;
    private String name;
    private String status;
    private String logo;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "LinkDto{" +
                "address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }

    public LinkDto() {
    }

    public LinkDto(String address, String description, Long id, String name, String status, String logo) {
        this.address = address;
        this.description = description;
        this.id = id;
        this.name = name;
        this.status = status;
        this.logo = logo;
    }
}