package ru.rzn.dzh.easychat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.rzn.dzh.easychat.models.Chat;
import ru.rzn.dzh.easychat.services.ChatService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ChatController {

    private ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/chats")
    public List<Chat> getAllChats() {
        return chatService.findAll();
    }

    @PostMapping("/chats")
    public Chat createChat(@Valid @RequestBody Chat chat) {
        return chatService.save(chat);
    }

    @GetMapping("/chats/{chatId}")
    public Chat getChatById(@PathVariable(value = "chatId") Long chatId) {
        return chatService.findById(chatId);
    }
}
