package com.example.templates

import io.ktor.http.*
import io.ktor.server.html.*
import kotlinx.html.*

class LayoutTemplate: Template<HTML> {
    lateinit var content: String
    override fun HTML.apply() {
        head {
            link(rel = "stylesheet", href = "/static/main.css", type = "text/css")
            link(rel = "icon", href = "/static/ktor.png", type="image/png")
        }
        body {

                if (content == "all") {
                    insert(AllFilmsTemplate(), TemplatePlaceholder())
                }
            }
        }
    }
