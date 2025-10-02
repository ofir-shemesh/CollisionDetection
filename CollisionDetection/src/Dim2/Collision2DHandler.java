package Dim2;

import org.joml.Vector2f;

import Dim1.Collision1DHandler;
import Dim1.Line;

public class Collision2DHandler {
	public static boolean isColliding(Rectangle a, Rectangle b) {
		Vector2f[] normals = {
				a.getRightAxis(),
				a.getUpAxis(),
				b.getRightAxis(),
				b.getUpAxis()
		};
		
		boolean ret = true;
		
		//TODO: verify the boolean logic in this shit
		for (Vector2f normal : normals) {
			Line lineA = a.getProjection(normal);
			Line lineB = b.getProjection(normal);
			ret &= Collision1DHandler.isColliding(lineA, lineB);
		}
		
		return ret;
	}
}
