package com.ikubinfo.clothingStore.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ikubinfo.clothingStore.entity.SubcategoryEntity;

@Repository
@Transactional
public class SubcategoryRepository {
	
	private EntityManager entityManager;

	public SubcategoryRepository(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	private static final String SUBCATEGORY_BY_ID = "SELECT subcategory FROM SubcategoryEntity subcategory WHERE subcategory.id =?1";

	private static final String SUBCATEGORY_BY_NAME = "SELECT subcategory FROM SubcategoryEntity subcategory where subcategory.name =?1";
	
	private static final String ALL_SUBCATEGORIES_FETCHED = "SELECT subcategory FROM SubcategoryEntity subcategory";
	

	public List<SubcategoryEntity> getAllSubcategories() {
		TypedQuery<SubcategoryEntity> query = entityManager.createQuery(ALL_SUBCATEGORIES_FETCHED, SubcategoryEntity.class);
		return query.getResultList();
	}
	
	public SubcategoryEntity getSubcategoryById(int id) {
		TypedQuery<SubcategoryEntity> query = entityManager.createQuery(SUBCATEGORY_BY_ID, SubcategoryEntity.class).setParameter(1,id);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public SubcategoryEntity getSubcategoryByName(String name) {
		TypedQuery<SubcategoryEntity> query = entityManager.createQuery(SUBCATEGORY_BY_NAME, SubcategoryEntity.class).setParameter(1,name);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public void addSubcategory(SubcategoryEntity subcategory) {
		entityManager.persist(subcategory);
	}

	public void updateSubcategory(SubcategoryEntity subcategory) {
		entityManager.merge(subcategory);
	}

	public void deleteSubcategory(SubcategoryEntity subcategory) {
		entityManager.remove(subcategory);
	}


}
