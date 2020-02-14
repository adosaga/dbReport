package com.novo.dbReportingClient;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import oracle.jdbc.pool.OracleDataSource;

public class BDConfig {
	protected void setUp() {
		try {
			OracleDataSource dataSource = new OracleDataSource();
			dataSource.setDatabaseName("Pruebita");
			dataSource.setURL("jdbc:oracle:thin:@172.24.6.113:1398:novodesa");
			dataSource.setUser("NOVOZEN");
			dataSource.setPassword("N0v0.zen");	
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			try {
				//int i =jdbcTemplate.update("update aml_test set desc_proc=9");
				jdbcTemplate.query("select * from employer", new RowCallbackHandler() {
					public void processRow(ResultSet resultSet) throws SQLException {
						while (resultSet.next()) {
							ResultSetMetaData resultSetMeta =resultSet.getMetaData(); 
							int colCount = resultSetMeta.getColumnCount();
							for(int i=1;i<=colCount;i++)
								System.out.print(resultSet.getString(i)+" ");
							System.out.println("");
							// process it
						}
					}
				});
				//System.out.println("Cantidad de filas modificadas: "+i);
			}
			catch(DataAccessException e) {
				System.out.println(e.getMessage());
			}
			System.out.print(jdbcTemplate.toString());
		}
		catch(SQLException e) {
			System.out.print(e.getMessage());
		}
	}
}
