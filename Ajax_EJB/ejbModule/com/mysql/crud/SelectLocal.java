package com.mysql.crud;

import java.sql.ResultSet;

import javax.ejb.Local;

@Local
public interface SelectLocal {

	public ResultSet data(String id);

}
