package com.smartdroplets.backend.rpc.auth

import com.smartdroplets.backend.services.{AuthService, RpcClientsService}
import com.smartdroplets.shared.model.auth.UserContext
import com.smartdroplets.shared.rpc.server.open.AuthRPC
import io.udash.rpc.ClientId

import scala.concurrent.Future
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global

class AuthEndpoint(implicit authService: AuthService, rpcClientsService: RpcClientsService, clientId: ClientId) extends AuthRPC {
  override def login(username: String, password: String): Future[UserContext] = {
    val response = authService.login(username, password)
    response.onComplete {
      case Success(ctx) =>
        // let rpcClientsService know about a new authenticated connection
        rpcClientsService.registerAuthenticatedConnection(clientId, ctx)
      case Failure(_) => // ignore
    }
    response
  }
}
