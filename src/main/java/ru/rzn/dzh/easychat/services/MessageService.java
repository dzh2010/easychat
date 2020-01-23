package ru.rzn.dzh.easychat.services;

import ru.rzn.dzh.easychat.models.Message;

import java.util.List;

public interface MessageService {

    List<Message> findAll();
    List<Message> findByChatId(Long chatId);
    Message findById(Long messageId);
    Message save(Message message);
    void remove(Long messageId);
}
