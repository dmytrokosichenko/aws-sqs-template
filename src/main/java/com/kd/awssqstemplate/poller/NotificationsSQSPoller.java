package com.kd.awssqstemplate.poller;

import com.kd.awssqstemplate.dto.NotificationDTO;
import com.kd.awssqstemplate.entity.NotificationEntity;
import com.kd.awssqstemplate.mapper.NotificationMapper;
import com.kd.awssqstemplate.repository.NotificationRepository;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class NotificationsSQSPoller {
    
    private final NotificationMapper mapper;
    private final NotificationRepository repository;

    @SqsListener(value = "${sqs.notifications.queue.name}")
    public void receiveMessage(@Payload NotificationDTO message) {
        log.info("Received: {}", message);
        NotificationEntity entity = mapper.map(message);
        repository.save(entity).subscribe();
    }
}
