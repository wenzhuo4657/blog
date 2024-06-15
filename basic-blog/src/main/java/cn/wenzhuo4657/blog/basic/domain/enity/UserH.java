package cn.wenzhuo4657.blog.basic.domain.enity;

import java.util.Date;
import java.io.Serializable;

/**
 * (UserH)实体类
 *
 * @author makejava
 * @since 2024-06-14 15:47:27
 */
public class UserH implements Serializable {
    private static final long serialVersionUID = 164471400738435571L;
    /**
     * 用户唯一标识
     */
    private Integer id;
    /**
     * 昵称，限制3-7位
     */
    private String username;
    /**
     * 密码，限制8-12位，默认12个0，可以不设置
     */
    private String password;
    /**
     * 选填，
     */
    private String email;
    /**
     * 0可用，1禁用
     */
    private String status;
    /**
     * 0可用，1逻辑删除
     */
    private String delete;
    /**
     * 用户创建时间
     */
    private Date creatTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

}

