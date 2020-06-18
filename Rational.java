package pointAndLineClass;

public class Rational {
	private int p, q;
	private boolean defined;
	
	/* Rish Pednekar
	 * Period 4: AP Computer Science
	 */

	public Rational() {
		p = 1;
		q = 1;
	}

	public Rational(int n, int d) {
		p = n;
		if (d == 0) {
			defined = false;
		} else {
			defined = true;
			q = d;
		}
	}
	public Rational(double r) {
		defined = true;
		deciToFrac(r);
		reduce();
	}

	public int getP() {
		return p;
	}

	public int getQ() {
		return q;
	}

	public int setP(int newP) {
		p = newP;
		return p;
	}

	public int setQ(int newQ) {
		q = newQ;
		return q;
	}

	// check for defined

	public Rational add(Rational r) {
		int numerator = this.getP() * r.getQ() + r.getP() * this.getQ();
		int denominator = this.getQ() * r.getQ();

		p = numerator;
		q = denominator;

		reduce();

		Rational c = new Rational(p, q);
		return c;
	}

	public Rational subtract(Rational r) {
		int numerator = this.getP() * r.getQ() - r.getP() * this.getQ();
		int denominator = this.getQ() * r.getQ();

		p = numerator;
		q = denominator;

		reduce();

		Rational c = new Rational(p, q);
		return c;
	}

	public Rational multiply(Rational r) {
		int numerator = this.getP() * r.getP();
		int denominator = this.getQ() * r.getQ();

		p = numerator;
		q = denominator;

		reduce();

		Rational c = new Rational(p, q);
		return c;
	}

	public Rational divide(Rational r) {
		int numerator = this.getP() * r.getQ();
		int denominator = r.getP() * this.getQ();

		p = numerator;
		q = denominator;

		reduce();

		Rational c = new Rational(p, q);

		return c;
	}

	public void reduce() {

		int gcf = gcf(p, q);

		p = (p / gcf);
		q = (q / gcf);

	}

	public int gcf(int n, int d) {
		for (int i = (int) Math.abs(Math.min(n, d)); i > 0; i--) {
			if (n % i == 0 && d % i == 0) {
				return i;
			}
		}
		return 1;
	}

	public boolean equals(Rational r) {
		if (this.getP() == r.getP() && this.getQ() == r.getQ()) {
			return true;
		} else if (Math.abs(this.decimalValue() - r.decimalValue()) < .000001) {
			return true;
		}

		else {
			return false;
		}

	}

	public double decimalValue() {
		double p2;
		if (q == 0) {
			return 0;
		}
		p2 = p;

		return p2 / q;

	}

	public boolean isDefined() {
		if (q == 0) {
			defined = false;
		}
		return defined;
	}

	public String toString() {
		return p + "/" + q;
	}

	public int deciToFrac(double num) {
		defined = true;
		int j = 1;
		do {
			j = j * 10;
			if (j > 10000) {
				break;
			}
		} while ((num * j) % 10 != 0);
		j = j / 10;
		return j;
	}

}
