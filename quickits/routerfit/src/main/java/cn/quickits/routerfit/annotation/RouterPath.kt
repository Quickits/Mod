package cn.quickits.routerfit.annotation

/**
 * @author Gavin Liu
 *
 * Created on 2020/05/4.
 */
@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class RouterPath(val path: String)
