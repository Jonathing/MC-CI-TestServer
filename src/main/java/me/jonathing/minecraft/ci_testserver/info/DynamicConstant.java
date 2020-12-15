package me.jonathing.minecraft.ci_testserver.info;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation is used by Shadew's modutil to dynamically inject values into ForageCraft on build.
 *
 * @author Shadew
 * @see <a href="https://github.com/ShadewEnder/ModUtil">ModUtil Gradle Plugin by Shadew</a>
 * @since 1.0.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
public @interface DynamicConstant
{
    /**
     * The constant name to inject, set in the Gradle buildscript.
     */
    String value();
}
