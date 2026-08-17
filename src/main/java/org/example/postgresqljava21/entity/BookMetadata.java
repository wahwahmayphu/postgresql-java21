package org.example.postgresqljava21.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author WWMP -  8/17/2026
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookMetadata implements Serializable {
    private String publisher;
    private Integer pages;
}
