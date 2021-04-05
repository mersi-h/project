package com.ikubinfo.clothingStore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ikubinfo.clothingStore.converter.SubcategoryConverter;
import com.ikubinfo.clothingStore.dto.SubcategoryDto;
import com.ikubinfo.clothingStore.entity.SubcategoryEntity;
import com.ikubinfo.clothingStore.service.SubcategoryService;

import io.swagger.annotations.ApiOperation;

@RestController
public class SubcategoryController {
	
	@Autowired
	SubcategoryService subcategoryService;
	
	@ApiOperation(value="Create new subcategory")
	@PostMapping("/subcategories")
	public ResponseEntity<SubcategoryDto> addSubcategory(@Valid @RequestBody SubcategoryDto subcategory) {
		return new ResponseEntity<>(SubcategoryConverter.toDto(subcategoryService.addSubcategory(subcategory)),HttpStatus.CREATED);
	}
	
	@ApiOperation(value="Update subcategory")
	@PutMapping("/subcategories")
	public ResponseEntity<SubcategoryDto> updateSubcategory(@Valid @RequestBody SubcategoryDto subcategory) {
		return new ResponseEntity<>(SubcategoryConverter.toDto(subcategoryService.updateSubcategory(subcategory)),HttpStatus.CREATED);
	}
	
	@ApiOperation(value="Delete subcategory")
	@DeleteMapping("/subcategories")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteSubcategory(@RequestBody SubcategoryDto subcategory) {
		subcategoryService.deleteSubcategory(subcategory);	
	}
	
	@ApiOperation(value="Get subcategories by id")
	@GetMapping("/subcategories/{id}")
	public ResponseEntity<SubcategoryDto> getSubcategoryById(@PathVariable int id) {
		return new ResponseEntity<>(SubcategoryConverter.toDto(subcategoryService. getSubcategoryById(id)), HttpStatus.OK);
	}
	
	@ApiOperation(value="Get all subcategories")
	@GetMapping("/subcategories")
	public ResponseEntity<List<SubcategoryDto>> getAllSubcategories(){
		
		List<SubcategoryDto> subcategories = new ArrayList<>(); 
		for(SubcategoryEntity subcategory : subcategoryService. getAllSubcategories()) {
			subcategories.add(SubcategoryConverter.toDto(subcategory));
		}
		return new ResponseEntity<>(subcategories, HttpStatus.OK);
	}

}
