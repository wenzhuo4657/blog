package cn.wenzhuo4657.blog.admin.service;

import cn.wenzhuo4657.blog.admin.domain.enity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 86147
* @description 针对表【sys_role(角色信息表)】的数据库操作Service
* @createDate 2024-08-29 15:11:10
*/
public interface RoleService extends IService<Role> {

    List<String> getRoleById(Long id);
}