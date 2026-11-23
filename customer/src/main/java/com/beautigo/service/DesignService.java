package com.beautigo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.beautigo.model.Design;
import com.beautigo.service.util.Products;

@Service
public interface DesignService {

	List<Products> getAllProductsByFilter(String beautician, String category, Long price);

	void addDesign(Design design);

	List<Products> getProductByBeauticianId(Long beauticianId);

}
