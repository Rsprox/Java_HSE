package org.hse.course.tasks.controller;

import org.hse.course.tasks.dto.BaseResponse;
import org.hse.course.tasks.entities.Log;
import org.hse.course.tasks.repository.LogRepository;
import org.hse.course.tasks.repository.ProcessorRepository;
import org.hse.course.tasks.service.TicketsProcessor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Контроллер для получения информации о счастливых билетов. Работу репозиориев можно проверить под отладкой.
 */
@RestController
@RequestMapping("/tickets")
public class TicketsController {
    private Map<Integer, TicketsProcessor> processors;
    private final LogRepository logRepository;
    private final ProcessorRepository processorRepository;


    public TicketsController(final List<TicketsProcessor> processors,
                             final LogRepository logRepository,
                             final ProcessorRepository processorRepository) {
        this.processors =
                processors.stream().collect(Collectors.toMap(TicketsProcessor::getDigitsQuantity, Function.identity()));
        this.logRepository = logRepository;
        this.processorRepository = processorRepository;
    }

    @GetMapping(path = "/four")
    @Transactional
    public BaseResponse<Long> getFourDigits() {
        var processor = processors.get(4);
        logRequest(processor);

        var count = processor.getCount();
        return BaseResponse.<Long>builder().result(count).processor(processor.getName()).build();
    }

    @GetMapping(path = "/six")
    @Transactional
    public BaseResponse<Long> getSixDigits() {
        var processor = processors.get(6);
        logRequest(processor);

        var count = processor.getCount();
        return BaseResponse.<Long>builder().result(count).processor(processor.getName()).build();
    }

    @GetMapping(path = "/eight")
    @Transactional
    public BaseResponse<Long> getEightDigits() {
        var processor = processors.get(8);
        logRequest(processor);

        var count = processor.getCount();
        return BaseResponse.<Long>builder().result(count).processor(processor.getName()).build();
    }

    @GetMapping(path = "/type")
    @Transactional
    public ResponseEntity<BaseResponse<Long>> getCount(@RequestParam Integer digits) {
        var processor = Optional.ofNullable(processors.get(digits));
        processor.ifPresent(this::logRequest);

        return processor
                .map(p -> BaseResponse.<Long>builder().result(p.getCount()).processor(p.getName()).build())
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    /**
     * Сохраняет запись о работе {@link TicketsProcessor} в лог.
     * Обратите внимание, что конкретно мы сохраняем
     *
     * @param processor работающий экземпляр {@link TicketsProcessor}
     */
    private void logRequest(TicketsProcessor processor) {
        var processorEntity = processorRepository.findByName(processor.getName());
        processorEntity
                .ifPresent(proc -> {
                    var logEntity = Log.builder().timestamp(ZonedDateTime.now()).processor(proc).build();
                    proc.getLogItems().add(logEntity);
                    processorRepository.save(proc);
                });
    }
}
