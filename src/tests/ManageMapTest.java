/**
 * 
 */
package tests;

import bussinessLogic.ManageMap;
import org.junit.Assert;
import org.junit.jupiter.api.*;

import java.util.LinkedHashMap;

/**
 * @author dan.nicoara
 *
 */
class ManageMapTest {

	private ManageMap manageMap;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		manageMap = new ManageMap();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link bussinessLogic.ManageMap#addDividerToMap(char)}.
	 */
	@Test
	@DisplayName("Test manageMap.getDividerMap() with initial values")
	void testGetDividerMapWithInitialValues() {
		// Act
		LinkedHashMap<String, Integer> actualResult = manageMap.getDividerMap();

		// Assert
		Assert.assertFalse(actualResult.isEmpty());

		Assert.assertTrue(actualResult.containsKey("a"));
		Assert.assertTrue(actualResult.containsKey("b"));
		Assert.assertTrue(actualResult.containsKey("c"));

		Assert.assertNotNull(actualResult.get("a"));
		Assert.assertSame(actualResult.get("a"), 0);
		Assert.assertNotNull(actualResult.get("b"));
		Assert.assertSame(actualResult.get("b"), 0);
		Assert.assertNotNull(actualResult.get("c"));
		Assert.assertSame(actualResult.get("c"), 0);
	}

	/**
	 * Test method for {@link bussinessLogic.ManageMap#addDividerToMap(char)}.
	 */
	@Test
	@DisplayName("Test manageMap.getDividerMap() with one typed character")
	void testGetDividerMapWithOneTypedCharacter() {
		// Arrange
		manageMap.addDividerToMap('a');

		// Act
		LinkedHashMap<String, Integer> actualResult = manageMap.getDividerMap();

		// Assert
		Assert.assertFalse(actualResult.isEmpty());

		Assert.assertTrue(actualResult.containsKey("a"));
		Assert.assertTrue(actualResult.containsKey("b"));
		Assert.assertTrue(actualResult.containsKey("c"));

		Assert.assertNotNull(actualResult.get("a"));
		Assert.assertSame(actualResult.get("a"), 1);
		Assert.assertNotNull(actualResult.get("b"));
		Assert.assertSame(actualResult.get("b"), 0);
		Assert.assertNotNull(actualResult.get("c"));
		Assert.assertSame(actualResult.get("c"), 0);
	}

	/**
	 * Test method for {@link bussinessLogic.ManageMap#addDividerToMap(char)}.
	 */
	@Test
	@DisplayName("Test manageMap.getDividerMap() with two typed character")
	void testGetDividerMapWithTwoTypedCharacter() {
		// Arrange
		manageMap.addDividerToMap('a');
		manageMap.addDividerToMap('b');

		// Act
		LinkedHashMap<String, Integer> actualResult = manageMap.getDividerMap();

		// Assert
		Assert.assertFalse(actualResult.isEmpty());

		Assert.assertTrue(actualResult.containsKey("a"));
		Assert.assertTrue(actualResult.containsKey("b"));
		Assert.assertTrue(actualResult.containsKey("c"));

		Assert.assertNotNull(actualResult.get("a"));
		Assert.assertSame(actualResult.get("a"), 1);
		Assert.assertNotNull(actualResult.get("b"));
		Assert.assertSame(actualResult.get("b"), 1);
		Assert.assertNotNull(actualResult.get("c"));
		Assert.assertSame(actualResult.get("c"), 0);
	}

}
