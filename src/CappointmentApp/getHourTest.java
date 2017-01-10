package CappointmentApp;

import static org.junit.Assert.*;

import org.junit.Test;

public class getHourTest
{

	@Test
	public void test()
	{
		Ctime ctime = new Ctime(12, 50);
		int output = ctime.getHour();
		assertEquals(12, output);
	}

}
