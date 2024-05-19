package com.marcos.LiterAlura.Repository;

import com.marcos.LiterAlura.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IAuthorRepository extends JpaRepository<Author, Long> {
}
