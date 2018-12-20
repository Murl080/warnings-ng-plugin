package io.jenkins.plugins.analysis.core.testutil;

import java.net.URL;

import com.tngtech.archunit.core.importer.ImportOption.DontIncludeTests;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;
import static com.tngtech.archunit.library.plantuml.PlantUmlArchCondition.Configurations.*;
import static com.tngtech.archunit.library.plantuml.PlantUmlArchCondition.*;

/**
 * Checks the package architecture of this plugin.
 *
 * @author Ullrich Hafner
 */
@AnalyzeClasses(packages = "io.jenkins.plugins.analysis..", importOptions = {DontIncludeTests.class})
class PackageArchitectureTest {
    private static final URL PACKAGE_DESIGN = PackageArchitectureTest.class.getResource("/design.puml");

    @ArchTest
    static final ArchRule ADHERES_TO_PACKAGE_DESIGN
            = classes().should(adhereToPlantUmlDiagram(PACKAGE_DESIGN,
            consideringOnlyDependenciesInAnyPackage("io.jenkins..")));
}
