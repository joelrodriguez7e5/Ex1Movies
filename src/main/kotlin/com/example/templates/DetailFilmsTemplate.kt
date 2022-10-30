package com.example.templates

import com.example.models.movieStorage
import io.ktor.server.html.*
import kotlinx.html.FlowContent
import kotlinx.html.header
import kotlinx.html.id
import kotlinx.html.p

class DetailFilmsTemplate: Template<FlowContent> {
    override fun FlowContent.apply() {
        header {
           val movie =  movieStorage.filter { it.id == id.toInt() }
            p {
                movie[0].id
            }
            p {
                movie[0].any
            }
            p {
                movie[0].director
            }
            p {
                movie[0].genere
            }
            p {
                movie[0].titol
            }
        }
    }
}