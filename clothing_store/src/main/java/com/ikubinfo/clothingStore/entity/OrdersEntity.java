package com.ikubinfo.clothingStore.entity;

import java.time.LocalDateTime;

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
@Table(name="orders")

public class OrdersEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="total")
	private double total;
	
	@Column(name="shipping_adress")
	private String shippingAdress;
	
	@Column(name="order_adress")
	private String orderAdress;
	
	@Column(name="order_date")
	private LocalDateTime orderDate;
	
	@ManyToOne
	@JoinColumn(name="user_id", referencedColumnName="id")
	private UsersEntity users;
}
