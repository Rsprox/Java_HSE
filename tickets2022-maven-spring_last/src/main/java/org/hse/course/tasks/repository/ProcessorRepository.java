package org.hse.course.tasks.repository;

import org.hse.course.tasks.entities.Processor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Репозиторий для работы с {@link Processor}
 */
@Repository
public interface ProcessorRepository extends JpaRepository<Processor, Long> {

    /**
     * Обратите внимание на возвращаемый результат
     *
     * @param name название обработчика
     * @return {@link Optional} of {@link Processor}
     */
    Optional<Processor> findByName(String name);
}
