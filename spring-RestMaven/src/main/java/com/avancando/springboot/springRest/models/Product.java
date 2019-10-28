package com.avancando.springboot.springRest.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Product {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@javax.validation.constraints.NotEmpty(message = "Por favor coloque um nome")
		@NotBlank(message = "Por favor coloque um nome")
		@Size(min = 4, max = 255)
		private String name;
		@NotNull(message = "Por favor coloque um valor")
		@Min(value = 0)
		private Integer qnt;
		
		private Date dateCreated;
		
		@PrePersist
		public void onPrePersist() {
			if(this.dateCreated == null) {
				this.dateCreated = new Date(System.currentTimeMillis());
					
			}
		}
		
		public Product() {
			
		}
		
		public Product(String name, Integer qnt) {
			this.name = name;
			this.qnt = qnt;
		}
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getQnt() {
			return qnt;
		}
		public void setQnt(Integer qnt) {
			this.qnt = qnt;
		}
		public Date getDateCreated() {
			return dateCreated;
		}
		public void setDateCreated(Date dateCreated) {
			this.dateCreated = dateCreated;
		}
		@Override
		public String toString() {
			return "{id: "+this.id+ ", name: "+this.name+ ", qnt: "+this.qnt+", dateCreated: "+this.dateCreated+"} ";

		}

}

