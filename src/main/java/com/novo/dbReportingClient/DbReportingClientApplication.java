package com.novo.dbReportingClient;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DbReportingClientApplication {
	public static void main(String[] args) {	
		InitialSetting x=new InitialSetting();
		CurrentReportConfig currentReportConfig = x.getCurrentReportConfig(args[0]);
		/*BDConfig y=new BDConfig();
		y.setUp();*/
		ReportPlotting y=new ReportPlotting();
		y.excuteReport(currentReportConfig);	
		//x.printSymbol();
		//SpringApplication.run(DbReportingClientApplication.class, args);
	}
}
