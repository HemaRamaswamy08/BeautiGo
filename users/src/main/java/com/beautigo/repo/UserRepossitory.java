package com.beautigo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beautigo.model.Users;

@Repository
public interface UserRepossitory extends JpaRepository<Users, Long>{

}
