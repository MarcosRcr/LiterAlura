package com.marcos.LiterAlura.Repository;

import com.marcos.LiterAlura.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorRepository extends JpaRepository<Author, Long> {

}
