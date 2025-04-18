package com.bazzcosm.spring6webapp.repositories;

import com.bazzcosm.spring6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
