package runners;

import com.franca.restassureddemo.TestsExamples;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    TestsExamples.class
})
public class AllTests {


}
