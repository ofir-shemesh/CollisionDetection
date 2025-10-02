package Dim2;

import org.joml.*;
import org.joml.Math;

import Dim1.Line;

public class Rectangle {
	public float width, height, angle;
	public Vector2f center;
	
	public Rectangle(Vector2f center, float width, float height) {
		this(center, width, height, 0.0f);
	}
	
	public Rectangle(Vector2f center, float width, float height, float angle) {
		this.width = width;
		this.height = height;
		this.angle = angle;
		this.center = new Vector2f(center);
	}
	
	public Vector2f getRightAxis() {
		float c = (float) Math.cos(angle);
		float s = (float) Math.cos(angle);
		return new Vector2f(c, s);
	}
	
	public Vector2f getLeftAxis() {
		return getRightAxis().negate();
	}
	
	public Vector2f getUpAxis() {
		Vector2f right = getRightAxis();
		return new Vector2f(-right.y,right.x);
	}
	
	public Vector2f getDownAxis() {
		return getUpAxis().negate();
	}
	
	
	
	public Vector2f getTopLeft() {
		Vector2f width_vec = getLeftAxis().mul(width/2);
		Vector2f height_vec = getUpAxis().mul(height/2);
		return new Vector2f(center).add(height_vec).add(width_vec);
		
	}
	
	public Vector2f getTopRight() {
		Vector2f width_vec = getRightAxis().mul(width/2);
		Vector2f height_vec = getUpAxis().mul(height/2);
		return new Vector2f(center).add(height_vec).add(width_vec);
		
	}
	
	public Vector2f getBottomRight() {
		Vector2f width_vec = getRightAxis().mul(width/2);
		Vector2f height_vec = getDownAxis().mul(height/2);
		return new Vector2f(center).add(height_vec).add(width_vec);
		
	}
	
	public Vector2f getBottomLeft() {
		Vector2f width_vec = getLeftAxis().mul(width/2);
		Vector2f height_vec = getDownAxis().mul(height/2);
		return new Vector2f(center).add(height_vec).add(width_vec);
	}
	
	public Vector2f[] getPoints() {
		return new Vector2f[]{
				this.getTopLeft(),
				this.getTopRight(),
				this.getBottomRight(),
				this.getBottomLeft()
		};
	}
	
	public Line getProjection(Vector2f direction) {
		float max = Float.MIN_VALUE;
		float min = Float.MAX_VALUE;
		
		Vector2f normalized_direction = new Vector2f(direction).normalize();
		
		for (Vector2f point : getPoints()) {
			float proj = point.dot(normalized_direction);
			min = Math.min(proj, min);
			max = Math.max(proj, max);
		}
		
		return new Line(min, max);
	}
}
