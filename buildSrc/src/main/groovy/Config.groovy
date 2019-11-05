class Config {

    static applicationId = "cn.quickits.mod"
    static appName = "Mod"

    static compileSdkVersion = 29
    static buildToolsVersion = "29.0.1"
    static minSdkVersion = 21
    static targetSdkVersion = 29
    static versionCode = 1
    static versionName = "1.0.0"

    static android_build_version = "3.5.1"
    static kotlin_version = "1.3.50"

    static dependenciesConifg = [
            plugin  : [
                    gradle: "com.android.tools.build:gradle:$android_build_version",
                    kotlin: "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version",
            ],

            kotlin  : "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version",

            androidx: [
                    "appcompat"        : "androidx.appcompat:appcompat:1.1.0",
                    "core_ktx"         : "androidx.core:core-ktx:1.1.0",
                    "constraint_layout": "androidx.constraintlayout:constraintlayout:1.1.3"
            ],

            test    : [
                    "junit"            : "junit:junit:4.12",
                    "junit_android_ext": "androidx.test.ext:junit:1.1.1",
                    "espresso_core"    : "androidx.test.espresso:espresso-core:3.2.0"
            ]
    ]

}
