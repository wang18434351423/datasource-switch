package com.yyf.blbq.dynamic;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangchen
 * @create 2020/05/11/14:52
 */
@Slf4j
public class DynamicDataSourceContextHolder {

    /**
     * 使用ThreadLocal维护变量 为每个线程提供独立副本
     */
    private  static  final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    /**
     * 设置数据源的变量
     */
    public static void setDataSourceType(String dsType){
        log.info("切换到{}数据源",dsType);
        CONTEXT_HOLDER.set(dsType);
    }

    /**
     * 获得数据源的变量
     */
    public static String getDataSourceType(){
        return CONTEXT_HOLDER.get();
    }

    /**
     * 清空数据源变量
     */
    public static void remove(){
        CONTEXT_HOLDER.remove();
    }

}
