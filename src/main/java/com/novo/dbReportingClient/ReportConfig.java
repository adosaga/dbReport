package com.novo.dbReportingClient;

public class ReportConfig {
    private String reportName;
    private String outputPath;
    private String conection;
    private String query;
    private String separator;
    private boolean headers;
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public String getOutputPath() {
		return outputPath;
	}
	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
	}
	public String getConection() {
		return conection;
	}
	public void setConection(String conection) {
		this.conection = conection;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getSeparator() {
		return separator;
	}
	public void setSeparator(String separator) {
		this.separator = separator;
	}
	public boolean isHeaders() {
		return headers;
	}
	public void setHeaders(boolean headers) {
		this.headers = headers;
	}
	@Override
	public String toString() {
		return "ReportConfig [reportName=" + reportName + ", outputPath=" + outputPath + ", conection=" + conection
				+ ", query=" + query + ", separator=" + separator + ", headers=" + headers + "]";
	}
    
}
