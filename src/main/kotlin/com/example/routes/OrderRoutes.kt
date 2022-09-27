package com.example.routes

import com.example.models.*
import io.ktor.server.application.*
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.*

fun Route.listOrdersRoute() { //muestraTodasLasPeliculas
    get("/all") {
        if (orderStorage.isNotEmpty()) {
            call.respond(orderStorage)
        }
    }
}
fun Route.getOrderRoute() { //getDadespeliculaId
    get("/{id}") {
        val id = call.parameters["id"] ?: return@get call.respondText("Bad Request", status = HttpStatusCode.BadRequest)
        val order = orderStorage.find { it.number == id } ?: return@get call.respondText(
            "Not Found",
            status = HttpStatusCode.NotFound
        )
        call.respond(order)
    }
}

fun Route.createMovie(){
    // addMovie
    post {
        val person = call.receive<Movies>()
        val result = personRepository.save(person.copy(id = UUID.randomUUID()))
        call.respond(result)
    }
}

fun Route.createComment(){ //añadira un comentario a la pelicula con el ID indicado
    put {
        val person = call.receive<Movies>()
        val result = personRepository.save(person.copy(id = UUID.randomUUID()))
        call.respond(result)
    }
}

fun Route.update(){ //actualitzarà les dades de la pel·lícula amb l’id indicat.
    put {
            val person = call.receive<Movies>()
            val result = personRepository.save(person.copy(id = UUID.randomUUID()))
            call.respond(result)
    }
}

fun Route.deleteMovie(){ //esborrarà la pel·lícula amb l’id indicat.
    delete {

    }
}

fun Route.showCommentsId(){
    get{

    }
}


//update/id: actualitzarà les dades de la pel·lícula amb l’id indicat.
//delete/id: esborrarà la pel·lícula amb l’id indicat.
//id/comments: mostrarà un llistat dels comentaris de la pel·lícula amb l’id indicat.
