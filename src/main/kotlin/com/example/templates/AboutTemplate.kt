package com.example.templates

import io.ktor.server.html.*
import kotlinx.html.*

class AboutTemplate: Template<FlowContent> {
    override fun FlowContent.apply() {
        header {
            h1{
                p {
                    +"Joel Rodriguez"
                }
                p {
                    +"joel.rodriguez.7e5@itb.cat"
                }
            }
        }
    }
}