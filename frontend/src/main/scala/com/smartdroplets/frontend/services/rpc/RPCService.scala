package com.smartdroplets.frontend.services.rpc

import com.smartdroplets.shared.rpc.client.MainClientRPC
import com.smartdroplets.shared.rpc.client.chat.ChatNotificationsRPC

class RPCService(notificationsCenter: NotificationsCenter) extends MainClientRPC {
  override val chat: ChatNotificationsRPC =
    new ChatService(notificationsCenter.msgListeners, notificationsCenter.connectionsListeners)
}