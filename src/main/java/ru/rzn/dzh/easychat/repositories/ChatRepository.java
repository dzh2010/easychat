package ru.rzn.dzh.easychat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.rzn.dzh.easychat.models.Chat;

@Repository
@Transactional
public interface ChatRepository extends JpaRepository<Chat, Long> {
}
