package com.stepdefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.testingshastra.Keyword;
import com.testingshastra.util.App;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	private static final Logger LOG = Logger.getLogger(Hooks.class);

	RemoteWebDriver driver;
	ThreadLocal<RemoteWebDriver> thread = new ThreadLocal<RemoteWebDriver>();
	@Before
	public void setUp() throws Exception {
		Keyword keyword = new Keyword();
		this.driver = keyword.launchBrowser("Chrome");
		thread.set(driver);
		keyword.launchUrl(App.getAppUrl("qa"));
		LOG.info("Launched QA env url");
	}

	@After
	public void tearDown() throws Exception {
		Keyword.driver.quit();
		thread.get().close();
		thread.remove();
	}
}
