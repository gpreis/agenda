package com.agenda.io;

import java.io.Serializable;
import java.util.ArrayList;

import com.agenda.model.AgendaTask;
import com.agenda.model.User;

public class Data implements Serializable{

	private static final long serialVersionUID = 4234071841962560838L;
	public ArrayList<AgendaTask> tasks;
	public ArrayList<User> users;
	
	public Data(ArrayList<AgendaTask> tasks, ArrayList<User> users) {
		super();
		this.tasks = tasks;
		this.users = users;
	}

	public ArrayList<AgendaTask> getTasks() {
		return tasks;
	}

	public void setTasks(ArrayList<AgendaTask> tasks) {
		this.tasks = tasks;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
}
