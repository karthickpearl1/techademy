package com.techademy.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features={"src/test/resources/features"},glue = {"com.techademy.stepdefs"})
public class CukeRunnerTests extends AbstractTestNGCucumberTests {
}
