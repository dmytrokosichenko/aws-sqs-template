package com.kd.awssqstemplate.repository;

import com.kd.awssqstemplate.entity.NotificationEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface NotificationRepository extends R2dbcRepository<NotificationEntity, String> {

    Flux<NotificationEntity> findAllByRecipientUid(String uid);

}
