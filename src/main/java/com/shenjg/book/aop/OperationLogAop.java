package com.shenjg.book.aop;

import com.shenjg.book.annotation.OperationLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 使用AOP记录操作日志
 *
 * @author shenjg
 * @date 2019/07/26
 **/
@Component
@Aspect
public class OperationLogAop {

    public OperationLogAop() {
        System.out.println("Aop");
    }

    /**
     * 切点
     */
    @Pointcut("@annotation(com.shenjg.book.annotation.OperationLog)")
    public void methodCachePointcut() {
    }

    /**
     * 切面
     *
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("methodCachePointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        Calendar ca = Calendar.getInstance();
        String operDate = df.format(ca.getTime());
        String loginName;
        String name;
        String methodRemark = getMthodRemark(point);
        String methodName = point.getSignature().getName();
        String packages = point.getThis().getClass().getName();

        // 如果是CGLIB动态生成的类
        if (packages.indexOf("$$EnhancerByCGLIB$$") > -1) {
            try {
                packages = packages.substring(0, packages.indexOf("$$"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        String operatingcontent = "";
        Object[] method_param = null;

        Object object;
        try {
            //获取方法参数
            method_param = point.getArgs();
            object = point.proceed();
        } catch (Exception e) {
            throw e;
        }

        System.out.println(operDate + " 执行了" + methodName + "方法,方法标记是" + methodRemark
                + "， 包名" + packages + "方法参数" + method_param + "obj" + object);


        return object;

    }

    /**
     * 方法异常时调用
     *
     * @param ex
     */
    public void afterThrowing(Exception ex) {
        System.out.println("afterThrowing");
        System.out.println(ex);
    }

    /**
     * 获取方法中的中文备注
     *
     * @param joinPoint
     * @return
     * @throws Exception
     */
    public static String getMthodRemark(ProceedingJoinPoint joinPoint) throws Exception {

        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();

        Class targetClass = Class.forName(targetName);
        Method[] method = targetClass.getMethods();
        String methode = "";
        for (Method m : method) {
            if (m.getName().equals(methodName)) {
                Class[] tmpCs = m.getParameterTypes();
                if (tmpCs.length == arguments.length) {
                    OperationLog methodCache = m.getAnnotation(OperationLog.class);
                    if (methodCache != null) {
                        methode = methodCache.remark();
                    }
                    break;
                }
            }
        }
        return methode;
    }
}
