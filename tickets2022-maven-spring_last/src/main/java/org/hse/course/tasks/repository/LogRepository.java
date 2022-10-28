package org.hse.course.tasks.repository;

import org.hse.course.tasks.entities.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Optional;

/**
 * Репозиторий для работы с {@link Log}
 */
@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
    /**
     * Обратите внимание на имя метода. Будет сгенерирован запрос, возвращающий записи,
     * появившиеся после заданного врмени
     * @param timestamp время
     * @return {@link Collection} of {@link Log}
     */
    Collection<Log> findAllByTimestampAfter(ZonedDateTime timestamp);

    /**
     * Обратите внимание на запрос в {@link Query}. Для получения результат будет использован этот запрос.
     * В данном случае использован JPQL, но можно использовать и обычный SQL
     *
     * @param processorId идентификатор обработчика
     * @return {@link Collection} of {@link Log}
     */
    @Query("SELECT log FROM Log AS log WHERE log.processor.id = :processorId")
    Collection<Log> findAllByProcessorId(Long processorId);
}
