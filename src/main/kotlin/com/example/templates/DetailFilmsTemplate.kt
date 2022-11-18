package com.example.templates

import com.example.models.movieStorage
import io.ktor.server.html.*
import kotlinx.html.*

class DetailFilmsTemplate(val id: String): Template<FlowContent> {
    override fun FlowContent.apply() {

        header {
            println("3 ${id}")
            table {

                movieStorage.filter { it.id == id.toInt() }.forEach { it ->
                    tr {
                        td {
                            +"IMG"
                        }
                        td {
                            +it.titol
                        }
                        td {
                            +"Genero: ${it.genere}, \nAño: ${it.any}, \nDirector:${it.director}, \nIdMovie: ${it.idMovie}"
                        }
                    }
                }
            }
        }
    }
}