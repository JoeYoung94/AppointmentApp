package CappointmentApp;

import static org.junit.Assert.*;

import org.junit.Test;

public class minTest 
{

	@Test
	public void test()
	{
		Ctime ctime = new Ctime(12,50);
		int output = ctime.getMin();
		assertEquals(50, output);
	}

}
