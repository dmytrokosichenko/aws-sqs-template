package com.kd.awssqstemplate.service;

import com.kd.awssqstemplate.dto.NotificationDTO;
import com.kd.awssqstemplate.mapper.NotificationMapper;
import com.kd.awssqstemplate.repository.NotificationRepository;
import com.kd.awssqstemplate.repository.RecipientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;
    private final RecipientRepository recipientRepository;
    private final NotificationMapper notificationMapper;

    public Mono<NotificationDTO> findNotificationByUid(String uid) {
        return notificationRepository.findById(uid).map(notificationMapper::map);
    }

    public Mono<NotificationDTO> findNotificationWithRecipientByUid(String uid) {
        return notificationRepository
                .findById(uid) // notification
                .flatMap(notificationEntity -> recipientRepository
                        .findById(notificationEntity.getRecipientUid())
                        .map(recipientEntity -> {
                                                notificationEntity.setRecipient(recipientEntity);
                                                return notificationEntity;
                            })
                .map(notificationMapper::map));
    }

}
