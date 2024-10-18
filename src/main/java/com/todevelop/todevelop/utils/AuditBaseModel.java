package com.todevelop.todevelop.utils;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.io.Serial;
import java.io.Serializable;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

@MappedSuperclass
public abstract class AuditBaseModel extends TemporalAuditBaseModel implements Serializable {
    @Serial
    private static final long serialVersionUID = -7382907975052517137L;
    @Column(
            name = "created_by",
            updatable = false
    )
    @CreatedBy
    private String createdBy;
    @Column(
            name = "last_update_by"
    )
    @LastModifiedBy
    private String lastUpdateBy;

    public AuditBaseModel() {
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public String getLastUpdateBy() {
        return this.lastUpdateBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }
}