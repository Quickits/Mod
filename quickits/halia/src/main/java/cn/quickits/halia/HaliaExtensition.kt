package cn.quickits.halia

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.processors.FlowableProcessor

/**
 * @author: taicheng
 *
 * Created on 2019-04-23.
 **/
fun <T : Any> Observable<T>.loading(data: Any? = null): FlowableProcessor<T> = LoadingDialog(this).show(data)
