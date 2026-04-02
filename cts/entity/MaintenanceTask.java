package com.cts.entity;

import java.time.Instant;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.cts.enums.MaintenanceStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MaintenanceTask")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TaskID")
    private Long taskId;

    @Column(name = "AssetID", nullable = false)
    private Long assetId;

    @Column(name = "Description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "ScheduledAt")
    private Instant scheduledAt;

    @Column(name = "PerformedAt")
    private Instant performedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status")
    private MaintenanceStatus status;

    @Column(name = "NextDueDate")
    private LocalDate nextDueDate;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    

    @PreUpdate
    void preUpdate() {
        updatedAt = Instant.now();
    }
}