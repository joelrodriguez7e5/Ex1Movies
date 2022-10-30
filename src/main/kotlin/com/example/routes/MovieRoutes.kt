package com.example.routes
import com.example.models.*
import com.example.templates.LayoutTemplate
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.*
import java.io.File

fun Route.movieRouting() {
    /**
     * Obtener toodo de Movie
     */
    route("/movie") {

        /**
         * all: mostrarà un llistat de totes les pel·lícules.
         */
        get {
            if (movieStorage.isNotEmpty()) {
                call.respond(movieStorage)
            } else {
                call.respondText("No Movies found", status = HttpStatusCode.OK)
            }
        }

        /**
         * id: mostrarà les dades de la pel·lícula amb l’id indicat.
         */
        get("{id}") {
            val id = call.parameters["id"] ?: return@get call.respondText(
                "Missing id",
                status = HttpStatusCode.BadRequest
            )

            val movie = movieStorage.find { it.id.toString() == id } ?: return@get call.respondText(
                "No Movie with id $id", status = HttpStatusCode.NotFound
            )
            call.respond(movie)
        }
        /**
         * add: crearà una nova pel·lícula.
         */
        post {
            movieStorage.add(call.receive())
            call.respondText("Movie stored correctly", status = HttpStatusCode.Created)
            call.respond(HttpStatusCode.Created)
        }

        /**
         * delete/id: esborrarà la pel·lícula amb l’id indicat.
         */
        delete("{id}") {
            val movieID = call.parameters["id"]?.toIntOrNull()
            val result = when (movieID) {
                null -> call.respond(HttpStatusCode.BadRequest, "ID must be long")
                else -> {
                    val movie = movieStorage.firstOrNull { it.id == movieID }
                    when (movie) {
                        null -> call.respond(
                            HttpStatusCode.NotFound, "Movie with id $movieID " +
                                    "not found"
                        )

                        else -> {
                            movieStorage.remove(movie)
                            call.respond(HttpStatusCode.OK, "Movie $movieID deleted")
                        }
                    }
                }
            }
        }
        /**
         * update/id: actualitzarà les dades de la pel·lícula amb l’id indicat.
         */
        put("{id}") {
            val movieID = call.parameters["id"]?.toIntOrNull()
            val movie = call.receive<Movie>()
            val result = when (movieStorage.firstOrNull { it.id == movieID }) {
                null -> call.respond(HttpStatusCode.NotFound, "Movie with id ${movieID} not found")
                else -> {
                    for (i in movieStorage.indices) {
                        if (movieStorage[i].id == movieID) {
                            movieStorage[i] = movie
                        }
                    }
                    call.respond(HttpStatusCode.OK, "Movie Updated")
                }
            }
        }

        route("/Opinions") {
            /**
             * id/add: afegirà un comentari a la pel·lícula amb l’id indicat.
             */
            post("{idMovie}") {
                val idMovie = call.parameters["idMovie"]?.toInt()
                val opinion = call.receive<Opinions>()
                for (i in movieStorage.indices) {
                    if (movieStorage[i].idMovie != idMovie) {
                        call.respond(HttpStatusCode.NotFound, "not found this ID")
                    } else {
                        opinionStorage.add(opinion)
                        call.respond(HttpStatusCode.OK, "Opinion Added")
                    }
                }
            }

            /**
             * id/comments: mostrarà un llistat dels comentaris de la pel·lícula amb l’id indicat.
             */
            get("{idMovie}") {
                val id =
                    call.parameters["idMovie"] ?: return@get call.respondText(
                        "Missing id",
                        status = HttpStatusCode.BadRequest
                    )
                val opinion = opinionStorage.find { it.idMovie.toString() == id } ?: return@get call.respondText(
                    "No opinions with id $id", status = HttpStatusCode.NotFound
                )
                call.respond(opinion)
            }
        }
    }
    route("/Guy") {
        post() {
            val datos = call.receiveMultipart()
            var id = ""
            var name = ""
            var fileName = ""
            datos.forEachPart { part ->
                when (part) {
                    is PartData.FormItem -> {
                        if (part.name == "id") {
                            id = part.value
                        } else {
                            name = part.value
                        }
                    }

                    is PartData.FileItem -> {
                        fileName = part.originalFileName as String
                        var fileBytes = part.streamProvider().readBytes()
                        File("C:\\Users\\Joel Rodriguez\\Documents\\$fileName").writeBytes(fileBytes)
                    }

                    else -> {}
                }
            }
            val guy = Guy(id, name, fileName)
            guyList.add(guy)
            call.respondText(
                "Guy stored correctly and \"$fileName is uploaded to 'uploads/$fileName'\"",
                status = HttpStatusCode.Created
            )

        }
        get("/uploads/{imageName}") {
            val imageName = call.parameters["imageName"]
            var file = File("C:\\Users\\Joel Rodriguez\\Documents\\$imageName")
            if (file.exists()) {
                call.respondFile(File("C:\\Users\\Joel Rodriguez\\Documents\\$imageName"))
            } else {
                call.respondText("Image not found", status = HttpStatusCode.NotFound)
            }
        }
        get {
            if (guyList.isNotEmpty()) {
                call.respond(guyList)
            } else {
                call.respondText("No Movies found", status = HttpStatusCode.OK)
            }
        }
    }
    route("/") {
        get() {
            call.respondHtml(HttpStatusCode.OK) {
                head {

                    title("KTOR")
                }
                body {
                    h1 {
                        +"Movies"
                    }
                    if (movieStorage.isNotEmpty()) {
                        table {
                            tr {
                                td {
                                    +"DIRECTOR"
                                }
                                td {
                                    +"GENERO"
                                }
                                td {
                                    +"TITULO"
                                }
                                td {
                                    +"ID"
                                }
                            }
                            for (i in movieStorage) {
                                tr {
                                    td {
                                        +i.director
                                    }
                                    td {
                                        +i.genere
                                    }
                                    td {
                                        +i.titol
                                    }
                                    td {
                                        +i.id.toString()
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    route("/film") {
        get("all") {
            call.respondHtmlTemplate(LayoutTemplate()) {
                this.content = "all"
            }
        }
        get("new"){
            call.respondHtmlTemplate(LayoutTemplate()){
                this.content = "new"
            }
        }
        post("add"){

        }
        get("about"){
            call.respondHtmlTemplate(LayoutTemplate()){
                this.content = "about"
        }
   }

    }
}



