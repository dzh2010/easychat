package ru.rzn.dzh.easychat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.rzn.dzh.easychat.models.Message;

import java.util.List;

@Repository
@Transactional
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findByChat_Id(Long chatId);
}
