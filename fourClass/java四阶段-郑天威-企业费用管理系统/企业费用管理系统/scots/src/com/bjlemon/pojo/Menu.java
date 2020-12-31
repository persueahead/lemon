package com.bjlemon.pojo;

public class Menu {

    /**
     *菜单编号
     */
    private  Integer menuId;
    /**
     *菜单名称
     */
    private  String menuName;
    /**
     *父级菜单编号
     */
    private  Integer pMenuId;
    /**
     *请求的地址
     */
    private  String menuUrl;

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", pMenuId=" + pMenuId +
                ", menuUrl='" + menuUrl + '\'' +
                '}';
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getpMenuId() {
        return pMenuId;
    }

    public void setpMenuId(Integer pMenuId) {
        this.pMenuId = pMenuId;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }
}
