package pl.szarawara.checkout.acceptanceTests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:Feature")
public class RunAcceptanceTests {
	
}
