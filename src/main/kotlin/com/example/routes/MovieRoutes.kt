package com.example.routes

import com.example.models.Movie
import com.example.models.movieStorage
import com.example.models.opinionStorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.movieRouting() {
    /**
     * Obtener toodo de Movie
     */
    route("/movie") {
        get {
            if (movieStorage.isNotEmpty()) {
                call.respond(movieStorage)
            } else {
                call.respondText("No Movies found", status = HttpStatusCode.OK)
            }
        }
        /**
         * obtener pelicula por ID
         */
        get("{id?}") {
            val id = call.parameters["id"] ?: return@get call.respondText(
                "Missing id",
                status = HttpStatusCode.BadRequest
            )
            val movie = movieStorage.find { it.id == id } ?: return@get call.respondText(
                    "No Movie with id $id",
                    status = HttpStatusCode.NotFound
                )
            call.respond(movie)
        }
        /**
         * Añade Movie
         */
        post {
            val customer = call.receive<Movie>()
            movieStorage.add(customer)
            call.respondText("Movie stored correctly", status = HttpStatusCode.Created)
        }
    }
    /**
     * Elimina Movie por ID
     */
    delete("{id?}") {
        val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.BadRequest)
        if (movieStorage.removeIf { it.id == id }) {
            call.respondText("Customer removed correctly", status = HttpStatusCode.Accepted)
        } else {
            call.respondText("Not Found", status = HttpStatusCode.NotFound)
        }
    }
    post get@{ //añadir por ID, un comentario al id de la pelicula
        val id = call.parameters["id"] ?: return@get call.respondText(
            "Missing id",
            status = HttpStatusCode.BadRequest
        )
        val movie = movieStorage.find { it.id == id } ?: return@get call.respondText(
            "No Movie with id $id",
            status = HttpStatusCode.NotFound
        )
        call.respond(movie)
    }
    get {// mostrar lista por id de comentarios por id de la pelicula
        val id = call.parameters["id"] ?: return@get call.respondText(
            "Missing id",
            status = HttpStatusCode.BadRequest
        )
        val opinion = opinionStorage.find { it.idMovie == id } ?: return@get call.respondText(
            "No Movie with id $id",
            status = HttpStatusCode.NotFound
        )
        call.respond(opinion)
    }
    post get@{//actualiza por id
        val id = call.parameters["id"] ?: return@get call.respondText(
            "Missing id",
            status = HttpStatusCode.BadRequest
        )
        val movie = movieStorage.find { it.id == id } ?: return@get call.respondText(
            "No Movie with id $id",
            status = HttpStatusCode.NotFound
        )
        call.respond(movie)
    }
    post get@{// id/add añadir comentario en una pelicual
        val movieId = call.parameters["idMovie"] ?: return@get call.respondText(
            "Missing id",
            status = HttpStatusCode.BadRequest
        )
        val movie = movieStorage.find { it.idMovie == movieId } ?: return@get call.respondText(
            "No Movie with id $movieId",
            status = HttpStatusCode.NotFound
        )
        call.respond(movie)
    }

}



