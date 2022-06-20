package com.CarRental.Car;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

class Car {
	private int id;
	private String name;
	private CarType carType;
	private String owner;
	private CategoryType categoryType;
	private boolean available;
	private LocalDate date;
	
	//ask for order - constructors -> otherMethods -> getters and setters
	public Car(String name, String carType, String owner, String categoryType, String available, String id, String date) {
		this.name = name;
		this.carType = CarType.valueOf(carType.toUpperCase());
		this.owner = owner;
		this.categoryType = CategoryType.valueOf(categoryType.toUpperCase());
		this.available = Boolean.parseBoolean(available);
		this.id = Integer.parseInt(id);
		this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
	
	public Car() {
	}
	
	public String getName() {
		return name;
	}

	public CarType getCarType() {
		return carType;
	}

	public String getOwner() {
		return owner;
	}

	public CategoryType getCategoryType() {
		return categoryType;
	}

	public boolean isAvailable() {
		return available;
	}

	public int getId() {
		return this.id;
	}
	
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public void setDate(LocalDate localDate) {
		this.date = localDate;
	}
	
	public LocalDate getDate() {
		return this.date;
	}
	
	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", carType=" + carType + ", owner=" + owner + ", categoryType="
				+ categoryType + ", avaiable=" + available + "]";
	}
	
	public String toFileFormat() {
		return name + ";" + carType + ";" + owner + ";" + categoryType + ";" + available + ";" + id + ";" + date.toString() + "\r\n";
	}
	
	public Car(CarBuilder carBuilder) {
		this.name = carBuilder.name;
		this.carType = carBuilder.carType;
		this.owner = carBuilder.owner;
		this.categoryType = carBuilder.categoryType;
		this.available = carBuilder.available;
		this.id = carBuilder.id;
		this.date = carBuilder.date;
	}
	
	public static class CarBuilder {
		private int id;
		private String name;
		private CarType carType;
		private String owner;
		private CategoryType categoryType;
		private boolean available;
		private LocalDate date;
		
		public CarBuilder withId(int id) {
			this.id = id;
			return this;
		}
		
		public CarBuilder withId(String id) {
			this.id = Integer.parseInt(id);
			return this;
		}
		
		public CarBuilder withName(String name) {
			this.name = name;
			return this;
		}
	
		public CarBuilder withCarType(CarType carType) {
			this.carType = carType;
			return this;
		}

		public CarBuilder withCarType(String carType) {
			this.carType = CarType.valueOf(carType.toUpperCase());
			return this;
		}

		public CarBuilder withOwner(String owner) {
			this.owner = owner;
			return this;
		}

		public CarBuilder withCategoryType(CategoryType categoryType) {
			this.categoryType = categoryType;
			return this;
		}
		
		public CarBuilder withCategoryType(String categoryType) {
			this.categoryType = CategoryType.valueOf(categoryType.toUpperCase());
			return this;
		}

		public CarBuilder withAvailable(boolean available) {
			this.available = available;
			return this;
		}
		
		public CarBuilder withAvailable(String available) {
			this.available = Boolean.parseBoolean(available);
			return this;
		}

		public CarBuilder withLocalDate(LocalDate date) {
			this.date = date;
			return this;
		}
		
		public CarBuilder withLocalDate(String date) {
			this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			return this;
		}
		
		public Car build() {
			return new Car(this);
		}

		@Override
		public int hashCode() {
			return Objects.hash(available, carType, categoryType, id, name, owner);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CarBuilder other = (CarBuilder) obj;
			return available == other.available && carType == other.carType && categoryType == other.categoryType
					&& id == other.id && Objects.equals(name, other.name) && Objects.equals(owner, other.owner);
		}
		
		
	}
}
