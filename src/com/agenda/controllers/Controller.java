package com.agenda.controllers;

import java.util.List;

public interface Controller<E> {	
	
	public void add(E element);
	public void add();
	
	public E get(int index);
	public boolean remove(Object object);	
	
	public List<E> getList();
	
}
