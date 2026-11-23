package com.beautigo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beautigo.model.Design;
import com.beautigo.repo.DesignRepository;
import com.beautigo.service.DesignService;
import com.beautigo.service.util.Products;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("beautician/design")
public class DesignController {
	
	private final DesignService service ;
	private final DesignRepository designRepository;
	
	@GetMapping("all")
	public List<Products> getAllProductsByFilter(@RequestParam(required = false) String beautician, @RequestParam(required = false) String category, @RequestParam(required = false) Long price){
		return service.getAllProductsByFilter(beautician, category, price);
		
	}
	
	@GetMapping("id")
	public List<Products>  getProductByBeauticianID (@RequestParam Long id) {
		return service.getProductByBeauticianId(id);
	}
	
	@PostMapping("add")
	public void addDesign(@RequestBody Design design) {
		 service.addDesign(design);
	}
	
	@GetMapping("/design/{id}")
	public ResponseEntity<Design> getDesignById(@PathVariable Long id) {
	    return designRepository.findById(id)
	            .map(ResponseEntity::ok)
	            .orElse(ResponseEntity.notFound().build());
	}
	
}
