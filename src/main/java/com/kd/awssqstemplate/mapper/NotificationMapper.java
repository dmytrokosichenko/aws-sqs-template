package com.kd.awssqstemplate.mapper;

import com.kd.awssqstemplate.dto.NotificationDTO;
import com.kd.awssqstemplate.entity.NotificationEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    NotificationDTO map(NotificationEntity entity);

    @InheritInverseConfiguration
    NotificationEntity map(NotificationDTO dto);
}
