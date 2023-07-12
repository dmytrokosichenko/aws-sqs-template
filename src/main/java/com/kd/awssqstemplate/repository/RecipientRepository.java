package com.kd.awssqstemplate.repository;

import com.kd.awssqstemplate.entity.NotificationEntity;
import com.kd.awssqstemplate.entity.RecipientEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface RecipientRepository extends R2dbcRepository<RecipientEntity, String> {

}
