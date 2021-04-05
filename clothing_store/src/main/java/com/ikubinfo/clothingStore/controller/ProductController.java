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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ikubinfo.clothingStore.converter.ProductConverter;
import com.ikubinfo.clothingStore.dto.ProductDto;
import com.ikubinfo.clothingStore.dto.ProductDtoForCreate;
import com.ikubinfo.clothingStore.entity.ProductsEntity;

import com.ikubinfo.clothingStore.service.ProductService;

import io.swagger.annotations.ApiOperation;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	
	@ApiOperation(value="Create new product")
	@PostMapping("/products")
	public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDtoForCreate products) {
		return new ResponseEntity<>(ProductConverter.toDto(productService.createProduct(products)),HttpStatus.CREATED);
	}
	
	@ApiOperation(value="Update product")
	@PutMapping("/products")
	public ResponseEntity<ProductDto> updateProduct(@Valid @RequestBody ProductDto products) {
		return new ResponseEntity<>(ProductConverter.toDto(productService.updateProduct(products)),HttpStatus.CREATED);
	}
	
	@ApiOperation(value="Delete product")
	@DeleteMapping("/products")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProduct(@RequestBody ProductDto products) {
		productService.deleteProduct(products);
	    
	}
	
	@ApiOperation(value="Get all products filter by id")
	@GetMapping("/products/{id}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable int id) {
		return new ResponseEntity<>(ProductConverter.toDto(productService. getProductById(id)), HttpStatus.OK);
	}
	
	@ApiOperation(value="Get all products")
	@GetMapping("/products")
	public ResponseEntity<List<ProductDto>> getAllProducts(){
		
		List<ProductDto> product = new ArrayList<>(); 
		for(ProductsEntity products : productService.getAllProducts()) {
			product.add(ProductConverter.toDto(products));
		}
		return new ResponseEntity<>(product,HttpStatus.OK);
	}
	
	@ApiOperation(value="Get all products filter by subcategory")
	@GetMapping("/products")
	public ResponseEntity<List<ProductDto>> getFilteredBySubcategory(@RequestParam(required=false) int subcategory, @RequestParam(required=false) String sortBy, @RequestParam(required=false) String order){
		
		List<ProductDto> product = new ArrayList<>(); 
		for(ProductsEntity products : productService.getProducts(subcategory,sortBy,order)) {
			product.add(ProductConverter.toDto(products));
		}
		return new ResponseEntity<>(product,HttpStatus.OK);
	}
	
}
