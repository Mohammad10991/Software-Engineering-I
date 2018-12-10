import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatteryJUnitTest {
	private Battery a ,b,c,d,e;
		String manufacturer = "Boeing";
		String type = "Einstahlig";
		String id = "32492ß498";
		int currentPercentage = 0;
		 //Battery test = new Battery(manufacturer,type,id); 
		 int capacity= 100;
		 Battery test = new Battery(manufacturer,type,id,capacity);
	@Test
	public void testVersion() {	
	//String version = test.version();
	assertEquals("32492ß498-Einstahlig",test.version());
	}
	@Test 
	public void chargeTest(){ 	
	}
	@Test
	public void dichargeTest() {
		assertEquals(0,currentPercentage);
	}
	@Before
	public void setUp() throws Exception {
	System.out.println("Run @Before");
	a = new Battery("Airbus",null,null);
	b = new Battery(null,"zweistahlig",null);
	c = new Battery(null,null,"09876544");
	d = new Battery(null,null,null,50);
	 
	}
   @After
   public void tearDownManufacturer() throws Exception {
	   System.out.println("Run @After"); // for illustration
	   }
   @Test
   public void testGetterSetterManufacturer(){
	   System.out.println("Run @Test testGetterSetter");
	   assertEquals("Airbus",a.getManufacturer());
	   a.setManufacturer("Boeing");
	   assertEquals("Boeing",a.getManufacturer());
   }  
  @Test
  public void testGetterSetterType(){
	   System.out.println("Run @Test testGetterSetter");
	   assertEquals("zweistahlig",b.getType());
	   b.setType("Einstahlig");
	   assertEquals("Einstahlig",b.getType());
  }
 @Test
 public void testGetterSetterId(){
	   System.out.println("Run @Test testGetterSetter");
	    assertEquals("09876544",c.getId());
	   c.setId("6653890");
	   assertEquals("6653890",c.getId());
 }
@Test
public void testGetterSetterCapacity(){
	   System.out.println("Run @Test testGetterSetter");
	  assertEquals(50,d.getCapacity());
	  d.setCapacity(75);
	  assertEquals(75,d.getCapacity());
}

@Test
public void testSetterCurrentPercentage(){
	 e = new Battery(null,null,null,0);
	 e.setCurrentPercentage(101);
	 assertEquals(100,e.getCurrentPercentage());
     e.setCurrentPercentage(-1);
     assertEquals(0,e.getCurrentPercentage());
     e.setCurrentPercentage(50);
     assertEquals(50,e.getCurrentPercentage());
}

}
