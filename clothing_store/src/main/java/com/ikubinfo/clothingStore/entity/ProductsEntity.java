package com.ikubinfo.clothingStore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="products")

public class ProductsEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;

	@Column(name="price")
	private int price;

	@Column(name="size")
	private String size;
	
	@ManyToOne
	@JoinColumn(name="subcategory_id", referencedColumnName="id")
	private SubcategoryEntity subcategory;
}
