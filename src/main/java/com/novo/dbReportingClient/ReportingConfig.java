package com.novo.dbReportingClient;

import java.util.Map;

public class ReportingConfig {
	private Map<String, DBConection> dbConections;
	private Map<String, ReportConfig> reports;
	public DBConection getDBConection(String conectionKey) {
		return dbConections.get(conectionKey);
	}
	public ReportConfig getReportConfig(String reportKey) {
		return reports.get(reportKey);
	}
}
