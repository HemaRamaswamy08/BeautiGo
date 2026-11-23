package com.beautigo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beautigo.enums.DesignCategory;
import com.beautigo.model.Design;

public interface DesignRepository extends JpaRepository<Design, Long>{
	
	 List<Design> findByBeauticianId(Long beauticianId);

	 List<Design> findByCategory(DesignCategory category);

	 List<Design> findByBeauticianIdAndCategory(
	            Long beauticianId,
	            DesignCategory category
	    );

}
