package com.novo.dbReportingClient;

public class CurrentReportConfig {
	private DBConection dbConection;
	private ReportConfig reportConfig;
	public DBConection getDbConection() {
		return dbConection;
	}
	public void setDbConection(DBConection dbConection) {
		this.dbConection = dbConection;
	}
	public ReportConfig getReportConfig() {
		return reportConfig;
	}
	public void setReportConfig(ReportConfig reportConfig) {
		this.reportConfig = reportConfig;
	}
	
}
