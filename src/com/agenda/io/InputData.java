package com.agenda.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.agenda.model.AgendaTask;
import com.agenda.model.User;


public class InputData extends BaseData {
	
	private FileInputStream fileInput;
	
	public InputData(String path) throws IOException {
		super(path);
	}

	public void load() throws IOException, ClassNotFoundException {
		fileInput = new FileInputStream(getFile());
		ObjectInputStream toLoad = new ObjectInputStream(fileInput);
		Data data = (Data) toLoad.readObject();
		User.users = data.getUsers();
		AgendaTask.tasks = data.getTasks();
	}
}
