package Dim1;

public class Collision1DHandler {
	
	public static boolean isColliding(Line a, Ray b) {
		if (b.isRight()) {
			return b.point < a.getFinish();
		}else {
			return b.point > a.getStart();
		}
	}
	
	public static boolean isColliding(Line a, Line b) {
		return isColliding(a, b.rightRay()) && isColliding(a, b.leftRay());
	}
}
