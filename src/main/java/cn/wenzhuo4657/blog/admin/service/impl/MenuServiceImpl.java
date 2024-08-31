package cn.wenzhuo4657.blog.admin.service.impl;

import cn.wenzhuo4657.blog.admin.Enum.Code;
import cn.wenzhuo4657.blog.admin.dao.MenuMapper;
import cn.wenzhuo4657.blog.admin.domain.enity.Menu;
import cn.wenzhuo4657.blog.admin.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



/**
* @author 86147
* @description 针对表【sys_menu(菜单权限表)】的数据库操作Service实现
* @createDate 2024-08-29 15:11:03
*/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
    implements MenuService {
    private  MenuMapper menuMapper;

    public MenuServiceImpl(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }


    @Override
    public List<String> getPermsById(Long id) {
        if (Code.Mysql_admin_id.equals(id)){
            return  menuMapper.getAllPerms();
        }
        return  menuMapper.getPermsById(id);
    }


    @Override
    public List<Menu> getRoutersTree(Long userId) {
        List<Menu> menus=null;


//        获取该用户下所有的菜单信息，此时没有形成Tree
        if (Code.Mysql_admin_id.equals(userId)){
            menus=menuMapper.getAllMeus();
        }else {
            menus=menuMapper.getById(userId);
        }


        List<Menu> tree = toTree(menus, 0L);
        return tree;
    }

    private  List<Menu>  toTree(List<Menu> menus,Long l){
        List<Menu> menuList = menus.stream()
                .filter(sysMenu -> sysMenu.getParentId().equals(l)).
                map(menu -> {
                    return menu.setChildren(getChildren(menu, menus));
                }).
                collect(Collectors.toList());
        return menuList;
    }

    private List<Menu> getChildren(Menu m, List<Menu> menus) {
        List<Menu> childrenList = menus.stream()
                .filter(menu -> menu.getParentId().equals(m.getId()))
                .map(menu -> menu.setChildren(getChildren(menu,menus)))
//            ，必须保证没有循环的id和parentId，否则就会陷入无限递归。
                .collect(Collectors.toList());
        return childrenList;
    }
}




