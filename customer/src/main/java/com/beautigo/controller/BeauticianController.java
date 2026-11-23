package com.beautigo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beautigo.model.Beautician;
import com.beautigo.repo.BeauticianRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/beautician")
public class BeauticianController {

	private final BeauticianRepository beauticianRepository;
	
	@GetMapping("/{id}")
	public ResponseEntity<Beautician> getBeauticianById(@PathVariable Long id) {
		return beauticianRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

}
