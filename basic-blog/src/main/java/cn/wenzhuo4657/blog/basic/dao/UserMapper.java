package cn.wenzhuo4657.blog.basic.dao;


import cn.wenzhuo4657.blog.basic.domain.enity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 86147
* @description 针对表【sys_user(用户表)】的数据库操作Mapper
* @createDate 2024-08-15 12:46:57
* @Entity generator.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

    String selectById_nickName(Long Id);
}




