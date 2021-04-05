package com.ikubinfo.clothingStore.service;

import java.util.List;


import com.ikubinfo.clothingStore.dto.ProductDto;
import com.ikubinfo.clothingStore.dto.ProductDtoForCreate;
import com.ikubinfo.clothingStore.entity.ProductsEntity;

public interface ProductService {
	
	public List<ProductsEntity> getAllProducts();
	
	public ProductsEntity getProductById(int id);
	
	public ProductsEntity createProduct(ProductDtoForCreate products);
	
	public ProductsEntity updateProduct(ProductDto products);
	
	public void deleteProduct(ProductDto products);

	public List<ProductsEntity> getProducts(int subcategory, String field, String order);
	
	

}
