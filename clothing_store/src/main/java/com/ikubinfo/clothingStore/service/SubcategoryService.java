package com.ikubinfo.clothingStore.service;

import java.util.List;

import com.ikubinfo.clothingStore.dto.SubcategoryDto;
import com.ikubinfo.clothingStore.entity.SubcategoryEntity;

public interface SubcategoryService {
	
	public List<SubcategoryEntity> getAllSubcategories();
	
	public SubcategoryEntity getSubcategoryById(int id);
	
	public SubcategoryEntity addSubcategory(SubcategoryDto subcategory);
	
	public SubcategoryEntity updateSubcategory(SubcategoryDto subcategory);
	
	public void deleteSubcategory(SubcategoryDto subcategory);

}
