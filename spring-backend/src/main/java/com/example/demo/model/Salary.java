package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="salary")
public class Salary {
	 
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private long Id;
		
		@Column(name="uesr_Id")
		private long uesrId;
		
		@Column(name="rate")
		private String rate;
		
		@Column(name="salary_amount")
		private String salaryAmount;
		
		public Salary(long uesrId, String rate, String salaryAmount) {
			super();
			this.uesrId = uesrId;
			this.rate = rate;
			this.salaryAmount = salaryAmount;
		}

		public Salary(){}
		
		public long getId() {
			return Id;
		}

		public void setId(long id) {
			Id = id;
		}

		public long getUesrId() {
			return uesrId;
		}

		public void setUesrId(long uesrId) {
			this.uesrId = uesrId;
		}

		public String getRate() {
			return rate;
		}

		public void setRate(String rate) {
			this.rate = rate;
		}

		public String getSalaryAmount() {
			return salaryAmount;
		}

		public void setSalaryAmount(String salaryAmount) {
			this.salaryAmount = salaryAmount;
		}

		
}
