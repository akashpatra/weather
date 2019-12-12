package com.akash.weather.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author Akash Patra
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface Activity {
}
