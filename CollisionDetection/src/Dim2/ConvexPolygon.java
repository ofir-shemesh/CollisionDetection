package Dim2;

import org.joml.Vector2f;

public class ConvexPolygon {
	private Vector2f[] points;
	
	public ConvexPolygon(Vector2f[] points) {
		if (isLegal(points)) {
			this.points = points;
		}
	}
	
	//TODO: verify
	private boolean isLegal(Vector2f[] points) {
		int length = points.length;
		
		if (length <= 2) {
			//TODO: too little
			return false;
		}
		
		
		float angle = Manager2D.getAngle(new Vector2f(points[1]).sub(points[0]), 
										 new Vector2f(points[2]).sub(points[1]));
		float sum = angle;
		
		for (int i = 0; i < length; i++) {
			float new_angle = Manager2D.getAngle(new Vector2f(points[i+2]).sub(points[i+1]), 
					 new Vector2f(points[(i+3) % length]).sub(points[i+2]));
			
			sum += new_angle;
			
			if (Math.abs(sum) > (float) Math.PI * 2) {
				return false;
			}else if (angle * new_angle < 0) {
				return false;
			}
			
			angle = new_angle;
		}
		
		return true;
	}
}
