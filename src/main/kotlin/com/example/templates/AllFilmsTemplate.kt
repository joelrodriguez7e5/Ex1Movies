package com.example.templates

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
                        input {

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
}
