package org.deepdive.apiserver.security.repository;


import org.deepdive.apiserver.security.repository.entity.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
}
