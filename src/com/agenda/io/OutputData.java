package com.agenda.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.agenda.model.AgendaTask;
import com.agenda.model.User;

public class OutputData extends BaseData {

	private FileOutputStream fileOutput;
	
	public OutputData(String path) throws IOException {
		super(path);
	}
	
	public void save() throws IOException {
		createIfNeed();
		fileOutput = new FileOutputStream(getFile());
		ObjectOutputStream toSave = new ObjectOutputStream(fileOutput);
		Data data = new Data(AgendaTask.tasks, User.users);
		toSave.writeObject(data);
		toSave.close();
	}
	
	private void createIfNeed() throws IOException {
		if(getFile().exists()) return;
		getFile().createNewFile();
	}
}