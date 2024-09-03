package cn.wenzhuo4657.blog.admin.domain.vo;

import com.mysql.cj.log.Log;

/**
 * @className: MenuVo
 * @author: wenzhuo4657
 * @date: 2024/9/3 12:29
 * @Version: 1.0
 * @description:
 */
public class MenuVo {

    private String component;

    private String icon;

    private Long id;

    private int isFrame;

    private String menuName;

    private String menuType;

    private int orderNum;

    private Long parentId;

    private String path;

    private String perms;

    private String remark;

    private String status;

    private String visible;

    public MenuVo() {
    }

    public MenuVo(String component, String icon, Long id, int isFrame, String menuName, String menuType, int orderNum, Long parentId, String path, String perms, String remark, String status, String visible) {
        this.component = component;
        this.icon = icon;
        this.id = id;
        this.isFrame = isFrame;
        this.menuName = menuName;
        this.menuType = menuType;
        this.orderNum = orderNum;
        this.parentId = parentId;
        this.path = path;
        this.perms = perms;
        this.remark = remark;
        this.status = status;
        this.visible = visible;
    }

    public void setComponent(String component){
        this.component = component;
    }
    public String getComponent(){
        return this.component;
    }
    public void setIcon(String icon){
        this.icon = icon;
    }
    public String getIcon(){
        return this.icon;
    }
    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return this.id;
    }
    public void setIsFrame(int isFrame){
        this.isFrame = isFrame;
    }
    public int getIsFrame(){
        return this.isFrame;
    }
    public void setMenuName(String menuName){
        this.menuName = menuName;
    }
    public String getMenuName(){
        return this.menuName;
    }
    public void setMenuType(String menuType){
        this.menuType = menuType;
    }
    public String getMenuType(){
        return this.menuType;
    }
    public void setOrderNum(int orderNum){
        this.orderNum = orderNum;
    }
    public int getOrderNum(){
        return this.orderNum;
    }
    public void setParentId(long parentId){
        this.parentId = parentId;
    }
    public long getParentId(){
        return this.parentId;
    }
    public void setPath(String path){
        this.path = path;
    }
    public String getPath(){
        return this.path;
    }
    public void setPerms(String perms){
        this.perms = perms;
    }
    public String getPerms(){
        return this.perms;
    }
    public void setRemark(String remark){
        this.remark = remark;
    }
    public String getRemark(){
        return this.remark;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
    public void setVisible(String visible){
        this.visible = visible;
    }
    public String getVisible(){
        return this.visible;
    }
}