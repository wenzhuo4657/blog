package cn.wenzhuo4657.blog.admin.domain.vo;

import cn.wenzhuo4657.blog.admin.domain.enity.Menu;

import java.util.List;

/**
 * @className: RoutersVo
 * @author: wenzhuo4657
 * @date: 2024/8/29 18:33
 * @Version: 1.0
 * @description:
 */
public class RoutersVo {
    private List<Menu>  menus;


    public RoutersVo(List<Menu> menus) {
        this.menus = menus;
    }

    public RoutersVo() {

    }

    @Override
    public String toString() {
        return "RoutersVo{" +
                "menus=" + menus +
                '}';
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}