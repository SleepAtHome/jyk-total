package com.jyk.aop;

import com.jyk.controller.DishController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author : Jing Yuankui
 * @description : 接口切面
 * @date : Created in 2024/8/12 21:48
 */
@Aspect
@Component
public class ControllerAspect {

    private static final Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

    /**
     * 指定切入点表达式
     * public * com.hkl.modules.*.controller..*(..))
     *
     * 第一个*符号 表示返回值的类型任意；
     * .*表示包下的所有类，而...表示包、子孙包下的所有类。
     * .(..) 表示任何方法名，括号表示参数，两个点表示任何参数类型
     */
    @Pointcut("execution(* com.jyk.controller..*.*(..))")
    public void pointcut(){}

    /*
    @Around:环绕增强，相当于MethodInterceptor

@AfterReturning:后置增强，相当于AfterReturningAdvice，方法正常退出时执行

@Before:标识一个前置增强方法，相当于BeforeAdvice的功能，相似功能的还有

@AfterThrowing:异常抛出增强，相当于ThrowsAdvice

@After:final增强，不管是抛出异常或者正常退出都会执行
     */

    // 前置通知
    @Before("pointcut()")
    public void beforeMethod(JoinPoint joinPoint) {
        logger.info("Before method pointCut: {}", joinPoint.getSignature().getName());

        // 处理请求头
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                String headerValue = request.getHeader(headerName);
                // 这里可以根据需要处理请求头信息
                logger.info("{} : {}", headerName, headerValue);
            }
        }


    }
}
