package com.kd.awssqstemplate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table("recipient")
public class RecipientEntity implements Persistable<String> {

    @Id
    private String id;

    @Column
    private String channel;

    @Column
    private String text;

    @Column
    private String address;

    @Column
    private String fullName;

    @Transient
    @ToString.Exclude
    private List<NotificationEntity> notifications;

    @Override
    public boolean isNew() {
        return id == null || id.isEmpty();
    }

}
