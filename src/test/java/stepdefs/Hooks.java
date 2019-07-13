package stepdefs;

import java.util.Properties;

import javax.swing.text.Utilities;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utilities.GenericUtils;

public class Hooks {

	Utilities refGenericUtils = new Utilities();
	public static Properties propsObject;

	@Before
	public void scenarioInitialization() {
		System.out.println("Starting of Execution");
		propsObject = GenericUtils.readPropertyFile(
				System.getProperty("user.dir") + "//src//test//java//resources//constants.properties");
	}

	@After
	public void TearDown(Scenario sc) {
		System.out.println("End of Execution");
		System.out.println("Status:" + sc.getStatus());
	}

}
