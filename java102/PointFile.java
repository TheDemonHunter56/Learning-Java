package java102;

public class PointFile{
	static public class Point {
		public final double x;
		public final double y;
		
		public static double lawOfCosineAngle(double a, double b, double c){
			double result = Math.acos((Math.pow(a, 2)+Math.pow(b, 2)-Math.pow(c, 2))/2*a*b);
			return result;
		}

		/**
		 * @param x coord
		 * @param y coord
		 */
		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		public Point translateX(double t) {
			return new Point(x + t, y);
		}
		
		public Point translateY(double t) {
			return new Point(x, y + t);
		}
		
		@Override
		public String toString() {
			return "(" + x + ", " + y + ")";
		}

		public static double distance(Point p1, Point p2) {
			return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
		}

		public static Point centerOfMass(Point[] points){
			double xCoord = 0;
			double xSum = 0;
			double yCoord = 0;
			double ySum = 0;
			double counter = 0;
			for (int i = 0; i < points.length; i ++){
				xSum += points[0 + i].x;
				ySum += points[0 + i].y;
				counter += 1;
			}
			yCoord = ySum / counter;
			xCoord = xSum/ counter;
			Point centOfMass = new Point(xCoord, yCoord);
			return centOfMass;
		}
		
		public double angle(){
			double sideAlpha = x;
			double sideGamma = y;
			double hypotenuse = (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
			double result = lawOfCosineAngle(hypotenuse, sideAlpha, sideGamma);
			return result;
		}

		public Point Rotation(double theta){
			double radian = theta * Math.PI / 180;
			double xPrime = x * Math.cos(radian) - y * Math.sin(radian);
			double yPrime = x * Math.sin(radian) + y * Math.cos(radian);
			return new Point(xPrime, yPrime);
		}
	}
}

