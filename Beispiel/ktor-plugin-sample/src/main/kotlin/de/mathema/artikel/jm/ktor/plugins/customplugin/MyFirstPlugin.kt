package de.mathema.artikel.jm.ktor.plugins.customplugin

import io.ktor.server.application.*
import io.ktor.server.application.hooks.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.util.*

val MyFirstPlugin = createApplicationPlugin(
    name = "MyFirstPlugin",
    configurationPath = "mfp",
    createConfiguration = ::MyFirstPluginConfiguration
    ) {
    println("Mein erstes Plugin wurde registriert!!!")

    val logTime = pluginConfig.logTime
    val addHeader = pluginConfig.addTimeCustomHeader
    val headerName = pluginConfig.customHeaderName

    val startTimeKey = AttributeKey<Long>("requestStartTime")

    onCall {
        call -> call.apply {
            attributes.put(startTimeKey, System.currentTimeMillis())
            println("Request für ${call.request.uri} entgegengenommen.")
        }
    }

    onCallRespond {
        call -> call.apply {
            val now = System.currentTimeMillis()
            if (logTime) println("Total request computation time (RCT): ${now - attributes[startTimeKey]} ms")
            if (addHeader) response.header(headerName, "${now - attributes[startTimeKey]} ms")
        }
    }

    on(CallFailed) {
        call, t -> call.respondText { "Something went wrong!" }
    }
}