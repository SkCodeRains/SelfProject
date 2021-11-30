package com.mysql.crud;

import java.util.ArrayList;

import javax.ejb.Remote;

@Remote
public interface GetRemote {

	public void addId(String id);

	public ArrayList<String> data(String id);
}
