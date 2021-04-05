package com.ikubinfo.clothingStore.converter;

import com.ikubinfo.clothingStore.dto.SubcategoryDto;
import com.ikubinfo.clothingStore.entity.SubcategoryEntity;

public class SubcategoryConverter {
	
	public static SubcategoryDto toDto(SubcategoryEntity entity) {
		SubcategoryDto toReturn=new SubcategoryDto();
		toReturn.setId(entity.getId());
		toReturn.setName(entity.getName());
		return toReturn;
	}
	
	public static SubcategoryEntity toEntity (SubcategoryDto dto) {
		SubcategoryEntity toReturn=new SubcategoryEntity();
		toReturn.setId(dto.getId());
		toReturn.setName(dto.getName());
		return toReturn;
	}

}
