package com.example.ecommercespring.entity;

// Importing JPA annotations like @Id, @Column used for mapping class to a database structure
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

// Instant class from Java Time API to represent timestamps in UTC
import java.time.Instant;

// is JPA annotation used to define the base class that will be inherited by other entities
//Unlike @Entity, @MappedSuperclass does not create a table in the database
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class BaseEntity {


    @Id
    // Primary key for the entity
    // Using GenerationType.IDENTITY for auto-incrementing primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreatedDate
    // Automatically set the creation timestamp
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    // Automatically set the last updated timestamp
    @Column(nullable = false)
    private Instant updatedAt;


    // This method as automatically called before the entity is saved for the first time
    @PrePersist
    protected void onCreate(){
        Instant now = Instant.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    // Method to update the last updated timestamp before updating the entity
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = Instant.now();
    }
}
