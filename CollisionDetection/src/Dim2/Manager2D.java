package Dim2;

import org.joml.Vector2f;

public class Manager2D {	
	public static float getAngle(Vector2f a, Vector2f b) {
		float cross = a.x * b.y - a.y * b.x;
        float dot   = a.dot(b);

        return (float)Math.atan2(cross, dot);
	}
}
