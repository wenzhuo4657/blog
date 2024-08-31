package cn.wenzhuo4657.blog.admin.dao;


import cn.wenzhuo4657.blog.admin.domain.enity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 86147
* @description 针对表【sys_menu(菜单权限表)】的数据库操作Mapper
* @createDate 2024-08-29 15:11:02
* @Entity generator.domain.Menu
*/

@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    List<String> getPermsById(Long id);

    List<String> getAllPerms();

      /**
         *  des: 获取所有可用的菜单
         * */
    List<Menu> getAllMeus();

    List<Menu> getById(Long userId);
}




