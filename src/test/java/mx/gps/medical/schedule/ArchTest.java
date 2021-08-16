package mx.gps.medical.schedule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("mx.gps.medical.schedule");

        noClasses()
            .that()
            .resideInAnyPackage("mx.gps.medical.schedule.service..")
            .or()
            .resideInAnyPackage("mx.gps.medical.schedule.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..mx.gps.medical.schedule.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
