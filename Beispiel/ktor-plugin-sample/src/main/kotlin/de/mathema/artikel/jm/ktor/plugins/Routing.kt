package de.mathema.artikel.jm.ktor.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing { // entspricht install(RoutingRoot)
        get("/") {
            call.respondText("Hello World!")
        }
    }
}
