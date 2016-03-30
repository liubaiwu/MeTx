package com.me.metx.Utils;

import android.text.TextUtils;

/**
 * Created by Administrator on 2016/3/29.
 * 数据类型转换
 */
public class ConvertUtils {

    /**
     * object转int 如果为null则返回0
     * @param obj
     * @return
     */
    public static int ToInt(Object obj)
    {
        if(obj==null)
            return 0;
        return ToInt(obj.toString());
    }

    /**
     * String转int 如果为null 或 “” 则返回0
     * @param input
     * @return
     */
    public static int ToInt(String input){
        if(input== null || input.trim()=="")
        {
            return  0;
        }
        return Integer.parseInt(input);
    }

    /**
     * double 强制类型转换为int
     * @param input
     * @return
     */
    public static int ToInt(double input)
    {
        return (int)input;
    }


    /**
     * object转double 如果为null则返回0
     * @param obj
     * @return
     */
    public static double ToDouble(Object obj)
    {
        if(obj==null)
            return 0;
        return ToDouble(obj.toString());
    }

    /**
     * String 转double 如果为null 或 “” 则返回0
     * @param input
     * @return
     */
    public static double ToDouble(String input)
    {
        if(input== null || input.trim()=="")
        {
            return  0;
        }
        return Double.valueOf(input);
    }


    /**
     * 任意类型转换为String  发送异常时返回null
     * @param input 要转换的值
     * @param <T> 类型
     * @return
     */
    public  static <T> String ToString(T input)
    {
        try{
            return String.valueOf(input);
        }catch (Exception ex)
        {
            return null;
        }
    }

}
