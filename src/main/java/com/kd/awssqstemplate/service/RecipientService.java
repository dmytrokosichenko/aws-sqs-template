package com.kd.awssqstemplate.service;

import com.kd.awssqstemplate.dto.NotificationDTO;
import com.kd.awssqstemplate.dto.RecipientDTO;
import com.kd.awssqstemplate.entity.NotificationEntity;
import com.kd.awssqstemplate.entity.RecipientEntity;
import com.kd.awssqstemplate.mapper.RecipientMapper;
import com.kd.awssqstemplate.repository.NotificationRepository;
import com.kd.awssqstemplate.repository.RecipientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipientService {
    private final NotificationRepository notificationRepository;
    private final RecipientRepository recipientRepository;
    private final RecipientMapper recipientMapper;

    public Mono<RecipientDTO> findRecipientWithNotificationsByUid(String uid) {
        return Mono.zip(recipientRepository.findById(uid),
                        notificationRepository.findAllByRecipientUid(uid).collectList()
                       )
                   .map(tuples -> {
                       RecipientEntity recipient = tuples.getT1();
                       List<NotificationEntity> notifications = tuples.getT2();
                       recipient.setNotifications(notifications);
                       return recipientMapper.map(recipient);
                   });
    }

}
