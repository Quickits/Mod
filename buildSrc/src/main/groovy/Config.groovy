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

    public static deps = [
            plugin     : [
                    gradle: new DpdInfo("com.android.tools.build:gradle:$android_build_version"),
                    kotlin: new DpdInfo("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"),
            ],

            app        : new DpdInfo(":app"),

            fearures   : [
                    featureA: [
                            app   : new DpdInfo(":features:featureA:app"),
                            pkg   : new DpdInfo(":features:featureA:pkg"),
                            export: new DpdInfo(":features:featureA:export"),
                    ],

                    featureB: [
                            app   : new DpdInfo(":features:featureB:app"),
                            pkg   : new DpdInfo(":features:featureB:pkg"),
                            export: new DpdInfo(":features:featureB:export"),
                    ]
            ],

            core       : [
                    base  : new DpdInfo(":core:base"),
                    common: new DpdInfo(":core:common"),
            ],

            kotlin     : new DpdInfo("org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"),

            androidx   : [
                    appcompat        : new DpdInfo("androidx.appcompat:appcompat:1.1.0"),
                    core_ktx         : new DpdInfo("androidx.core:core-ktx:1.1.0"),
                    constraint_layout: new DpdInfo("androidx.constraintlayout:constraintlayout:1.1.3")
            ],

            test       : [
                    junit: new DpdInfo("junit:junit:4.12"),
            ],

            androidTest: [
                    junit_android_ext: new DpdInfo("androidx.test.ext:junit:1.1.1"),
                    espresso_core    : new DpdInfo("androidx.test.espresso:espresso-core:3.2.0")
            ]
    ]

}
