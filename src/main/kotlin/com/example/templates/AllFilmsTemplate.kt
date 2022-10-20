package com.example.templates

import io.ktor.server.html.*
import kotlinx.html.*

class AllFilmsTemplate: Template<FlowContent> {
    override fun FlowContent.apply() {
        header {
            img {
                src = "/static/ktor.png"
            }
            nav {
                ul {
                    li {
                        a { +"Llistat de pelis" }
                    }
                    li {
                        a { +"Nova peli" }
                    }
                    li {
                        a { +"About us" }
                    }
                }
            }
            h1{
                +"Llista de pelis"
            }
            table {
                tr {
                    td {
                        +"IMG"
                    }
                    td{
                        +"Film title"
                    }
                    td{
                        +"Show details"
                    }
                }
                tr {
                    td {
                        +"IMG"
                    }
                    td {
                        +"Film title"
                    }
                    td {
                        +"Show details"
                    }
                }
                tr {
                    td {
                        +"IMG"
                    }
                    td {
                        +"Film title"
                    }
                    td {
                        +"Show details"
                    }
                }
            }
        }
    }
}
