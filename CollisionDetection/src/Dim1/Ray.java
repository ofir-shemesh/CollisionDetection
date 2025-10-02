package Dim1;

public class Ray {
	float point;
	boolean right;
	
	public Ray(float point, boolean right) {
		this.point = point;
		this.right = right;
	}
	
	public float getPoint() {
		return this.point;
	}
	
	public boolean isRight() {
		return this.right;
	}
	
	public boolean isLeft() {
		return !this.right;
	}
}
