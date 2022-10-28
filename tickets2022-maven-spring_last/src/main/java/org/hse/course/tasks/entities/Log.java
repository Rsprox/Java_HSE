package org.hse.course.tasks.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;

/**
 * Сущность "Запись лога"
 */
@Entity
@Table(name = "LOG_TABLE")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Log {
    @Id
    @Column(name = "LOG_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Отметка времени
     */
    @Column(name = "TIME_STAMP")
    private ZonedDateTime timestamp = ZonedDateTime.now();

    /**
     * Ссылка на обработчик билетов
     */
    @ManyToOne
    @JoinColumn(name = "PROCESSOR_ID")
    private Processor processor;
}
