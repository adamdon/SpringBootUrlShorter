package uk.co.adamdon.springbooturlshorter;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", extraGlue = "uk.co.adamdon.springbooturlshorter.commons")
public class CucumberIntegrationTest
{
}
