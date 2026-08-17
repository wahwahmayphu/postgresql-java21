package org.example.postgresqljava21.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

/**
 * @author WWMP - 8/17/2026
 */
@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    // PostgreSQL Native Array (text[]) - Native Hibernate 6
    @JdbcTypeCode(SqlTypes.ARRAY)
    @Column(name = "categories")
    private List<String> categories;

    // PostgreSQL Native JSONB - Native Hibernate 6
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "metadata")
    private BookMetadata metadata;
}