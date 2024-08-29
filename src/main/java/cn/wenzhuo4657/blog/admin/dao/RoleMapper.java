package cn.wenzhuo4657.blog.admin.dao;


import cn.wenzhuo4657.blog.admin.domain.enity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 86147
* @description 针对表【sys_role(角色信息表)】的数据库操作Mapper
* @createDate 2024-08-29 15:11:10
* @Entity generator.domain.Role
*/
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    List<String> getRoleById(Long id);
}




