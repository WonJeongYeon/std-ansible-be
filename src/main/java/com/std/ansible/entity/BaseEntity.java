package com.std.ansible.entity;


import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;


@MappedSuperclass
@Getter
public class BaseEntity {

    @CreationTimestamp
    @Column(name = "insertAt", nullable = false, updatable = false, columnDefinition = "DATETIME default CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updateAt", nullable = false, columnDefinition = "DATETIME default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;


    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false, length = 10, columnDefinition = "VARCHAR(10) default \"ACTIVE\"")
    protected State state = State.ACTIVE;
    public enum State {
        ACTIVE, INACTIVE;
    }

}
