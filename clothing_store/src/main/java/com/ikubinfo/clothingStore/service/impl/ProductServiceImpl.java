package com.ikubinfo.clothingStore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.ikubinfo.clothingStore.converter.ProductConverter;
import com.ikubinfo.clothingStore.dto.ProductDto;
import com.ikubinfo.clothingStore.dto.ProductDtoForCreate;
import com.ikubinfo.clothingStore.entity.ProductsEntity;
import com.ikubinfo.clothingStore.entity.SubcategoryEntity;
import com.ikubinfo.clothingStore.exception.CustomException;
import com.ikubinfo.clothingStore.repository.ProductRepository;
import com.ikubinfo.clothingStore.repository.SubcategoryRepository;
import com.ikubinfo.clothingStore.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	RestTemplate restTemplate;
	
	ProductRepository productRepository;
	SubcategoryRepository subcategoryRepository;
	
	public ProductServiceImpl(ProductRepository productRepository, SubcategoryRepository subcategoryRepository) {
		super();
		this.productRepository = productRepository;
		this.subcategoryRepository = subcategoryRepository;
	}

	@Override
	public List<ProductsEntity> getAllProducts() {
		
		return productRepository.getAllProducts();
	}

	@Override
	public ProductsEntity getProductById(int id) {
		
		ProductsEntity existingProduct= productRepository.getProductById(id);
		if(existingProduct ==  null) {
			throw new CustomException("Product doesn't exist!");
		}else {
			return existingProduct;
		}
	}

	@Override
	public ProductsEntity createProduct(ProductDtoForCreate products) {
		if (products != null) {
			if(products.getName()!=null) {
							if(products.getPrice()>0){
									SubcategoryEntity subcategoryFound = subcategoryRepository.getSubcategoryById(products.getSubcategory());
									if(subcategoryFound != null){
										ProductsEntity productsToAdd = ProductConverter.toEntityForCreate(products, subcategoryFound);
										productRepository.addProduct(productsToAdd);
										return productsToAdd;
									}else {
										throw new CustomException("Subcategory is mandatory");
									}

							}else {
								throw new CustomException("Price must be greater than 0");
							}
	
				} else {
					throw new CustomException("Name is mandatory");
				}
			
		}
		return null;
		
	}

	@Override
	public ProductsEntity updateProduct(ProductDto products) {
		
		ProductsEntity existingProduct= productRepository.getProductById(products.getId());
		if (products.getName() != null) {
			if (products.getPrice() > 0) {
				SubcategoryEntity subcategoryFound = subcategoryRepository
						.getSubcategoryById(products.getSubcategory().getId());
				if (subcategoryFound != null) {
					ProductsEntity productToUpdate = ProductConverter.toEntity(products);
					existingProduct.setName(productToUpdate.getName());
					existingProduct.setDescription(productToUpdate.getDescription());
					existingProduct.setPrice(productToUpdate.getPrice());
					productRepository.updateProduct(existingProduct);
					return existingProduct;
				} else {
					throw new CustomException("Subcategory is mandatory");
				}
			} else {
				throw new CustomException("Price must be greater than 0");
			}
		} else {
			throw new CustomException("Name is mandatory");
		}
}

	@Override
	public void deleteProduct(ProductDto products) {
		
		if (productRepository.getProductById(products.getId()) == null) {
			throw new CustomException("This product doesn't exists");
		} else {
			productRepository.deleteProduct(ProductConverter.toEntity(products));
		}
		
	}

	@Override
	public List<ProductsEntity> getProducts(int subcategory, String field, String order) {
		if (subcategory!=0)
			return productRepository.getFilteredBySubcategory(subcategory);
		else if (field != null && !field.isEmpty() )
			return productRepository.getProductsSortedByFieldAndOrder(field,order);	
		else
			return productRepository.getAllProducts();
	}
	

	
}
