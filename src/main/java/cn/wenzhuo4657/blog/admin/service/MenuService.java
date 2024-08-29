package cn.wenzhuo4657.blog.admin.service;


import cn.wenzhuo4657.blog.admin.domain.enity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 86147
* @description 针对表【sys_menu(菜单权限表)】的数据库操作Service
* @createDate 2024-08-29 15:11:03
*/
public interface MenuService extends IService<Menu> {

    List<String> getPermsById(Long id);

    List<Menu> getRoutersTree(Long userId);
}
