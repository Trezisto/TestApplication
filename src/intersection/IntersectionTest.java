package intersection;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by eprijilevschi on 5/29/2017.
 */
public class IntersectionTest {
    private Intersection intersection = new Intersection();

    @Test
    public void testEmptyString(){
        String inputString = "";
        String expected = "Пересечения нет";
        String actual = intersection.findAll(inputString);
        Assert.assertEquals("The string is empty!", expected, actual);
    }

    @Test
    public void testTwoIntersections(){
        String inputString = "НачПериода1,НачПериода2,КонПериода1, КонПериода2";
        String expected = "НачПериода2, КонПериода1";
        String actual = intersection.findAll(inputString);
        Assert.assertEquals("There are 2 intersections", expected, actual);
    }

    @Test
    public void testNoIntersections(){
        String inputString = "НачПериода1,КонПериода1,НачПериода2, КонПериода2";
        String expected = "Пересечения нет";
        String actual = intersection.findAll(inputString);
        Assert.assertEquals("There are no intersections", expected, actual);
    }

    @Test
    public void testMinusInfinity(){
        String inputString = " НачПериода4,КонПериода3,КонПериода4";
        String expected = "-бесконечность";
        String actual = intersection.findAll(inputString);
        Assert.assertEquals("There is -infinity", expected, actual);
    }

    @Test
    public void testPlusInfinity(){
        String inputString = "НачПериода5,  КонПериода5,НачПериода6";
        String expected = "+бесконечность";
        String actual = intersection.findAll(inputString);
        Assert.assertEquals("There is +infinity", expected, actual);
    }

    @Test
    public void testNestedPeriods(){
        String inputString = "НачПериода1,НачПериода2,КонПериода2, КонПериода1";
        String expected = "НачПериода2, КонПериода2";
        String actual = intersection.findAll(inputString);
        Assert.assertEquals("There are 2 intersections", expected, actual);
    }

    @Test
    public void testMultiplePeriods(){
        String inputString = "НачПериода1,КонПериода1, НачПериода2,НачПериода3,НачПериода4,КонПериода3,КонПериода4, КонПериода2";
        String expected = "НачПериода3, НачПериода4, КонПериода3, КонПериода4";
        String actual = intersection.findAll(inputString);
        Assert.assertEquals("There are 4 intersections", expected, actual);
    }
}
