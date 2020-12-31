package com.bjlemon.utiles;

import org.apache.commons.beanutils.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateFormat implements Converter {
    private  String dateStyle="yyyy-MM-dd";

    public String getDateStyle() {
        return dateStyle;
    }

    public void setDateStyle(String dateStyle) {
        this.dateStyle = dateStyle;
    }

    public MyDateFormat(String dateStyle) {
        super();
        this.dateStyle = dateStyle;
    }

    public MyDateFormat() {
        super();
    }

    @Override
    public Object convert(Class aClass, Object o) {
        if (o==null||"".equals(o.toString())) {
            return null;
        }
        if (aClass== Date.class){

            SimpleDateFormat format=new SimpleDateFormat(dateStyle);
            try{
 //            按照格式解析字符串  String——Date
             Date date= format.parse(String.valueOf(o));
             System.out.println(date.toString());
             return  date;
            }catch(Exception e){
            e.printStackTrace();
            }

        }
        return null;
    }
}
