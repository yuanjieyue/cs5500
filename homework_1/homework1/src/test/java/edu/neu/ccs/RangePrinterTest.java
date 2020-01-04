package edu.neu.ccs;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class RangePrinterTest {
	RangePrinter printer;
	@Before
	public void setUp() throws Exception {
		printer = new RangePrinter();
	}
	
	@Test
	public void printRange() {
		// test for range (2, 10)
		int lo1 = 2, hi1 = 10;
		String res1 = "4,6,8";
		Assert.assertEquals(res1, printer.printRange(lo1, hi1));
		
		int lo2 = 2, hi2 = 1;
		String res2 = "";
		Assert.assertEquals(res2, printer.printRange(lo2, hi2));
	}
}