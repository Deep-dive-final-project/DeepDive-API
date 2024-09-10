package org.deepdive.apiserver.security.repository;


import org.deepdive.apiserver.security.repository.entity.BlackList;
import org.springframework.data.repository.CrudRepository;

public interface BlackListRepository extends CrudRepository<BlackList, String> {
}
