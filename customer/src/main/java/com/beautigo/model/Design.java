package com.beautigo.model;

import java.math.BigDecimal;

import com.beautigo.enums.DesignCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Design {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;

	    private String image;

	    @Enumerated(EnumType.STRING)
	    private DesignCategory category;

	    private BigDecimal price;

	    private Double rating;

	    @ManyToOne
	    @JoinColumn(name = "beautician_id")
	    @JsonIgnore
	    private Beautician beautician;

}
