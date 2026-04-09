package com.qaprosoft.carina.core.foundation.api.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SuccessfulHttpStatus {
    int status();
}
