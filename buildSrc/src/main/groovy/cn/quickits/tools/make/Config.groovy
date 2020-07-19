package cn.quickits.tools.make

class Config {

    public static applicationId = "cn.quickits.mod"
    public static appName = "Mod"

    public static compileSdkVersion = 29
    public static buildToolsVersion = "29.0.1"
    public static minSdkVersion = 21
    public static targetSdkVersion = 29
    public static versionCode = 1
    public static versionName = "1.0.0"

    public static android_build_version = "3.6.3"
    public static kotlin_version = "1.3.72"

    public static lifecycle_version = "2.2.0"

    public static deps = [
            // Plugin dependence start
            plugin          : [
                    gradle              : new DpdInfo("com.android.tools.build:gradle:$android_build_version"),
                    kotlin              : new DpdInfo("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"),
                    navigation_safe_args: new DpdInfo("androidx.navigation:navigation-safe-args-gradle-plugin:2.2.0"),
            ],

            // Local Module start
            app             : new DpdInfo(":app"),

            quickits        : [
                    all      : new DpdInfo(":quickits:all"),
                    talos    : new DpdInfo(":quickits:talos"),
                    halia    : new DpdInfo(":quickits:halia"),
                    rainbow  : new DpdInfo(":quickits:rainbow"),
                    routerfit: new DpdInfo(":quickits:routerfit"),
            ],

            fearures        : [
                    featureHalia  : [
                            app   : new DpdInfo(":features:featureHalia:app"),
                            pkg   : new DpdInfo(":features:featureHalia:pkg"),
                            export: new DpdInfo(":features:featureHalia:export"),
                    ],

                    featureRainbow: [
                            app   : new DpdInfo(":features:featureRainbow:app"),
                            pkg   : new DpdInfo(":features:featureRainbow:pkg"),
                            export: new DpdInfo(":features:featureRainbow:export"),
                    ],
            ],

            // Third-part Module start
            kotlin          : new DpdInfo("org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"),

            androidx        : [
                    appcompat              : new DpdInfo("androidx.appcompat:appcompat:1.1.0"),
                    core_ktx               : new DpdInfo("androidx.core:core-ktx:1.3.0"),
                    constraint_layout      : new DpdInfo("androidx.constraintlayout:constraintlayout:1.1.3"),

                    lifecycle_runtime_ktx  : new DpdInfo("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version"),
                    lifecycle_livedata_ktx : new DpdInfo("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"),
                    lifecycle_viewmodel_ktx: new DpdInfo("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"),

                    navigation_ui_ktx      : new DpdInfo("androidx.navigation:navigation-ui-ktx:2.2.0"),
                    navigation_fragment_ktx: new DpdInfo("androidx.navigation:navigation-fragment-ktx:2.2.0"),
            ],

            material        : new DpdInfo("com.google.android.material:material:1.1.0"),

            rxjava2         : new DpdInfo("io.reactivex.rxjava2:rxjava:2.2.19"),
            rxAndroid       : new DpdInfo("io.reactivex.rxjava2:rxandroid:2.1.1"),

            arouter         : [
                    api     : new DpdInfo("com.alibaba:arouter-api:1.5.0"),
                    compiler: new DpdInfo("com.alibaba:arouter-compiler:1.2.2"),
            ],

            material_dialogs: new DpdInfo("com.afollestad.material-dialogs:core:2.8.1"),

            // Testing Module start
            test            : [
                    junit: new DpdInfo("junit:junit:4.12"),
            ],

            androidTest     : [
                    junit_android_ext: new DpdInfo("androidx.test.ext:junit:1.1.1"),
                    espresso_core    : new DpdInfo("androidx.test.espresso:espresso-core:3.2.0"),
            ]
    ]

}
