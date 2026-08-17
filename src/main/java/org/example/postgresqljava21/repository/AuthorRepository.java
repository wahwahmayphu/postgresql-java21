package org.example.postgresqljava21.repository;

import org.example.postgresqljava21.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
