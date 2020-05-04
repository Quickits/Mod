package cn.quickits.mod.feature.halia.export

import cn.quickits.routerfit.annotation.RouterPath

/**
 * @author Gavin Liu
 *
 * Created on 2020/05/4.
 */
interface FeatureHaliaRouter {

    @RouterPath(path = "/halia/main")
    fun launchHaliaDemo()

}