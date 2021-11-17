package com.employee.entity;

import java.util.Objects;

public class Employee {
		private int id;
		private String firstname;
		private String lastname;
		private String telephone;		
		
		//Constructor from Superclass
		public Employee() {
			super();
		}

		//Constructor using fields
		public Employee(int id, String firstname, String lastname, String telephone) {
			super();
			this.id = id;
			this.firstname = firstname;
			this.lastname = lastname;
			this.telephone = telephone;
		}
		
		//Getters and Setters
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
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
		public String getTelephone() {
			return telephone;
		}
		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}

		@Override
		public int hashCode() {
			return Objects.hash(firstname, id, lastname, telephone);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Employee other = (Employee) obj;
			return Objects.equals(firstname, other.firstname) && id == other.id
					&& Objects.equals(lastname, other.lastname) && Objects.equals(telephone, other.telephone);
		}
		
		
		
		
}
