package cn.wenzhuo4657.blog.admin.domain.vo;

/**
 * @className: RoleVo
 * @author: wenzhuo4657
 * @date: 2024/9/3 9:22
 * @Version: 1.0
 * @description:
 */
public class RoleVo {
    private Long roleId;
    private String status;

    public RoleVo(Long roleId, String status) {
        this.roleId = roleId;
        this.status = status;
    }

    @Override
    public String toString() {
        return "RoleVo{" +
                "roleId=" + roleId +
                ", status='" + status + '\'' +
                '}';
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RoleVo() {

    }
}