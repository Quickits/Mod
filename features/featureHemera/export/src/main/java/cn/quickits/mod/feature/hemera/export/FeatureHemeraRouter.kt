package cn.quickits.mod.feature.hemera.export

import cn.quickits.routerfit.annotation.RouterPath

/**
 * @author Gavin Liu
 *
 * Created on 2020/07/19.
 */
interface FeatureHemeraRouter {

    @RouterPath(path = "/hemera/main")
    fun launchHemeraDemo()

}