package ru.rzn.dzh.easychat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.rzn.dzh.easychat.models.Message;
import ru.rzn.dzh.easychat.services.ChatService;
import ru.rzn.dzh.easychat.services.MessageService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MessageController {

    private MessageService messageService;
    private ChatService chatService;

    @Autowired
    public MessageController(MessageService messageService, ChatService chatService) {
        this.messageService = messageService;
        this.chatService = chatService;
    }

    @GetMapping("/messages")
    public List<Message> getAllMessages() {
        return messageService.findAll();
    }

    @GetMapping("/chats/{chatId}/messages")
    public List<Message> getMessagesByChatId(@PathVariable(value = "chatId") Long chatId) {
        return messageService.findByChatId(chatId);
    }

    @PostMapping("/chats/{chatId}/messages")
    public Message createMessage(@PathVariable(value = "chatId") Long chatId, @Valid @RequestBody Message message) {
        message.setChat(chatService.findById(chatId));
        return messageService.save(message);
    }

//    @GetMapping("/messages/{messageId}")
//    public Message getMessageById(@PathVariable(value = "messageId") Long messageId) {
//        return messageService.findById(messageId);
//    }
//
//    @DeleteMapping("/messages/{messageId}")
//    public void removeMessage(@PathVariable(value = "messageId") Long messageId) {
//        messageService.remove(messageId);
//    }
}
