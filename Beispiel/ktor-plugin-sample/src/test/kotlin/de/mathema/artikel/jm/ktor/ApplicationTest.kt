package de.mathema.artikel.jm.ktor

import de.mathema.artikel.jm.ktor.plugins.configureCustomPlugin
import de.mathema.artikel.jm.ktor.plugins.configureRouting
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.config.*
import io.ktor.server.testing.*
import kotlin.test.*

class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        application {
            configureRouting()
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hello World!", bodyAsText())
        }
    }

    @Test
    fun testHeaderPresentWhenConfigured() = testApplication {
        environment {
            config = ApplicationConfig("application-test-header-on.conf")
        }
        client.get("/").apply {
            assertTrue(call.response.headers.contains("X-Cust-Rct"))
        }
    }

    @Test
    fun testHeaderNotPresentWhenNotConfigured() = testApplication {
        environment {
            config = ApplicationConfig("application-test-header-off.conf")
        }
        client.get("/").apply {
            assertFalse(call.response.headers.contains("X-Cust-Rct"))
        }
    }
}
