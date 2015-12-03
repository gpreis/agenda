package com.agenda.controllers;

import java.util.ArrayList;
import java.util.List;

import com.agenda.exceptions.ResourceDuplicatedException;
import com.agenda.model.User;

public abstract class BaseController<E> implements Controller<E>{
	
	private ArrayList<E> list;

	public BaseController() {
		this.list = new ArrayList<E>();
	}
	
	public BaseController(ArrayList<E> list) {
		this.list = list;
	}
	
	@Override
	public void add(E element) {
		if (list.contains(element)) {
			throw new ResourceDuplicatedException(element.getClass());
		}
		
		list.add(element);
	}

	@Override
	public abstract void add();

	@Override
	public E get(int index) {
		return list.get(index);
	}

	@Override
	public boolean remove(Object object) {
		return list.remove(object);
	}

	@Override
	public List<E> getList() {
		return list;
	}

}
