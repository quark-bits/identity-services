package com.identity.auth.persistence.respositories;

import com.identity.auth.persistence.entities.EventEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<EventEntity,String> {
}
