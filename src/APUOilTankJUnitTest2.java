import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class APUOilTankJUnitTest2 {
	private APUOilTank manufacturer,type,id,maximum,current;

	@Before
	public void setUpManufacturer() throws Exception {
	System.out.println("Run @Before");
	manufacturer= new APUOilTank("......",null,null);
	}
   @After
   public void tearDownManufacturer() throws Exception {
	   System.out.println("Run @After"); // for illustration
	   }
   @Test
   public void testGetterSetterManufacturer(){
	   System.out.println("Run @Test testGetterSetter");
	   String value ="Boeing";
	   manufacturer.setManufacturer(value);
	   assertEquals("erro in getter/setter",value,manufacturer.getManufacturer());
   }
   @Before
	public void setUpType() throws Exception {
	System.out.println("Run @Before");
	type = new APUOilTank(null,"....",null);
	}
  @After
  public void tearDownType() throws Exception {
	   System.out.println("Run @After"); // for illustration
	   }
  @Test
  public void testGetterSetterType(){
	   System.out.println("Run @Test testGetterSetter");
	   String value ="Einstahlig";
	   type.setType(value);
	   assertEquals("erro in getter/setter",value,type.getType());
  }
  @Before
	public void setUpId() throws Exception {
	System.out.println("Run @Before");
	id= new APUOilTank(null,null,"2384948");
	}
 @After
 public void tearDownId() throws Exception {
	   System.out.println("Run @After"); // for illustration
	   }
 @Test
 public void testGetterSetterId(){
	   System.out.println("Run @Test testGetterSetter");
	   String value ="230580";
	   id.setId(value);
	   assertEquals("erro in getter/setter",value,id.getId());
 
}
 @Before
	public void setUpMaximumLevel() throws Exception {
	System.out.println("Run @Before");
	maximum= new APUOilTank(null,null,null,5);
	}
@After
public void tearDownMaximumLevel() throws Exception {
	   System.out.println("Run @After"); // for illustration
	   }
@Test
public void testGetterSetterMaximumLevel(){
	   System.out.println("Run @Test testGetterSetter");
	   int value = 8 ;
	   maximum.setMaximumLevel(value);
	   assertEquals("erro in getter/setter",value,maximum.getMaximumLevel());
}
@Before
public void setUpCurrentLevel() throws Exception {
System.out.println("Run @Before");
current= new APUOilTank(null,null,null,5);
}
@After
public void tearDownCurrentLevel() throws Exception {
   System.out.println("Run @After"); // for illustration
   }
@Test
public void testGetterSetterCurrentLevelMax(){
   System.out.println("Run @Test testGetterSetter");
   int value = 6;
   current.setCurrentLevel(value);
   assertEquals("erro in getter/setter", value, current.getCurrentLevel());
}
@Test
public void testGetterSetterCurrentLevelZero(){
   System.out.println("Run @Test testGetterSetter");
   int value = 0 ;
   current.setCurrentLevel(value);
   assertSame("erro in getter/setter", 0 ,current.getCurrentLevel());
}
@Test
public void testGetterSetterCurrentLevel(){
   System.out.println("Run @Test testGetterSetter");
   int value = 3 ;
   current.setCurrentLevel(value);
   assertEquals("erro in getter/setter",value,current.getCurrentLevel());
}
}
