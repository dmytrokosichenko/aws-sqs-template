package com.kd.awssqstemplate.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kd.awssqstemplate.entity.NotificationEntity;
import org.springframework.data.relational.core.mapping.Column;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record RecipientDTO(String id,
                           String channel,
                           String text,
                           String address,
                           String fullName,
                           List<NotificationDTO> notifications) {

}
