package com.moataz.ahoy.core.data

import com.moataz.ahoy.core.BuildConfig

object CoreBuildConfig {

    // if you change the values for environments here please remember to change them in build_utils.gradle too
    internal const val QA_ENV = 1
    internal const val STAGING_ENV = 2
    internal const val PROD_ENV = 3

    const val buildEnvironment = BuildConfig.BUILD_ENVIRONMENT

    /**
     * tell you about if the build is pointing to prodution enviroment, will be false in case of Beta, Alpha or qa
     */
    const val IS_PROD_BUILD = buildEnvironment == PROD_ENV

    const val IS_QA_BUILD = buildEnvironment == QA_ENV

    /**
     * defines whether app logging will be enabled or not
     */
    const val IS_SECURITY_ENABLED = IS_PROD_BUILD

    lateinit var API_URL: String

    init {
        when (buildEnvironment) {
            QA_ENV -> {
                API_URL = BuildConfig.BASE_URL

            }
            STAGING_ENV -> {
                API_URL = BuildConfig.BASE_URL

            }
            PROD_ENV -> {
                API_URL = BuildConfig.BASE_URL
            }
        }
    }
}
