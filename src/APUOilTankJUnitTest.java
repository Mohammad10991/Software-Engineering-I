import static org.junit.Assert.*;

import org.junit.*;

public class APUOilTankJUnitTest {
	private APUOilTank NManufacturer,NType,NId,NMaximumLevel,NcurrentLevel;
	String manufacturer = "Boeing";
	String type = "Einstahlig";
	String id = "32492ß498";
	 int currentLevel = 0;
	 int maximumLevel= 5 ;
	 APUOilTank test = new APUOilTank(manufacturer,type,id,maximumLevel);
	@Test
	public void testVersion() {	
	assertEquals("32492ß498-Einstahlig",test.version());
	}
	@Test
	public void testIncreaseLevelTrueFalse(){
		NMaximumLevel= new APUOilTank(null,null,null,5);
		NcurrentLevel= new APUOilTank(null,null,null,0);
		APUOilTank value = new APUOilTank(null,null,null,3);
		value.increaseLevel(7);
		assertTrue(currentLevel == 5);
		}
	@Test
	public void testIncreaselLevelFalseTrue() {
		NcurrentLevel= new APUOilTank(null,null,null,0);
		APUOilTank value = new APUOilTank(null,null,null,3);
		value.increaseLevel(-1);
		assertTrue(currentLevel ==0);
		} 
	@Test 
	   public void testIncreaselLevelValue(){
		NcurrentLevel= new APUOilTank(null,null,null,1);
		APUOilTank value = new APUOilTank(null,null,null,3);
		value.increaseLevel(2);
		assertTrue(currentLevel == 2);
		}
	@Test
	public void decreaselLevelZero(){
		NcurrentLevel= new APUOilTank(null,null,null,1);
		APUOilTank value1 = new APUOilTank(null,null,null,3);
		value1.decreaseLevel(-7);
		assertTrue(currentLevel == 0);}
	@Test
	public void decreaselLevelMax(){
		NMaximumLevel= new APUOilTank(null,null,null,5);
		NcurrentLevel= new APUOilTank(null,null,null,7);
		APUOilTank value = new APUOilTank(null,null,null,3);
		value.decreaseLevel(-1);
		assertTrue(currentLevel == 5);}
	@Test
	public void decreaselLevel(){
		//NcurrentLevel= new EngineOilTank(null,null,null,7);
		APUOilTank value = new APUOilTank(null,null,null,1);
		value.decreaseLevel(1);
		assertTrue(currentLevel == 6);}
	@Before
	public void setUp() throws Exception {
	System.out.println("Run @Before");
	NManufacturer= new APUOilTank("Airbus",null,null);
	NType = new APUOilTank(null,"zweistahlig",null);
	NId= new APUOilTank(null,null,"09876544");
	NMaximumLevel = new APUOilTank(null,null,null,6);
	
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
public void testGetterSetterMaximumLevel(){
	   System.out.println("Run @Test testGetterSetter");
	  assertEquals(6,NMaximumLevel.getMaximumLevel());
	  NMaximumLevel.setMaximumLevel(7);
	  assertEquals(7,NMaximumLevel.getMaximumLevel());
}
@Test
public void testsetCurrentLevelMax() {
	NcurrentLevel = new APUOilTank(null,null,null,5);
	 NMaximumLevel.setMaximumLevel(5);
	  assertEquals(5,NMaximumLevel.getMaximumLevel());
	  NcurrentLevel.setCurrentLevel(8);
	  assertEquals(5,NcurrentLevel.getCurrentLevel());	  
} 
@Test
public void testsetCurrentLevelZero() {
	NcurrentLevel = new APUOilTank(null,null,null,6);
	  NcurrentLevel.setCurrentLevel(-2);
	  assertEquals(0,NcurrentLevel.getCurrentLevel());	  
} 
@Test
public void testsetCurrentLevel() {
	NcurrentLevel = new APUOilTank(null,null,null,6);
	  NcurrentLevel.setCurrentLevel(3);
	  assertEquals(3,NcurrentLevel.getCurrentLevel());	  
} 

}

