package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import org.junit.experimental.categories.Categories.IncludeCategory;

@RunWith(Suite.class)
@IncludeCategory({ WhiteBoxTest.class, BlackBoxTest.class })
@SuiteClasses({ ConditionCoverageUnit.class, NutritionPWUnit.class, OrderBoundaryUnit.class, OrderDomainUnit.class,
		OrderEquivalenceUnit.class, ShellFSMUnit.class })
public class AllTests {

}