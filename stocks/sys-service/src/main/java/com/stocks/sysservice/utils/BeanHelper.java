package com.stocks.sysservice.utils;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.web.context.request.RequestContextHolder;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * @Author: ChenYu
 * @Date: 2019/2/19 14:23
 * @Description:给bean对象的时间注入当时间值
 */
public class BeanHelper {

    private static final String UPDATE_TIME_KEY = "updateTime";

    private static final String CREATE_TIME_KEY = "createTime";

    public static <T> void setDefaultProp(T target, Class<T> clazz) {
        //检索指定类中的属性描述
        PropertyDescriptor[] descriptors = PropertyUtils.getPropertyDescriptors(clazz);
        //遍历指定类的属性
        for (PropertyDescriptor propertyDescriptor : descriptors) {
            //获取当前属性名
            String fieldName = propertyDescriptor.getName();
            Object value;

            try {
                //获取指定类的指定字段的值，并赋值给value
                value = PropertyUtils.getProperty(target, fieldName);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                throw new RuntimeException("can not set property  when get for " + target + " and clazz " + clazz + " field " + fieldName);
            }

            try {
                //如果value为空判断指定属性的Java类
                if (String.class.isAssignableFrom(propertyDescriptor.getPropertyType()) && value == null) {
                    PropertyUtils.setProperty(target, fieldName, "");
                } else if (Number.class.isAssignableFrom(propertyDescriptor.getPropertyType()) && value == null) {
                    PropertyUtils.setProperty(target, fieldName, "0");
                }
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                throw new RuntimeException("can not set property when set for " + target + " and clazz " + clazz + " field " + fieldName);
            }
        }
    }

    /**
     * 新增数据自动添加修改数据时间
     *
     * @param target
     * @param <T>
     */
    public static <T> void onInsert(T target) {
        try {
            //添加修改时间
            PropertyUtils.setProperty(target, UPDATE_TIME_KEY, getDate());
            //添加新增时间
            PropertyUtils.setProperty(target, CREATE_TIME_KEY, getDate());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改数据自动添加数据修改时间
     *
     * @param target
     * @param <T>
     */
    public static <T> void onUpdate(T target) {
        try {
            //添加修改时间
            PropertyUtils.setProperty(target, UPDATE_TIME_KEY, getDate());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static Date getDate() {
        //获取当前时间毫秒值
        long time = System.currentTimeMillis();
        //毫秒值转化为时间
        Date date = new Date(time);
        return date;
    }

}
