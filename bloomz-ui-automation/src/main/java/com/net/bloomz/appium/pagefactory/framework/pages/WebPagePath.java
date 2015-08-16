package com.net.bloomz.appium.pagefactory.framework.pages;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.annotation.Nonnull;

/**
 * An annotation on a TopLevelPage class indicating the path part of the URI to the web page resource.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface WebPagePath {

    @Nonnull String path();

    boolean isRegex() default false;

}
