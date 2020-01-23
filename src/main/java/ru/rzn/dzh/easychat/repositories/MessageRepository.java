package ru.rzn.dzh.easychat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rzn.dzh.easychat.models.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
