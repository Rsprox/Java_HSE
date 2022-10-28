package org.hse.course.tasks.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

/**
 * Сущность - "Обработчик билетов"
 */
@Entity
@Table(name = "PROCESSOR_TABLE")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Processor {

    @Id
    @Column(name = "PROCESSOR_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Название обработчика
     */
    @Column(name = "NAME")
    private String name;

    /**
     * Набор записей лога, связанных с обработчиком
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "processor")
    private Collection<Log> logItems;
}
