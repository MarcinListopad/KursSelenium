package Zadanie2;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/Features/Zadanie2.feature",
        plugin = {"pretty","html:out"})



public class ZadanieTest {
}
