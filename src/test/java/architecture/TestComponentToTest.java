package architecture;

import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.Test;

public class TestComponentToTest extends TestArchitecture {

    @Test
    public void factoryClassesShouldOnlyBeAccessedByTestModelClasses() {
        ArchRule rule = ArchRuleDefinition.classes()
                .that().resideInAPackage("..test.java.model.factories")
                .should().onlyBeAccessed().byAnyPackage("..test.java.model");
        rule.check(classes);
    }
}
