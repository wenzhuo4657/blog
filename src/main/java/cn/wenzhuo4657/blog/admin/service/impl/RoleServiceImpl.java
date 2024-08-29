package cn.wenzhuo4657.blog.admin.service.impl;

import cn.wenzhuo4657.blog.admin.dao.RoleMapper;
import cn.wenzhuo4657.blog.admin.domain.enity.Role;
import cn.wenzhuo4657.blog.admin.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

/**
* @author 86147
* @description 针对表【sys_role(角色信息表)】的数据库操作Service实现
* @createDate 2024-08-29 15:11:10
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService {

}




