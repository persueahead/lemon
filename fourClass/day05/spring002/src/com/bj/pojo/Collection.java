package com.bj.pojo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Collection {
    private  Object[] obj;

    private List list;

    private Map map;

    private Properties pro;

    @Override
    public String toString() {
        return "Collection{" +
                "obj=" + Arrays.toString(obj) +
                ", list=" + list +
                ", map=" + map +
                ", pro=" + pro +
                '}';
    }

    public Object[] getObj() {
        return obj;
    }

    public void setObj(Object[] obj) {
        this.obj = obj;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Properties getPro() {
        return pro;
    }

    public void setPro(Properties pro) {
        this.pro = pro;
    }
}
