package com.ikubinfo.clothingStore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikubinfo.clothingStore.converter.SubcategoryConverter;
import com.ikubinfo.clothingStore.dto.SubcategoryDto;
import com.ikubinfo.clothingStore.entity.SubcategoryEntity;
import com.ikubinfo.clothingStore.exception.CustomException;
import com.ikubinfo.clothingStore.repository.SubcategoryRepository;
import com.ikubinfo.clothingStore.service.SubcategoryService;

@Service
public class SubcategoryServiceImpl implements SubcategoryService {

	@Autowired
	SubcategoryRepository subcategoryRepository;
	
	@Override
	public List<SubcategoryEntity> getAllSubcategories() {
		
		return subcategoryRepository.getAllSubcategories();
	}

	@Override
	public SubcategoryEntity getSubcategoryById(int id) {
		
		SubcategoryEntity existingSubcategory= subcategoryRepository.getSubcategoryById(id);
		if(existingSubcategory==  null) {
			throw new CustomException("Subcategory doesn't exist!");
		}else {
			return existingSubcategory;
		}
	}

	@Override
	public SubcategoryEntity addSubcategory(SubcategoryDto subcategory) {
		if(subcategory!=null) {
			if(subcategory.getName()!=null) {
				SubcategoryEntity subcategoryToAdd = SubcategoryConverter.toEntity(subcategory);
				subcategoryRepository.addSubcategory(subcategoryToAdd);
				return subcategoryToAdd;
			}else {
				throw new CustomException("Name is mandatory!");
			}
			}
		return null;
		
	}

	@Override
	public SubcategoryEntity updateSubcategory(SubcategoryDto subcategory) {
		SubcategoryEntity existingSubcategory = subcategoryRepository.getSubcategoryById(subcategory.getId());
		if(existingSubcategory!=null) {
			if(subcategory.getName()!=null) {
				SubcategoryEntity subcategoryToUpdate = SubcategoryConverter.toEntity(subcategory);
				existingSubcategory.setName(subcategoryToUpdate.getName());
				subcategoryRepository.updateSubcategory(existingSubcategory);
				return existingSubcategory;
			}else {
				throw new CustomException("Name is mandatory!");
			}
		}
		return null;
		
	}

	@Override
	public void deleteSubcategory(SubcategoryDto subcategory) {
		
		if (subcategoryRepository.getSubcategoryById(subcategory.getId()) == null) {
			throw new CustomException("This product doesn't exists");
		} else {
			subcategoryRepository.deleteSubcategory(SubcategoryConverter.toEntity(subcategory));
		}
		
	}


}
