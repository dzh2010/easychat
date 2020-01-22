package ru.rzn.dzh.easychat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.rzn.dzh.easychat.exceptions.ChatNotFoundException;
import ru.rzn.dzh.easychat.models.Chat;
import ru.rzn.dzh.easychat.repositories.ChatRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ChatController {

    private ChatRepository chatRepository;

    @Autowired
    public ChatController(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @GetMapping("/chats")
    public List getAllChats() {
        return chatRepository.findAll();
    }

    @PostMapping("/chats")
    public Chat createChat(@Valid @RequestBody Chat chat) {
        return chatRepository.save(chat);
    }

    @GetMapping("/chats/{chatId}")
    public Chat getChatById(@PathVariable(value = "chatId") Long chatId) throws ChatNotFoundException {
        return chatRepository.findById(chatId).orElseThrow(() -> new ChatNotFoundException(chatId));
    }
}
