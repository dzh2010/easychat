# EasyChat

## endpoints:

### Чаты

POST /api/chats

{ "name" : "sample_name" }

GET /api/chats

### Сообщения

POST /api/chats/(:chat_id)/messages

{ "nickname" : "sample_nick", "text" : "sample_text" }

GET /api/chats/(:chat_id)/messages
