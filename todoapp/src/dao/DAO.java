package dao;

import java.sql.Connection;

public class DAO implements AutoCloseable {
	private Connection conn = null;

	public void close() {
		System.out.println("===データベースとの接続を切断します=====");
	}
}