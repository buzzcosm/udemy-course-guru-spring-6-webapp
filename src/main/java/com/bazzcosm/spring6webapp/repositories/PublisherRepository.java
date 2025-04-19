package com.bazzcosm.spring6webapp.repositories;

import com.bazzcosm.spring6webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
