package com.rains.db;

import java.sql.Connection;

import RainsTable.RainsTableCreator;
import oracle.ucp.jdbc.PoolDataSourceFactory;

public class Pool {
	private static oracle.ucp.jdbc.PoolDataSource pool = PoolDataSourceFactory.getPoolDataSource();

	private static Connection PoolDataSource() {
		try {
			pool.setConnectionFactoryClassName("oracle.jdbc.pool.OracleDataSource");
			pool.setURL("jdbc:oracle:thin:@localhost:1521:Rains");
			pool.setUser("advlab");
			pool.setPassword("zuber");
			pool.setInitialPoolSize(5);
			return pool.getConnection();
		} catch (Exception e) {
		}
		return null;
	}

	@SuppressWarnings("finally")
	public static Connection getPool() {
		Connection con = null;
		try {
			con = pool.getConnection();
		} catch (Exception e) {
			con = PoolDataSource();
		} finally {
			return con;
		}

	}

	public static void main(String[] args) {
		RainsTableCreator.printTable(getPool(), "names");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}