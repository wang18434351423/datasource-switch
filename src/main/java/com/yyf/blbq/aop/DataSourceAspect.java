package com.yyf.blbq.aop;

import com.yyf.blbq.dynamic.DynamicDataSourceContextHolder;
import com.yyf.blbq.util.DataSourceCutOver;
import com.yyf.blbq.util.DataSourceType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * 多数据源处理切面
 * @author wangchen
 * @create 2020/05/11/15:02
 */
@Slf4j
@Aspect
@Order(1)
@Component
public class DataSourceAspect {

    //定义注解切入点表达式
    @Pointcut("@annotation(com.yyf.blbq.util.DataSourceCutOver)")
    public void pointCut(){}

    //定义环绕通知方法在业务代码调用之前切换数据源
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        //获取方法签名
        MethodSignature signature = (MethodSignature) point.getSignature();
        //获取被调用方法
        Method method = signature.getMethod();
        //判断方法上方是否存在数据源切换注解
        DataSourceCutOver cutOver = method.getAnnotation(DataSourceCutOver.class);
        //如果方法上有注解 根据用户指定的数据源进行切换
        if(Objects.nonNull(cutOver)){
            //将数据存入到ThreadLocal中
            DynamicDataSourceContextHolder.setDataSourceType(cutOver.value().name());
            log.debug("current thread " + Thread.currentThread().getName() + " add " + cutOver.value().name() + " to ThreadLocal");
        }else {
            log.debug("switch datasource fail,use default");
        }
        //调用下一个切面或执行目标方法
        Object result = point.proceed();
        //返回目标方法的执行结果
        return result;
    }

    @After("pointCut()")
    public void after(){
        DynamicDataSourceContextHolder.remove();
    }
}
