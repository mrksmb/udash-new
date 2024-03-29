package com.smartdroplets.shared.rpc.server.open

import com.smartdroplets.shared.model.auth.UserContext
import io.udash.rpc._

import scala.concurrent.Future

trait AuthRPC {
  /** Verifies provided username and password.
    * Returns a UserContext if provided data is valid. */
  def login(username: String, password: String): Future[UserContext]
}

object AuthRPC extends DefaultServerRpcCompanion[AuthRPC]
