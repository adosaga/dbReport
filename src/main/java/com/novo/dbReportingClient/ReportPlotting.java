package com.novo.dbReportingClient;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import oracle.jdbc.pool.OracleDataSource;

public class ReportPlotting {
	public void excuteReport(CurrentReportConfig currentReportConfig) {
		try {
			OracleDataSource dataSource = new OracleDataSource();
			dataSource.setDatabaseName("AMLReport");
			String conectionString = "jdbc:oracle:thin:@"+currentReportConfig.getDbConection().getIp()+":"+
														  currentReportConfig.getDbConection().getPort()+":"+
														  currentReportConfig.getDbConection().getSid();
			dataSource.setURL(conectionString);
			dataSource.setUser(currentReportConfig.getDbConection().getUser());
			dataSource.setPassword(currentReportConfig.getDbConection().getPassword());	
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			try {
				//int i =jdbcTemplate.update("update aml_test set desc_proc=9");
				jdbcTemplate.query(currentReportConfig.getReportConfig().getQuery(), new RowCallbackHandler() {
					public void processRow(ResultSet resultSet) throws SQLException {
						ResultSetMetaData resultSetMeta =resultSet.getMetaData(); 	
						int colCount = resultSetMeta.getColumnCount();
						try {
							BufferedWriter writer = new BufferedWriter(new FileWriter(currentReportConfig.getReportConfig().getOutputPath()));
							if(currentReportConfig.getReportConfig().isHeaders()) {
								String line ="";
								for(int i=1;i<=colCount;i++) {
									//System.out.print(resultSetMeta.getColumnName(i)+" ");
									line += resultSetMeta.getColumnName(i)+currentReportConfig.getReportConfig().getSeparator();
								}
								line+="\n";
								writer.write(line);
								//System.out.println("");							
							}
							while (resultSet.next()) {
								String line="";
								for(int i=1;i<=colCount;i++) {
									line += resultSet.getString(i)+currentReportConfig.getReportConfig().getSeparator();
									//System.out.print(resultSet.getString(i)+" ");
								}
								//System.out.println("");
								line+="\n";
								writer.write(line);
							}
							writer.close();
						}catch(IOException e)
						{System.out.println(e.getMessage());}
					}
				});
				//System.out.println("Cantidad de filas modificadas: "+i);
			}
			catch(DataAccessException e) {
				System.out.println(e.getMessage());
			}
			//System.out.print(jdbcTemplate.toString());
		}
		catch(SQLException e) {
			System.out.print(e.getMessage());
		}
	}	
}
