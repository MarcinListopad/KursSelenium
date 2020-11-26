package Zadanie1;

import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/Features/Zadanie1.feature",
        plugin = {"pretty","html:out"})

public class Zadanie1Test {
}