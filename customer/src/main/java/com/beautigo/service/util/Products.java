package com.beautigo.service.util;

import java.math.BigDecimal;

import com.beautigo.enums.DesignCategory;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Products {
	
	public Long id; 
	public String beauticianName ; 

    public String productName;

    public String image;

    @Enumerated(EnumType.STRING)
    public DesignCategory category;

    public BigDecimal price;

    public Double rating;


}
