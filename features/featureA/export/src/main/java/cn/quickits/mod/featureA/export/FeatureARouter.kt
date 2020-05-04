package cn.quickits.mod.featureA.export

import cn.quickits.routerfit.annotation.RouterPath

/**
 * @author Gavin Liu
 *
 * Created on 2020/05/4.
 */
interface FeatureARouter {

    @RouterPath(path = "/featureA/main")
    fun launchFeatureA()

}