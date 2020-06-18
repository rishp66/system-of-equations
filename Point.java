package pointAndLineClass;



public class Point {
	private double x;
	private double y;

	public Point() {
		x = 0;
		y = 0;
	}

	public Point(double a, double b) {
		x = a;
		y = b;
	}

	public Point(Rational a, Rational b){
		x = a.decimalValue();
		y = b.decimalValue();
	}
	
	public double slope(Point A) {
		double db = (A.getY() - this.getY()) /(A.getX() - this.getX());
		return db;
	}
	
	public Point midPoint(Point N) {
		double p,q;
		p=(this.getX()+N.getX())/2.0;
		q=(this.getY()+N.getY())/2.0;
		return new Point(p,q);

	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void changeX(double xVel) {
		x += xVel;
	}

	public void changeY(double yVel) {
		y += yVel;
	}

	public double distanceTo(Point P) {
		double diffxSq = Math.pow(P.getX() - x, 2);
		double diffySq = Math.pow((P.getY() - this.getY()), 2);
		double dist = Math.sqrt(diffxSq + diffySq);
		return dist;
	}

	public boolean equals(Point P) {
		return (Math.abs((P.getX() - x)) < 0.001) && (Math.abs(P.getY() - this.getY()) < 0.001);
	}

	// returns answer
	public String toString() {
		return ("(" + x + ", " + y + ")");
	}

}
