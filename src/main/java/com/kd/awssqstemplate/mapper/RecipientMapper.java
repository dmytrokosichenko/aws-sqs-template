package com.kd.awssqstemplate.mapper;

import com.kd.awssqstemplate.dto.RecipientDTO;
import com.kd.awssqstemplate.entity.RecipientEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecipientMapper {

    RecipientDTO map(RecipientEntity entity);

    @InheritInverseConfiguration
    RecipientEntity map(RecipientDTO dto);
}
