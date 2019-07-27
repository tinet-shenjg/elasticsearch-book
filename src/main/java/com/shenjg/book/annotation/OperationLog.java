package com.shenjg.book.annotation;

import java.lang.annotation.*;

/**
 * 操作日志
 *
 * @author shenjg
 * @date 2019/07/26
 **/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperationLog {

    String remark() default "";

    String operType() default "0";

}
