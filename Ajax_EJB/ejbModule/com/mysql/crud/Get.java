package com.mysql.crud;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class Get
 */
@Stateful(mappedName = "get")
@LocalBean
public class Get implements GetRemote {

	/**
	 * Default constructor.
	 */
	ArrayList<String> list;

	public Get() {
		list = new ArrayList<String>();
	}

	public void addId(String id) {
		list.add(id);
	}

	public ArrayList<String> data(String id) {
		return (list);
	}

}
