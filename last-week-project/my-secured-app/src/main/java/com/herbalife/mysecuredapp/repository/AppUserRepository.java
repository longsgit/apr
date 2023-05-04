package com.herbalife.mysecuredapp.repository;

import com.herbalife.mysecuredapp.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, String> {

}
