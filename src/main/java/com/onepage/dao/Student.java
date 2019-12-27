package com.onepage.dao;

import java.io.Serializable;

public class Student implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 6196696051045384129L;
private String nameString;

public String getNameString() {
	return nameString;
}

public void setNameString(String nameString) {
	this.nameString = nameString;
}

@Override
public String toString() {
	return "Student [nameString=" + nameString + "]";
}

public Student(String nameString) {
	super();
	this.nameString = nameString;
}

public Student() {

}
 
}
