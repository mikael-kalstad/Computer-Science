import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;

class Student_test {
	@Test 
	public void testGetName() {
		Student john = "John Deer"; 
		String expected = "John Deer";
		String result = john.getName();
		assertEquals(result, expected); 
	}
}