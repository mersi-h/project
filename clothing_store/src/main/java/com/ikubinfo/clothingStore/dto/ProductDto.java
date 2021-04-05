package com.ikubinfo.clothingStore.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductDto {
	
	private int id;
	
	private String name;
	
	private String description;
	
	private int price;
	
	private String size;
	
	private SubcategoryDto subcategory;

}
