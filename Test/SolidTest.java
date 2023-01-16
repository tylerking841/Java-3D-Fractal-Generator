package Test;
import stl.Facet;
import stl.Solid;
import stl.Vertex;
import static org.junit.jupiter.api.Assertions.*;

class SolidTest {
    @org.junit.jupiter.api.Test
    void testInvalid() {
        Vertex one = new Vertex(0,0,0);
        Vertex two = new Vertex(0,1,0);
        Vertex three = new Vertex(0,0,1);
        Vertex four = new Vertex(1,0,0);
        Solid shape = new Solid();
        Solid empty = new Solid();
        boolean a = shape.addFacet(one);
        boolean b = shape.addFacet(one,two);
        boolean c = shape.addFacet(one,three);
        assertFalse(a);
        assertFalse(b);
        assertFalse(c);
        assertEquals(shape.toString(), empty.toString());
    }
    @org.junit.jupiter.api.Test
    void test3(){
        Vertex one = new Vertex(0,0,0);
        Vertex two = new Vertex(0,1,0);
        Vertex three = new Vertex(0,0,1);
        Vertex four = new Vertex(1,0,0);
        Facet b = new Facet(one,two,three);
        Solid hold = new Solid();
        hold.addFacet(b);
        Solid shape = new Solid();
        boolean out =shape.addFacet(one,two,three);
        assertTrue(out);
        assertEquals(hold.toString(),shape.toString());
    }

    @org.junit.jupiter.api.Test
    void test4(){
        Vertex one = new Vertex(0,0,0);
        Vertex two = new Vertex(0,1,0);
        Vertex three = new Vertex(0,0,1);
        Vertex four = new Vertex(1,0,0);
        Facet b = new Facet(one,two,three);
        Facet c = new Facet(one, three, four);
        Solid shapeA = new Solid();
        Solid shapeB = new Solid();
        boolean outA =shapeA.addFacet(one,two,three,four);
        boolean outB = shapeB.addFacet(b);
        boolean outC = shapeB.addFacet(c);
        assertEquals(shapeA.toString(),shapeB.toString());
        assertTrue(outA);
        assertTrue(outB);
        assertTrue(outC);
    }

    @org.junit.jupiter.api.Test
    void test9(){
        Vertex one = new Vertex(0,0,0);
        Vertex two = new Vertex(0,1,0);
        Vertex three = new Vertex(0,0,1);
        Vertex four = new Vertex(1,0,0);
        Facet b = new Facet(one,two,three);
        Facet c = new Facet(one, three, four);
        Facet d = new Facet(one, four, two);
        Facet e = new Facet(one, two, three);
        Facet f = new Facet(one, three, four);
        Facet g = new Facet(one, four, two);
        Facet h = new Facet(one, two, three);
        Solid shapeB = new Solid();
        Solid shapeA = new Solid();
        shapeA.addFacet(one,two,three,four,two,three,four,two,three);
        shapeB.addFacet(b);
        shapeB.addFacet(c);
        shapeB.addFacet(d);
        shapeB.addFacet(e);
        shapeB.addFacet(f);
        shapeB.addFacet(g);
        shapeB.addFacet(h);
        assertEquals(shapeA.toString(),shapeB.toString());
    }
}