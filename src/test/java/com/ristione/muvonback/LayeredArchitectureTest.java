package com.ristione.muvonback;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;


@SuppressWarnings("unused")
@AnalyzeClasses(
        packages = "com.ristione.muvonback",
        importOptions = {ImportOption.DoNotIncludeTests.class, ImportOption.DoNotIncludeJars.class})
public class LayeredArchitectureTest {

    private static final String ROOT_PATH = "com.ristione.muvonback";
    private static final String APPLICATION_NAME = "application";
    private static final String APPLICATION_PACKAGE = ROOT_PATH + ".application";
    private static final String APPLICATION_PATH = ROOT_PATH + ".application..";

    private static final String DOMAIN_NAME = "domain";
    private static final String DOMAIN_PATH = ROOT_PATH + ".domain..";

    private static final String ENTITIES_NAME = "entities";
    private static final String ENTITIES_PATH = ROOT_PATH + ".domain.entities..";

    private static final String INFRASTRUCTURE_NAME = "infrastructure";
    private static final String INFRASTRUCTURE_PATH = ROOT_PATH + ".infrastructure..";


    static final ArchRule layering_architecture_is_complied_with =
            layeredArchitecture()
                    .consideringAllDependencies()
                    .layer(APPLICATION_NAME)
                    .definedBy(APPLICATION_PATH)
                    .layer(DOMAIN_NAME)
                    .definedBy(DOMAIN_PATH)
                    .layer(ENTITIES_NAME)
                    .definedBy(ENTITIES_PATH)
                    .layer(INFRASTRUCTURE_NAME)
                    .definedBy(INFRASTRUCTURE_PATH)
                    .whereLayer(APPLICATION_NAME)
                    .mayOnlyBeAccessedByLayers(INFRASTRUCTURE_NAME)
                    .whereLayer(DOMAIN_NAME)
                    .mayOnlyBeAccessedByLayers(APPLICATION_NAME, INFRASTRUCTURE_NAME)
                    .whereLayer(ENTITIES_NAME)
                    .mayOnlyBeAccessedByLayers(APPLICATION_NAME, INFRASTRUCTURE_NAME)
                    .whereLayer(INFRASTRUCTURE_NAME)
                    .mayOnlyBeAccessedByLayers(APPLICATION_NAME);
}
