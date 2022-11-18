package com.example.templates

import com.example.models.movieStorage
import io.ktor.server.html.*
import kotlinx.html.*

class AllFilmsTemplate: Template<FlowContent> {
    override fun FlowContent.apply() {
        header {
            img {
                src = "/static/ktor.png"
            }
            div {
                ul {
                    li {
                        a {
                            href = "all"
                            p {
                                +"Llistat de pelis"
                            }
                        }
                    }
                    li {
                        a {
                            href = "new"
                            p { +"Nova peli" }
                        }
                    }
                    li {
                        class seach
                        form {
                            action = "detail"
                            input {
                                type = InputType.text
                                id = "search"
                                name = "search"
                            }
                        }
                    }
                    li {
                        a {
                            href = "about"
                            p { +"About us" }
                        }
                    }
                }
            }
            div {
                h1{
                    +"Llista de pelis"
                }
            }
            div {
                class table
                table {
                    movieStorage.forEach { it ->
                        tr {
                            td {
                                +"IMG"
                            }
                            td {
                                +it.titol
                            }
                            td {
                                + "Genero: ${it.genere}, \nAño: ${it.any}, \nDirector:${it.director}, \nIdMovie: ${it.idMovie}"
                            }
                        }
                        }
                    }
                }
            }
        }
    }
