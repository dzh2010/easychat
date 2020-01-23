package ru.rzn.dzh.easychat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.rzn.dzh.easychat.exceptions.ResourceNotFoundException;
import ru.rzn.dzh.easychat.models.Message;
import ru.rzn.dzh.easychat.repositories.MessageRepository;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> findAll() {
        return messageRepository.findAll(Sort.by("timestamp").descending());
    }

    @Override
    public List<Message> findByChatId(Long chatId) {
        return messageRepository.findByChat_Id(chatId);
    }

    @Override
    public Message findById(Long messageId) {
        return messageRepository.findById(messageId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Message with id=%s is not found", messageId)));
    }

    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public void remove(Long messageId) {
        messageRepository.deleteById(messageId);
    }
}
