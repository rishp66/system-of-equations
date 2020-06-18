package pointAndLineClass;

import java.text.DecimalFormat;
import java.util.Scanner;

/* Rish Pednekar
 * Period 4: AP Computer Science
 */

public class SystemOfEquations {
	public static Scanner scn = new Scanner(System.in);
	public static int counter = 0;
	public static DecimalFormat fmt = new DecimalFormat("0.##");
	public static Line l1, l2;
	public static double m,b, l, n,x,y;

	public static void main(String[] args) {

		while (true) {

			for (int i = 0; i < 2; i++) {

				if (i == 0) {
					System.out.println("Please Enter First Line");
				} else if (i == 1) {
					System.out.println("Please Enter Second Line");
				}

				int choice = menu();
				System.out.println();

				if (choice == 1) {
					slopeIntercept();
					prtLn("");
				} else if (choice == 2) {
					twoPoints();
					prtLn("");
				} else if (choice == 3) {
					pointSlope();
					prtLn("");
				} else if (choice == 4) {
					standardForm();
					prtLn("");
				} else if (choice != 1 && choice != 1 && choice != 2 && choice != 3 && choice != 4) {
					prtLn("INVALID INPUT. Try again.");
					choice = menu();
					prtLn("");
				}
			}
			solution();
			l1 = new Line();
			l2 = new Line();
			counter = 0;
			// give user a choice to continue
			System.out.println("---------------------");
			System.out.println("1. Enter Another Set Of Equations \n0. Quit");
			int decide = scn.nextInt();
			if (decide == 0) {
				System.out.println("Thank You Very Much!");
				break;
			}
		}
	}

	public static void solution() {
		
		if(l1.equals(l2)||l1.isVertical() && l2.isVertical() && l1.isParallel(l2)){
			prtLn("There are infinite solutions");
		}
		else if((l1.isVertical() && l2.isVertical()) || l1.isParallel(l2)){
			prtLn("No Solutions");
			
		}
		else{
		x=l1.intersection(l2).getX();
		y=l1.intersection(l2).getY();
		prtSol(x,y);

		}
	}

	public static void standardForm() {
		prtLn("Enter A Value");
		int a = scn.nextInt();
		prtLn("Enter B Value");
		int b = scn.nextInt();
		prtLn("Enter C Value");
		int c = scn.nextInt();

		counter++;
		if (counter == 1) {
			l1 = new Line(a, b, c);
			prtLn("Equation 1 : " + l1.toString());
		} else if (counter == 2) {
			l2 = new Line(a, b, c);
			prtLn("Equation 2 : " + l2.toString());
		}
	}

	public static void twoPoints() {
		// first point
		prt("x1: ");
		double x1 = scn.nextDouble();
		prt("y1: ");
		double y1 = scn.nextDouble();
		Point p1 = new Point(x1, y1);

		// second point
		prt("x2: ");
		double x2 = scn.nextDouble();
		prt("y2: ");
		double y2 = scn.nextDouble();
		Point p2 = new Point(x2, y2);

		counter++;
		if (counter == 1) {
			l1 = new Line(p1, p2);
			prtLn("Equation 1 : " + l1.toString());
		} else if (counter == 2) {
			l2 = new Line(p1, p2);
			prtLn("Equation 2 : " + l2.toString());
		}

	}

	public static void pointSlope() {

		prt("x1: ");
		double x = scn.nextDouble();
		prt("y1: ");
		double y = scn.nextDouble();

		// point
		Point p = new Point(x, y);
		prt("Slope is: ");
		double slope = scn.nextDouble();

		counter++;
		if (counter == 1) {
			l1 = new Line(p, slope);
			prtLn("Equation 1 : " + l1.toString());
		} else if (counter == 2) {
			l2 = new Line(p, slope);
			prtLn("Equation 2 : " + l2.toString());
		}

	}

	public static void slopeIntercept() {
		prt("Please Enter Slope: ");
		double slope = scn.nextDouble();
		prt("Enter Y-Intercept: ");
		double b = scn.nextDouble();

		counter++;
		if (counter == 1) {
			l1 = new Line(slope, b);
			prtLn("Equation 1 : " + l1.toString());
		} else if (counter == 2) {
			l2 = new Line(slope, b);
			prtLn("Equation 2 : " + l2.toString());
		}

	}

	public static void prtSol(double x_, double y_) {
		prtLn("Solution is: (" + fmt.format(x_) + " , " + fmt.format(y_) + ")");
	}

	public static double in() {
		// how is this method used??
		return scn.nextDouble();
	}

	public static void prt(String str) {
		System.out.print(str);
	}

	public static void prtLn(String str) {
		System.out.println(str);
	}

	public static int menu() {
		prtLn("1. Slope and Y-Intercept");
		prtLn("2. Two Points");
		prtLn("3. Point and Slope");
		prtLn("4. Coefficients A, B and C, Standard Form Ax+By=C");
		return scn.nextInt();
	}
}
