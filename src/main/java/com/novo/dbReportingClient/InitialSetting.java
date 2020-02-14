package com.novo.dbReportingClient;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.Gson;
/*@Configuration
@PropertySource("classpath:configuration.properties")*/
public class InitialSetting {
	/*@Value("${mongodb.url}")
	private String mongodbUrl;*/
	public CurrentReportConfig getCurrentReportConfig(String reportKey) {
		CurrentReportConfig currentReportConfig=new CurrentReportConfig();
		String data = getString();
		Gson gson = new Gson();
		ReportingConfig map = gson.fromJson(data, ReportingConfig.class);
		//System.out.println("ip:   "+map.dbConections.get("Pichincha").ip);
		//System.out.println("ip:   "+map.reports.get("Accounts").outputPath);
		currentReportConfig.setReportConfig(map.getReportConfig(reportKey));
		currentReportConfig.setDbConection(map.getDBConection(currentReportConfig.getReportConfig().getConection()));
		System.out.println(currentReportConfig.getReportConfig().toString());
		System.out.println(currentReportConfig.getDbConection().toString());
		return currentReportConfig;
	}
	public String getString() {
		try {
			InputStream inputstream = new FileInputStream(System.getProperty("user.dir")+"\\config\\dbReportingClientConfiguration.json");
			String content = readFromInputStream(inputstream);
			//System.out.print(content);
			return content;
		}
		catch(Exception e) {
			System.out.print(e.getMessage());
		}
		return "";
	}
	
	private String readFromInputStream(InputStream inputStream)
			  throws IOException {
			    StringBuilder resultStringBuilder = new StringBuilder();
			    try (BufferedReader br
			      = new BufferedReader(new InputStreamReader(inputStream))) {
			        String line;
			        while ((line = br.readLine()) != null) {
			            resultStringBuilder.append(line).append("\n");
			        }
			    }
			  return resultStringBuilder.toString();
			}
}
