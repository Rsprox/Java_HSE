package org.hse.course.tasks;

import lombok.RequiredArgsConstructor;
import org.hse.course.tasks.entities.Processor;
import org.hse.course.tasks.repository.ProcessorRepository;
import org.hse.course.tasks.service.TicketsProcessor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Серфис для инициализации БД
 */
@Service
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {
    private final ApplicationContext context;
    private final ProcessorRepository repository;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        var processors = context.getBeansOfType(TicketsProcessor.class);
        processors
                .values()
                .stream()
                .map(TicketsProcessor::getName)
                .map(Processor.builder()::name)
                .map(Processor.ProcessorBuilder::build)
                .forEach(repository::save);
    }
}
