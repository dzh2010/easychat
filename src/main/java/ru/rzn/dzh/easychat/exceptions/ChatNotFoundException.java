package ru.rzn.dzh.easychat.exceptions;

public class ChatNotFoundException extends Exception {

    private Long chatId;

    public ChatNotFoundException(Long chatId) {
        super(String.format("Chat with id=%s is not found", chatId));
    }
}
