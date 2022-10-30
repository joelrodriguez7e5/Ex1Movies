package com.example.templates

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
                if (content == "all") { //mostra totes les pel·lícules.
                    insert(AllFilmsTemplate(), TemplatePlaceholder())
                }
                if(content == "new"){ //mostra un formulari per introduir les dades de la pel·lícula que es vol crear.
                    insert(NewFilmsTemplate(), TemplatePlaceholder())
                }
                if (content == "add"){ //crea la pel·lícula al servidor (l’afegeix a la llista i puja la imatge).

                }
                if (content == "id"){ //mostra el detall de la pel·lícula amb l’id indicat.
                    insert(DetailFilmsTemplate(), TemplatePlaceholder())
                }
                if (content == "about"){ //pàgina d’informació (el teu nom i correu).
                    insert(AboutTemplate(), TemplatePlaceholder())
                }
            }
        }
    }
