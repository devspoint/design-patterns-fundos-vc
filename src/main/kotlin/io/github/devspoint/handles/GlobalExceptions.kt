package io.github.devspoint.handles

import io.github.devspoint.handles.exceptions.StartupInvalidException
import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper
import javax.ws.rs.ext.Provider

@Provider
class GlobalExceptions : ExceptionMapper<Exception> {

    override fun toResponse(exception: Exception?): Response {
        exception?.printStackTrace()
        if(exception is StartupInvalidException) {
            return Response.status(Response.Status.BAD_REQUEST)
                        .entity(Error(exception.message))
                        .build()
        }
        return Response.status(Response.Status.BAD_REQUEST)
                        .entity(Error("Tente novamente!!!"))
                        .build()        
    }

}

data class Error(
    var message: String? = null
)