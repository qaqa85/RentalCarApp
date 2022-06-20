package com.CarRental.Car;

interface CRUDRepository<T> {	
	//C
	T create(T entity);
	//R
	Iterable<T> readAll();
	//U
	T update(T entity);
    //D
    T delete(T entity);
}
