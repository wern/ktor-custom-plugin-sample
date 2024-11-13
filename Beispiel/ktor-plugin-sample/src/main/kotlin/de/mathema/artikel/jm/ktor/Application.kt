package de.mathema.artikel.jm.ktor

import de.mathema.artikel.jm.ktor.plugins.configureCustomPlugin
import de.mathema.artikel.jm.ktor.plugins.configureRouting
import de.mathema.artikel.jm.ktor.plugins.configureSecurity
import de.mathema.artikel.jm.ktor.plugins.configureSerialization
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureSerialization()
    configureSecurity()
    configureRouting()
    configureCustomPlugin()
}
