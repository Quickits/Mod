package cn.quickits.routerfit.annotation

/**
 * @author Gavin Liu
 *
 * Created on 2020/05/4.
 */
@MustBeDocumented
@Target(AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class RouterArgName(val name: String)
