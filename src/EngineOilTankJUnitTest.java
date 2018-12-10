import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class EngineOilTankJUnitTest {
	private EngineOilTank  NManufacturer,NType,NId,NMaximumLevel, NcurrentLevel;
		String manufacturer = " Boeing";
		String type = "Einstahlig";
		String id = "98796574";
		int maximumLevel = 5;
		int currentLevel = 0 ;
		EngineOilTank test = new EngineOilTank(manufacturer,type,id,maximumLevel);
	@Test
	public void testVersion(){
		assertEquals("98796574-Einstahlig",test.version());	
	}
	@Test
	public void testIncreaseLevelTrueFalse(){
		NMaximumLevel= new EngineOilTank(null,null,null,5);
		NcurrentLevel= new EngineOilTank(null,null,null,0);
		EngineOilTank value = new EngineOilTank(null,null,null,3);
		value.increaseLevel(7);
		assertTrue(currentLevel == 5);
		}
	@Test
	public void testIncreaselLevelFalseTrue() {
		NcurrentLevel= new EngineOilTank(null,null,null,0);
		EngineOilTank value = new EngineOilTank(null,null,null,3);
		value.increaseLevel(-1);
		assertTrue(currentLevel ==0);
		} 
	@Test 
	   public void testIncreaselLevelValue(){
		NcurrentLevel= new EngineOilTank(null,null,null,1);
		EngineOilTank value = new EngineOilTank(null,null,null,3);
		value.increaseLevel(2);
		assertTrue(currentLevel == 2);
		assertFalse(currentLevel== 0);}
	@Test
	public void decreaselLevelZero(){
		NcurrentLevel= new EngineOilTank(null,null,null,1);
		EngineOilTank value1 = new EngineOilTank(null,null,null,3);
		value1.decreaseLevel(-7);
		assertTrue(currentLevel == 0);}
	@Test
	public void decreaselLevelMax(){
		NMaximumLevel= new EngineOilTank(null,null,null,5);
		NcurrentLevel= new EngineOilTank(null,null,null,7);
		EngineOilTank value = new EngineOilTank(null,null,null,3);
		value.decreaseLevel(-1);
		assertTrue(currentLevel == 5);}
	@Test
	public void decreaselLevel(){
		//NcurrentLevel= new EngineOilTank(null,null,null,7);
		EngineOilTank value = new EngineOilTank(null,null,null,1);
		value.decreaseLevel(1);
		assertTrue(currentLevel == 6);}
	@Before
	public void setUp() throws Exception {
	System.out.println("Run @Before");
	NManufacturer= new EngineOilTank("Airbus",null,null);
	NType = new EngineOilTank(null,"zweistahlig",null);
	NId= new EngineOilTank(null,null,"09876544");
	NMaximumLevel = new EngineOilTank(null,null,null,6);
	}
   @After
   public void tearDownManufacturer() throws Exception {
	   System.out.println("Run @After"); // for illustration
	   }
   @Test
   public void testGetterSetterManufacturer(){
	   System.out.println("Run @Test testGetterSetter");
	   assertEquals("Airbus",NManufacturer.getManufacturer());
	   NManufacturer.setManufacturer("Boeing");
	   assertEquals("Boeing",NManufacturer.getManufacturer());
   }  
  @Test
  public void testGetterSetterType(){
	   System.out.println("Run @Test testGetterSetter");
	   assertEquals("zweistahlig",NType.getType());
	   NType.setType("Einstahlig");
	   assertEquals("Einstahlig",NType.getType());
  }
 @Test
 public void testGetterSetterId(){
	   System.out.println("Run @Test testGetterSetter");
	    assertEquals("09876544",NId.getId());
	    NId.setId("6653890");
	   assertEquals("6653890",NId.getId());
 }
@Test
public void testGetterSetterMaximumLevelZero(){
	   System.out.println("Run @Test testGetterSetter");
	  assertEquals(6,NMaximumLevel.getMaximumLevel());
	  NMaximumLevel.setMaximumLevel(7);
	  assertEquals(7,NMaximumLevel.getMaximumLevel());
}
@Test
public void testGetterSetterMaximumLevelZer(){
	   System.out.println("Run @Test testGetterSetter");
	  assertEquals(6,NMaximumLevel.getMaximumLevel());
	  NMaximumLevel.setMaximumLevel(-1);
	  assertEquals(0,NMaximumLevel.getMaximumLevel()); }
@Test
public void testsetCurrentLevelMax() {
	NcurrentLevel = new EngineOilTank(null,null,null,5);
	 NMaximumLevel.setMaximumLevel(5);
	  assertEquals(5,NMaximumLevel.getMaximumLevel());
	  NcurrentLevel.setCurrentLevel(8);
	  assertEquals(5,NcurrentLevel.getCurrentLevel());	  
} 
@Test
public void testsetCurrentLevelZero() {
	NcurrentLevel = new EngineOilTank(null,null,null,6);
	  NcurrentLevel.setCurrentLevel(-2);
	  assertEquals(0,NcurrentLevel.getCurrentLevel());	  
} 
@Test
public void testsetCurrentLevel() {
	NcurrentLevel = new EngineOilTank(null,null,null,6);
	  NcurrentLevel.setCurrentLevel(3);
	  assertEquals(3,NcurrentLevel.getCurrentLevel());	  
} 
}
