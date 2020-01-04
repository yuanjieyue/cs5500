package edu.neu.ccs;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class RangePrinter {
	
    public String printRange(int lo, int hi) {
      	StringBuilder res = new StringBuilder();
        System.out.println("The numbers between " + lo + " and " + hi + " are:");
        for (int i = lo + 1; i < hi; i++) {
        	if (i % 2 == 0) {
				res.append(i);
				if (hi % 2 == 1 && i < hi - 1 || i < hi - 2) {
					res.append(",");
				}
				System.out.println(i);
			}
        }
        
        return res.toString();
    }

    public static void main( String[] args ) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the lower bound of the range: ");
		int lo = in.nextInt();
		System.out.println("Please enter the higher bound of the range: ");
		int hi = in.nextInt();
        RangePrinter printer = new RangePrinter();
        String res = printer.printRange(lo, hi);
        System.out.println("result string is " + res);
    }
}
