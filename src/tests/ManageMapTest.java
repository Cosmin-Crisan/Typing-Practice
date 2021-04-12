/**
 * 
 */
package tests;

import bussinessLogic.ManageMap;
import org.hamcrest.collection.IsMapContaining;
import org.junit.jupiter.api.*;

import static org.junit.Assert.assertThat;

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
		manageMap.setNewCharMap();
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
	@DisplayName("Simple map addition test")
	void testAddDividerToMap() {
		manageMap.addDividerToMap('a');

		assertThat(manageMap.getDividerMap(), IsMapContaining.hasEntry("a", 1));

	}

}
