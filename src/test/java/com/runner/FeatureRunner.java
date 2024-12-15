package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features= "src/test/resources/Features",
glue = "com.stepdefinitions",
dryRun = false,
plugin = {
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
}) //and or not
public class FeatureRunner extends AbstractTestNGCucumberTests{

}