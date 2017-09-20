package me.microcool.doublerecyclerviewdemo.bean;


import java.util.List;

/**
 * 外层RecyclerView
 * parent data
 */

public class ParentInfo {

    private String title;

    private List<ChildInfo> menuList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ChildInfo> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<ChildInfo> menuList) {
        this.menuList = menuList;
    }

}
