package de.mathema.artikel.jm.ktor.plugins.customplugin

import io.ktor.server.config.*

class MyFirstPluginConfiguration(appConf : ApplicationConfig) {
    var logTime: Boolean = appConf.tryGetString("logTime")?.toBoolean() ?: true
    var addTimeCustomHeader: Boolean = appConf.tryGetString("addTimeCustomHeader")?.toBoolean()  ?: false
    var customHeaderName = appConf.tryGetString("customHeaderName") ?: "X-Custom-RCT"
}