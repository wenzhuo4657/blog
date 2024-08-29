package cn.wenzhuo4657.blog.admin.domain.vo;

import cn.wenzhuo4657.blog.basic.domain.vo.UserInfoVo;

import java.util.List;

public class AdminUserInfoVo {

    private List<String> permissions;

    private List<String> roles;

    private UserInfoVo user;

    public AdminUserInfoVo() {

    }

    public AdminUserInfoVo(List<String> permissions, List<String> roles, UserInfoVo user) {
        this.permissions = permissions;
        this.roles = roles;
        this.user = user;
    }

    @Override
    public String toString() {
        return "AdminUserInfoVo{" +
                "permissions=" + permissions +
                ", roles=" + roles +
                ", user=" + user +
                '}';
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public UserInfoVo getUser() {
        return user;
    }

    public void setUser(UserInfoVo user) {
        this.user = user;
    }
}