package com.deeptech.hibernate.work3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")

public class Employee 
{		
		@Id
		@Column(name="empid")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
	      private int empid;
		
		@Column(name="F_name")
	      private String firstname;
		
		@Column(name="L_name")
		private String lastname;
		
		
		@Column(name="designation")
	      private String designation;
		
		@Column(name="salary")
	      private double salary;

		public int getEmpid() {
			return empid;
		}

		public void setEmpid(int empid) {
			this.empid = empid;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}

		public double getSalary() {
			return salary;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}
}
		//generate getter and setter method

		