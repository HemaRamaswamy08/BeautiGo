package com.beautigo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beautigo.model.Beautician;

public interface BeauticianRepository extends JpaRepository<Beautician, Long> {

}
