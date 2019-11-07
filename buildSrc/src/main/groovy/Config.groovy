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

    static deps = [
            plugin     : [
                    gradle: new DependencyInfo("com.android.tools.build:gradle:$android_build_version"),
                    kotlin: new DependencyInfo("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"),
            ],

            app        : new DependencyInfo(":app"),

            fearures   : [
                    featureA: [
                            app   : new DependencyInfo(":features:featureA:app"),
                            pkg   : new DependencyInfo(":features:featureA:pkg"),
                            export: new DependencyInfo(":features:featureA:export"),
                    ],

                    featureB: [
                            app   : new DependencyInfo(":features:featureB:app"),
                            pkg   : new DependencyInfo(":features:featureB:pkg"),
                            export: new DependencyInfo(":features:featureB:export"),
                    ]
            ],

            core       : [
                    base  : new DependencyInfo(":core:base"),
                    common: new DependencyInfo(":core:common"),
            ],

            kotlin     : new DependencyInfo("org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"),

            androidx   : [
                    appcompat        : new DependencyInfo("androidx.appcompat:appcompat:1.1.0"),
                    core_ktx         : new DependencyInfo("androidx.core:core-ktx:1.1.0"),
                    constraint_layout: new DependencyInfo("androidx.constraintlayout:constraintlayout:1.1.3")
            ],

            test       : [
                    junit: new DependencyInfo("junit:junit:4.12"),

            ],

            androidTest: [
                    junit_android_ext: new DependencyInfo("androidx.test.ext:junit:1.1.1"),
                    espresso_core    : new DependencyInfo("androidx.test.espresso:espresso-core:3.2.0")
            ]
    ]

}
