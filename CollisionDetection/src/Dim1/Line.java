package Dim1;

public class Line {
	private float start, finish;
	
	public Line(float start, float finish) {
		this.start = start;
		this.finish = finish;
	}
	
	public float getStart() {
		return this.start;
	}
	
	public float getFinish() {
		return this.finish;
	}
	
	public Ray rightRay() {
		return new Ray(this.start, true);
	}
	
	public Ray leftRay() {
		return new Ray(this.finish, false);
	}
}
