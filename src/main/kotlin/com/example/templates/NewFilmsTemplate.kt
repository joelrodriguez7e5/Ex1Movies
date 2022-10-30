package com.example.templates

import io.ktor.server.html.*
import kotlinx.html.*

class NewFilmsTemplate: Template<FlowContent> {
    override fun FlowContent.apply() {
        header {
            div {
                class form
                form {
                    method = FormMethod.post
                    p {
                        input {
                            type = InputType.text
                            name = "id"
                            placeholder = "id"
                        }
                    }
                    p {
                        input {
                            type = InputType.text
                            name = "titol"
                            placeholder = "titol"
                        }
                    }
                    p {
                        input {
                            type = InputType.text
                            name = "any"
                            placeholder = "any"
                        }
                    }
                    p {
                        input {
                            type = InputType.text
                            name = "genere"
                            placeholder = "genere"
                        }
                    }
                    p {
                        input {
                            type = InputType.text
                            name = "director"
                            placeholder = "director"
                        }
                    }
                    p {
                        input {
                            type = InputType.text
                            name = "idMovie"
                            placeholder = "idMovie"
                        }
                    }
                    p {
                        input {
                            type = InputType.submit
                            value = "Añadir pelicula"
                        }
                    }
                }
            }
        }
    }
}