package de.mathema.artikel.jm.ktor.plugins

import de.mathema.artikel.jm.ktor.plugins.customplugin.MyFirstPlugin
import io.ktor.server.application.*

fun Application.configureCustomPlugin() {
    install(MyFirstPlugin) /*{
        logTime = true
        addTimeCustomHeader = true
    }*/
}