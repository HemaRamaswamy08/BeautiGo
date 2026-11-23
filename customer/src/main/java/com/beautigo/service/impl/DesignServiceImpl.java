package com.beautigo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.beautigo.model.Design;
import com.beautigo.repo.BeauticianRepository;
import com.beautigo.repo.DesignRepository;
import com.beautigo.service.DesignService;
import com.beautigo.service.util.Products;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DesignServiceImpl implements DesignService {

	private final DesignRepository designRepository;

	@Override
	public List<Products> getAllProductsByFilter(String beautician, String category, Long price) {
		List<Design> designs = designRepository.findAll();

        return designs.stream()
                .filter(design ->
                        beautician == null ||
                        design.getBeautician().getName()
                                .equalsIgnoreCase(beautician))
                .filter(design ->
                        category == null ||
                        design.getCategory().name()
                                .equalsIgnoreCase(category))
                .map(this::convertToProduct)
                .collect(Collectors.toList());
	}

	@Override
	public void addDesign(Design design) {
		designRepository.save(design);

	}

	@Override
	public List<Products> getProductByBeauticianId(Long beauticianId) {
		List<Design> designs =
                designRepository.findByBeauticianId(beauticianId);

        return designs.stream()
                .map(this::convertToProduct)
                .collect(Collectors.toList());
	}
	

    private Products convertToProduct(Design design) {

        Products product = new Products();

        product.setId(design.getId());

        product.setProductName(design.getName());

        product.setImage(design.getImage());

        product.setCategory(design.getCategory());

        product.setPrice(design.getPrice());

        product.setRating(design.getRating());

        if (design.getBeautician() != null) {
            product.setBeauticianName(
                    design.getBeautician().getName());
        }

        return product;
    }

}
