package com.anmol420.url_shortener.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "urls", indexes = {
        @Index(name = "idx_short_code", columnList = "shortCode"),
        @Index(name = "idx_user_id", columnList = "userId"),
        @Index(name = "idx_expiry_date", columnList = "expiryDate")
})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 2048)
    private String originalUrl;

    @Column(nullable = false, unique = true, length = 10)
    private String shortCode;

    @Column
    private LocalDateTime expiryDate;

    @Column(nullable = false)
    private UUID userId;

    @Column(nullable = false)
    private Long clickCount = 0L;

    @Column(nullable = false)
    private Boolean isActive = true;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UUID user;

    public boolean isExpired() {
        return expiryDate != null && LocalDateTime.now().isAfter(expiryDate);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Url url = (Url) o;
        return Objects.equals(id, url.id) && Objects.equals(originalUrl, url.originalUrl) && Objects.equals(shortCode, url.shortCode) && Objects.equals(expiryDate, url.expiryDate) && Objects.equals(userId, url.userId) && Objects.equals(clickCount, url.clickCount) && Objects.equals(isActive, url.isActive) && Objects.equals(createdAt, url.createdAt) && Objects.equals(updatedAt, url.updatedAt) && Objects.equals(user, url.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, originalUrl, shortCode, expiryDate, userId, clickCount, isActive, createdAt, updatedAt, user);
    }
}
