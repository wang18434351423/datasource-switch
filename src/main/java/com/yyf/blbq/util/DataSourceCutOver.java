package com.yyf.blbq.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wangchen
 * @create 2020/05/11/14:47
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSourceCutOver {

    DataSourceType value() default DataSourceType.MASTER;
}
