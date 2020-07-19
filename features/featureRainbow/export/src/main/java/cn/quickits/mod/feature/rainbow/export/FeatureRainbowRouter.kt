package cn.quickits.mod.feature.rainbow.export

import cn.quickits.routerfit.annotation.RouterPath

/**
 * @author Gavin Liu
 *
 * Created on 2020/07/19.
 */
interface FeatureRainbowRouter {

    @RouterPath(path = "/rainbow/main")
    fun launchRainbowDemo()

}