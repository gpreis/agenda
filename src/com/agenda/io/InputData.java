package com.agenda.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class InputData extends Data {
	
	private FileInputStream fileInput;
	
	public InputData(String path) throws IOException {
		super(path);
	}

	public Object load() throws IOException, ClassNotFoundException {
		fileInput = new FileInputStream(getFile());
		ObjectInputStream toLoad = new ObjectInputStream(fileInput);
		return toLoad.readObject();
	}
}
