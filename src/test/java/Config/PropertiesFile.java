package Config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import StepDefinations.GoogleSearchSteps;

public class PropertiesFile {
	static Properties prop = new Properties(); // object created for class properties as a class variable
	static String projectPath = System.getProperty("user.dir");
	static String PropertiesPath = projectPath + "/src/test/java/Config/config.properties";

	public static void main(String[] args) {
		// main method
		getProperties();
		getInputProperties();
		getUrlProperties();

	}

	public static void getProperties() {
		try {

			FileInputStream input = new FileInputStream(PropertiesPath); // location of properties config file
			prop.load(input); // property file available in this java file
			String browser = prop.getProperty("browser");
			System.out.println(browser);
			GoogleSearchSteps.browserName = browser; // set browser from config file
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();

		}
	}

	public static void getInputProperties() {
		try {

			FileInputStream inputT = new FileInputStream(PropertiesPath); // location of properties config file
			prop.load(inputT); // property file available in this java file
			String searchInText = prop.getProperty("inputText");
			System.out.println(searchInText); // just printing

			GoogleSearchSteps.inputTextData = searchInText; // set text from config file
		} catch (Exception exp) {

			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();

		}
	}

	public static void getUrlProperties() {
		try {

			FileInputStream inputU = new FileInputStream(PropertiesPath); // location of properties config file
			prop.load(inputU); // property file available in this java file
			String urlText = prop.getProperty("url");
			System.out.println(urlText); // just printing

			GoogleSearchSteps.inputUrl = urlText; // set url from config file
		} catch (Exception exp) {

			System.out.println("I dont go in this step");
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();

		}
	}

	// setting property to print result in config file passed
	public static void setProperties() {

		try {

			FileOutputStream output = new FileOutputStream(PropertiesPath);
			prop.setProperty("result", "passed"); // get property
			prop.store(output, null);// store property

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();

		}
	}
}
