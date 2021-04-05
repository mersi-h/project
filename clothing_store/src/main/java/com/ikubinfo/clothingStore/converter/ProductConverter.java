package com.ikubinfo.clothingStore.converter;

import com.ikubinfo.clothingStore.dto.ProductDto;
import com.ikubinfo.clothingStore.dto.ProductDtoForCreate;
import com.ikubinfo.clothingStore.entity.ProductsEntity;
import com.ikubinfo.clothingStore.entity.SubcategoryEntity;

public class ProductConverter {
	
	public static ProductDto toDto(ProductsEntity entity) {
		ProductDto toReturn = new ProductDto();
		toReturn.setId(entity.getId());
		toReturn.setName(entity.getName());
		toReturn.setDescription(entity.getDescription());
		toReturn.setPrice(entity.getPrice());
		toReturn.setSize(entity.getSize());
		toReturn.setSubcategory(SubcategoryConverter.toDto(entity.getSubcategory()));
		return toReturn;
	}

	public static ProductsEntity toEntity(ProductDto dto) {
		ProductsEntity toReturn=new ProductsEntity();
		toReturn.setId(dto.getId());
		toReturn.setName(dto.getName());
		toReturn.setDescription(dto.getDescription());
		toReturn.setPrice(dto.getPrice());
		toReturn.setSize(dto.getSize());
		toReturn.setSubcategory(SubcategoryConverter.toEntity(dto.getSubcategory()));
		return toReturn;
	}
	public static ProductsEntity toEntityForCreate(ProductDtoForCreate dto, SubcategoryEntity catEntity) {
		ProductsEntity toReturn=new ProductsEntity();
		toReturn.setId(dto.getId());
		toReturn.setName(dto.getName());
		toReturn.setDescription(dto.getDescription());
		toReturn.setPrice(dto.getPrice());
		toReturn.setSize(dto.getSize());
		toReturn.setSubcategory(catEntity);
		return toReturn;
	}

}
