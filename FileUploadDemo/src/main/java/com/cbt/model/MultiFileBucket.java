package com.cbt.model;

import java.util.*;

public class MultiFileBucket {
	List<FileBucket> files = new ArrayList<FileBucket>();
	
	public MultiFileBucket() {
		// TODO Auto-generated constructor stub
		files.add(new FileBucket());
        files.add(new FileBucket());
        files.add(new FileBucket());
	}

	public List<FileBucket> getFiles() {
		return files;
	}

	public void setFiles(List<FileBucket> files) {
		this.files = files;
	}
	
	
}
