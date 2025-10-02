package Dim1;

public class Dim1Tester {
	public static void test() {
		boolean allPassed = true;

		Line l1 = new Line(0f, 5f);
        Line l2 = new Line(3f, 7f);   // overlap
        Line l3 = new Line(6f, 8f);   // no overlap
        Line l4 = new Line(2f, 4f);   // inside l1
        Line l5 = new Line(5f, 10f); 

        // expected: l1 & l2 intersect
        allPassed &= Collision1DHandler.isColliding(l1, l2) == true;

        // expected: l1 & l3 do NOT intersect
        allPassed &= Collision1DHandler.isColliding(l1, l3) == false;

        // expected: l1 & l4 intersect (overlap)
        allPassed &= Collision1DHandler.isColliding(l1, l4) == true;

        // expected: l1 & l5 do NOT intersect
        allPassed &= Collision1DHandler.isColliding(l1, l5) == false;

        System.out.println(allPassed);
	}
}
