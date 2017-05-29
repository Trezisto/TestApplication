package brackets;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by eprijilevschi on 5/29/2017.
 */
public class BracketsTest {
    private Brackets brackets = new Brackets();

    private static final String VALID = "[({})]";
    private static final String INVALID = "[([)";

    @Test
    public void bracketTestIsNull(){
        boolean expected = false;
        boolean actual = brackets.verify(null);
        assertEquals("String is null", expected, actual);
    }

    @Test
    public void bracketTestIsEmpty(){
        boolean expected = true;
        boolean actual = brackets.verify("");
        assertEquals("String is empty", expected, actual);
    }

    @Test
    public void bracketTestIsValid(){
        boolean expected = true;
        boolean actual = brackets.verify(VALID);
        assertEquals("String is valid", expected, actual);
    }

    @Test
    public void bracketTestIsInValid(){
        boolean expected = false;
        boolean actual = brackets.verify(INVALID);
        assertEquals("String is invalid", expected, actual);
    }

    @Test
    public void bracketTestIsNested(){
        boolean expected = true;
        boolean actual = brackets.verify("bar{[(abc)]foo[def]}");
        assertEquals("String is valid", expected, actual);
    }

    @Test
    public void bracketTestIsFalse(){
        boolean expected = false;
        boolean actual = brackets.verify("}[]{");
        assertEquals("String is invalid", expected, actual);
    }
}