package bdd_testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features ="src/test/resources/Feature_file",
        glue="Stepdefanation",
        dryRun =false ,
        tags="@cart_functionality"

)

public class Bdd_runner extends AbstractTestNGCucumberTests {
    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
