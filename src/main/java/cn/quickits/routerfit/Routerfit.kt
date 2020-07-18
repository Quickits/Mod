package cn.quickits.routerfit

import cn.quickits.routerfit.annotation.RouterArgName
import cn.quickits.routerfit.annotation.RouterPath
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.launcher.ARouter
import java.lang.reflect.Proxy

/**
 * @author Gavin Liu
 *
 * Created on 2020/05/4.
 */
object Routerfit {

    @Suppress("UNCHECKED_CAST")
    fun <T> create(routerService: Class<T>): T {
        return Proxy.newProxyInstance(
            routerService.classLoader,
            arrayOf<Class<*>>(routerService)
        ) { _, method, args ->

            var path: String? = null
            for (annotation in method.annotations) {
                if (annotation is RouterPath) {
                    path = annotation.path
                    break
                }
            }

            path ?: return@newProxyInstance null

            val postcard = ARouter.getInstance().build(path)

            if (args != null) {
                for (i in args.indices) {
                    var argName: String? = null
                    for (annotation in method.parameterAnnotations[i]) {
                        if (annotation is RouterArgName) {
                            argName = annotation.name
                            break
                        }
                    }

                    argName ?: break

                    withArgs(postcard, argName, args[i])
                }
            }

            return@newProxyInstance postcard.navigation()
        } as T
    }

    private fun withArgs(postcard: Postcard, name: String, value: Any) {
        when (value) {
            is String -> postcard.withString(name, value)

            is Boolean -> postcard.withBoolean(name, value)

            is Int -> postcard.withInt(name, value)

            is Long -> postcard.withLong(name, value)

            is Float -> postcard.withFloat(name, value)

            is Double -> postcard.withDouble(name, value)

            is Byte -> postcard.withByte(name, value)

            else -> {

            }
        }

    }
}