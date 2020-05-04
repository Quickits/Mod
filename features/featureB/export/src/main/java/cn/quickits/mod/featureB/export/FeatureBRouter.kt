package cn.quickits.mod.featureB.export

import cn.quickits.routerfit.annotation.RouterPath

/**
 * @author Gavin Liu
 *
 * Created on 2020/05/4.
 */
interface FeatureBRouter {

    @RouterPath(path = "/featureB/main")
    fun launchFeatureB()

}