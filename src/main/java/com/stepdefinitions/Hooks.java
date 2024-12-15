package com.stepdefinitions;

import org.apache.log4j.Logger;

import com.testingshastra.Keyword;
import com.testingshastra.util.App;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	private static final Logger LOG = Logger.getLogger(Hooks.class);

	@Before
	public void setUp() throws Exception {
		Keyword keyword = new Keyword();
		keyword.launchBrowser("Chrome");
		keyword.launchUrl(App.getAppUrl("qa"));
		LOG.info("Launched QA env url");
	}

	@After
	public void tearDown() throws Exception {
		Keyword.driver.quit();
	}
}
