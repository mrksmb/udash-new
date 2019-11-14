package com.smartdroplets.backend.rpc.secure

import com.smartdroplets.backend.rpc.secure.chat.ChatEndpoint
import com.smartdroplets.backend.services.DomainServices
import com.smartdroplets.shared.model.auth.UserContext
import com.smartdroplets.shared.rpc.server.secure.SecureRPC
import com.smartdroplets.shared.rpc.server.secure.chat.ChatRPC

class SecureEndpoint(implicit domainServices: DomainServices, ctx: UserContext) extends SecureRPC {
  import domainServices._

  lazy val chatEndpoint = new ChatEndpoint

  override def chat(): ChatRPC = chatEndpoint
}
