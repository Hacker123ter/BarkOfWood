package org.dw363.barkofwood.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PluginComponent {
    String value() default "";
}