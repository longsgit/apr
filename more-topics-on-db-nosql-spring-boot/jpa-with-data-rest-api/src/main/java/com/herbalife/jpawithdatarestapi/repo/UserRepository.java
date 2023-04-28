package com.herbalife.jpawithdatarestapi.repo;

import com.herbalife.jpawithdatarestapi.entity.Topic;
import com.herbalife.jpawithdatarestapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource(exported = false)
public interface UserRepository extends JpaRepository<User, Integer> {
}
