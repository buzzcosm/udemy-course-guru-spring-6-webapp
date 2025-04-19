package com.bazzcosm.spring6webapp.services;

import com.bazzcosm.spring6webapp.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();
}
