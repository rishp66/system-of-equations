package pointAndLineClass;

public class Line {
	private double b, m, xIntercept;
	private Rational b2, m2, xInt2;
	private boolean isVertical, isHorizontal;

	/* Rish Pednekar
	 * Period 4: AP Computer Science
	 */
	
	public Line() { // y=x
		m = 1;
		b = 0;
		m2 = mRat();
		b2 = bRat();
		xIntercept = 0;
		xInt2 = xIntRat();
		isVertical = false;
		isHorizontal = false;
	}

	public Line(double a, double c) {
		b = c;
		m = a;
		xIntercept = getXIntercept2();
		m2 = mRat();
		b2 = bRat();
		xIntercept = 0;
		xInt2 = xIntRat();
		isVertical = false;
	}

	public Line(int a, int b_, int c) {
		isVertical = false;
		if (b_ == 0) {
			isVertical = true;
			m = (double) c / a;
			b = 0;
		}
		if (b_ != 0) {
			b = -1.0 * c / b_;
			m = -1.0 * a / b_;

		}
		if (a != 0) {
			xIntercept = -1.0 * c / a;
		}
		m2 = mRat();
		b2 = bRat();
		xIntercept = 0;
		xInt2 = xIntRat();
	}

	public Line(Point a, double slope) {
		m = slope;
		b = a.getY() - a.getX() * m;
		isVertical = false;
		if (m != 0) {
			xIntercept = -1 * b / m;
		}
		m2 = mRat();
		b2 = bRat();
		xIntercept = 0;
		xInt2 = xIntRat();
	}

	public Line(Point a, Point b_) {
		double n = b_.getY() - a.getY();
		double d = b_.getX() - a.getX();
		isVertical = false;
		if (d == 0) {
			m = b_.getX();
			b = 0;
			isVertical = true;
		}
		if (d != 0) {
			m = n / d;
			b = a.getY() - m * a.getX();
			isVertical = false;
		}
		if (m != 0) {
			xIntercept = -1 * b / m;
		}
		m2 = mRat();
		b2 = bRat();
		xIntercept = 0;
		xInt2 = xIntRat();

	}

	public boolean equals(Line a) {
		if (a.getSlope().equals(this.getSlope()) && a.getYIntercept().equals(this.getYIntercept())) {
			return true;

		} else {
			return false;
		}

	}

	public double evaluate(double a) {
		return m * a + b;

	}

	public Rational getSlope() {
		return m2;
	}

	public double getSlope2() {
		return m;
	}

	public double getXIntercept2() {
		xIntercept = -1 * b / m;
		return xIntercept;
	}

	public Rational mRat() {
		return toRational(m);
	}

	public Rational bRat() {
		return toRational(b);

	}

	public Rational xIntRat() {
		return toRational(xIntercept);
	}

	public Rational getXIntercept() {
		xIntercept = -1 * b / m;
		return xInt2;
	}

	public Rational getYIntercept() {
		return b2;
	}

	public boolean isConsistent(Line a) {
		if (this.isParallel(a)) {
			return false;
		}
		return true;
	}

	public Point intersection(Line a) {

		Rational x1 = new Rational(0, 1), b1, m2, b2 = new Rational(0, 1);

		if (this.isParallel(a) == true) {
			return null;
		} else if (this.isVertical() == true || a.isVertical() == true) {
			if (this.isVertical() == true) {
				x1 = this.getSlope();
			} else if (a.isVertical() == true) {
				x1 = a.getSlope();
			}

			b1 = this.getSlope().multiply(a.getSlope()).add(b2);
			Point c = new Point(x1, b1);
			return c;

		} else {

			m2 = this.getSlope().subtract(a.getSlope());
			b2 = (a.getYIntercept().subtract(this.getYIntercept()));
			x1 = b2.divide(m2);
			b1 = x1.multiply(a.getSlope()).add(a.getYIntercept());
			Point c = new Point(x1, b1);
			return c;
		}
	}

	public boolean isHorizontal() {
		if (m == 0) {
			isHorizontal = true;
		} else {
			isHorizontal = false;
		}
		return isHorizontal;
	}

	public boolean isParallel(Line a) {
		return a.getSlope().equals(this.getSlope());
	}

	public boolean isPerpendicular(Line a) {
		return (Math.abs(this.m - (-1/a.getSlope2())) < .01);
	}

	public boolean isVertical() {

		return isVertical;
	}

	public String toString() {
		if(isHorizontal) {
			return "x=" + toRational(xIntercept);
		}
		else if (isVertical) {
			return "y= " + toRational(m);
		}
		return "y=" + toRational(m) + "x" + " + " + toRational(b);
	}

	public Rational toRational(double d) {

		int k;
		double j = d;

		Rational c = new Rational();
		k = c.deciToFrac(d);

		j = j * k;

		if (this.isVertical()) {
			c = new Rational(0, 1);
		} else {
			c = new Rational((int) Math.round(j), k);
		}
		c.reduce();
		return c;

	}

}
