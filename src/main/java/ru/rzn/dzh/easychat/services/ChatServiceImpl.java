package ru.rzn.dzh.easychat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rzn.dzh.easychat.exceptions.ResourceNotFoundException;
import ru.rzn.dzh.easychat.models.Chat;
import ru.rzn.dzh.easychat.repositories.ChatRepository;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService{

    private ChatRepository chatRepository;

    @Autowired
    public ChatServiceImpl(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Override
    public List<Chat> findAll() {
        return chatRepository.findAll();
    }

    @Override
    public Chat findById(long chatId) {
        return chatRepository.findById(chatId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Chat with id=%s is not found", chatId)));
    }

    @Override
    public Chat save(Chat chat) {
        return chatRepository.save(chat);
    }
}
