package com.agenda.io;

import java.io.File;
import java.io.IOException;

public class Data {
	private String path;
	private File file;
	
	public Data(String path) throws IOException {
		this.path = path;
		file = new File(path);
	}
	
	public String getPath() {
		return path;
	}
	
	public File getFile() {
		return file;
	}
}
