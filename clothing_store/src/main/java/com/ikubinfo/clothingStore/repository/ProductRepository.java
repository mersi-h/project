package com.ikubinfo.clothingStore.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ikubinfo.clothingStore.entity.ProductsEntity;


@Repository
@Transactional
public class ProductRepository {
	private EntityManager entityManager;

	public ProductRepository(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	private static final String PRODUCTS_BY_ID = "SELECT products FROM ProductsEntity products where products.id =?1";

	private static final String PRODUCTS_BY_NAME = "SELECT products FROM ProductsEntity products where products.name =?1";
	
	private static final String ALL_PRODUCTS = "SELECT products FROM ProductsEntity products";
	
	private static final String PRODUCTS_BY_SUBCATEGORY = "SELECT products FROM ProductsEntity products where products.subcategory_id=?1";
	
	public List<ProductsEntity> getAllProducts() {
		TypedQuery<ProductsEntity> query = entityManager.createQuery(ALL_PRODUCTS, ProductsEntity.class);
		return query.getResultList();
	}
	
	
	public ProductsEntity getProductById(int id) {
		TypedQuery<ProductsEntity> query = entityManager.createQuery(PRODUCTS_BY_ID, ProductsEntity.class).setParameter(1,id);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public ProductsEntity getProductByName(String name) {
		TypedQuery<ProductsEntity> query = entityManager.createQuery(PRODUCTS_BY_NAME, ProductsEntity.class).setParameter(1,name);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
	public void addProduct(ProductsEntity products) {
		entityManager.persist(products);
	}

	public void updateProduct(ProductsEntity products) {
		entityManager.merge(products);
	}

	public void deleteProduct(ProductsEntity products) {
		entityManager.remove(products);
	}
	
	public List<ProductsEntity> getFilteredBySubcategory(int subcategory){
		TypedQuery<ProductsEntity> query = entityManager.createQuery(PRODUCTS_BY_SUBCATEGORY, ProductsEntity.class).setParameter(1,subcategory);
		return query.getResultList();
	}
	
	public List<ProductsEntity> getProductsSortedByFieldAndOrder(String field,String order)
	{
		String bookSortedBy;
		if(order!=null  && !order.isEmpty())
			bookSortedBy="SELECT products FROM ProductEntity products ORDER BY products."+field+" "+order.toUpperCase();
		else 
			bookSortedBy="SELECT products FROM ProductEntity products ORDER BY products."+field;
		TypedQuery<ProductsEntity> query = entityManager.createQuery(bookSortedBy, ProductsEntity.class);
		return query.getResultList();
	}
}
