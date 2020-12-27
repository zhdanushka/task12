import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class Tests {

    void testDecimal(){ assertEquals(Integer.valueOf(50), Integer.decode("50"));}

    void testSignedDecimal() { assertEquals(Integer.valueOf(-50), Integer.decode("-50"));}

    void testFormatExceptionOnEmptyString() { assertThrows(NumberFormatException.class, () -> Integer.decode(""));}

    void testFormatExceptionOnWrongSignCharPosition() {
        assertThrows(NumberFormatException.class, () -> Integer.decode("1-234"));
    }

    void testOctalNumber() { assertEquals(Integer.valueOf(81), Integer.decode("0121")); }

    void testSignedOctalNumber() { assertEquals(Integer.valueOf(-81), Integer.decode("-0121"));}

    void testHexadecimalNumber() { assertEquals(Integer.valueOf(276), Integer.decode("0x114")); }

    void testSignedHexadecimalNumber() { assertEquals(Integer.valueOf(-276), Integer.decode("-0x114")); }

    void testHexadecimalNumberDifferentSymbol() { assertEquals(Integer.valueOf(1024), Integer.decode("#400"));}

    void testFormatExceptionOnWrongInput() { assertThrows(NumberFormatException.class, () -> Integer.decode("ABCD"));}

    void testWrongOctalNumber() { assertThrows(NumberFormatException.class, () -> Integer.decode("09121"));}

    void testWrongHexadecimalNumber() {assertThrows(NumberFormatException.class, () -> Integer.decode("x0114"));}

    void testNumbersWithPositiveSign(){
        assertAll(
                () -> assertEquals(Integer.valueOf(50), Integer.decode("+50")),
                () -> assertEquals(Integer.valueOf(276), Integer.decode("+0x114")),
                () -> assertEquals(Integer.valueOf(1024), Integer.decode("+#400")),
                () -> assertEquals(Integer.valueOf(81), Integer.decode("+0121"))
        );
    }
    void testIntegerOverflow() {
        assertAll(
                () -> assertThrows(NumberFormatException.class, () -> Integer.decode("21474836478")),
                () -> assertThrows(NumberFormatException.class, () -> Integer.decode("-21474836478"))
        );
    }
}