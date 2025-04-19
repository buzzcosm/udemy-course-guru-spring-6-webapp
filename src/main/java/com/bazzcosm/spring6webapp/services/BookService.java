package com.bazzcosm.spring6webapp.services;

import com.bazzcosm.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();

}
