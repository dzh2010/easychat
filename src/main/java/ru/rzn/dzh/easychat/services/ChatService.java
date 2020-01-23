package ru.rzn.dzh.easychat.services;

import ru.rzn.dzh.easychat.models.Chat;

import java.util.List;

public interface ChatService {

    List<Chat> findAll();
    Chat findById(Long chatId);
    Chat save(Chat chat);
}
