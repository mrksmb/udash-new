package com.smartdroplets.frontend.views.chat

import com.smartdroplets.shared.model.chat.ChatMessage
import io.udash._

case class ChatModel(msgs: Seq[ChatMessage], msgInput: String, connectionsCount: Int)
object ChatModel extends HasModelPropertyCreator[ChatModel]
