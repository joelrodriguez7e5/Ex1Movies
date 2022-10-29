package com.example.templates

import io.ktor.server.html.*
import kotlinx.html.*

class NewFilmsTemplate: Template<FlowContent> {
    override fun FlowContent.apply() {
        header {
            form {
                method = FormMethod.post
                p {
                    input {
                        type = InputType.text
                        name = "title"
                    }
                }
                p {
                    textArea {
                        name = "body"
                    }
                }
                p {
                    input {
                        type = InputType.submit
                    }
                }
            }
        }
    }
}