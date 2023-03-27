package converter;

import model.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StringToUserConverterTest {
    private final StringToUserConverter stringToUserConverter = new StringToUserConverter();

    @Test(expected = IllegalArgumentException.class)
    public void testConvertEmptyString() {
        stringToUserConverter.convert("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertEmptyFields() {
        String actual = "" + " " + "" + " " + "" + "";

        stringToUserConverter.convert(actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertNullString() {
        stringToUserConverter.convert(null);
    }

    @Test
    public void testConvertNameWithDash() {
        String expected = "Van-Clock-Dimon";

        User actual = stringToUserConverter.convert("vany=dimon=Van-Clock-Dimon=rbIba");

        assertNotNull(actual);
        assertEquals("can be:Van-Clock-Dimon", expected, actual.getName());
    }

    @Test
    public void testConvertSurnameWithDash() {
        String expected = "rbIba-gold";

        User actual = stringToUserConverter.convert("vany-kaka=dimon-maradona=Van-Clock-Dimon=rbIba-gold");

        assertNotNull(actual);
        assertEquals("can be:rbIba-gold", expected, actual.getSurname());
    }

    @Test
    public void testConvertPasswordWithDash() {
        String expected = "dimon-maradona";

        User actual = stringToUserConverter.convert("vany-kaka=dimon-maradona=Van-Clock-Dimon=rbIba-gold");

        assertNotNull(actual);
        assertEquals("can be:dimom-maradona", expected, actual.getPassword());
    }

    @Test
    public void testConvertUsernameWithDash() {
        String expected = "vany-kaka";

        User actual = stringToUserConverter.convert("vany-kaka=dimon-maradona=Van-Clock-Dimon=rbIba-gold");

        assertNotNull(actual);
        assertEquals("can be:vany-kaka", expected, actual.getUsername());
    }

    @Test
    public void testConvertNameOfThreeWords() {
        String expected = "Van Clock Vandam";

        User actual = stringToUserConverter.convert("serega=vany_password=Van Clock Vandam=pushkin");

        assertNotNull(actual);
        assertEquals("can be: Van Clock Vandam",expected,actual.getName());
    }


    @Test
    public void testConvertSurnameOfThreeWords() {
        String expected = "Van Clock Vandam";

        User actual = stringToUserConverter.convert("serega three zero=van clock password=colbasa=Van Clock Vandam");

        assertNotNull(actual);
        assertEquals("can be: Van Clock Vandam",expected,actual.getSurname());
    }

    @Test
    public void testConvertPasswordOfThreeWords() {
        String expected = "vany clock password";

        User actual = stringToUserConverter.convert("serega=vany clock password=Van Clock Vandam=pushkin");

        assertNotNull(actual);
        assertEquals("can be:vany clock password",expected,actual.getPassword());
    }

    @Test
    public void testConvertUsernameOfThreeWords() {
        String expected = "serega three zero";

        User actual = stringToUserConverter.convert("serega three zero=vany clock password=colbasa=Van Clock Vandam");

        assertNotNull(actual);
        assertEquals("can be: serega three zero",expected,actual.getUsername());
    }

    @Test
    public void testConvert() {
        User expected = new User("Oss", "oss_password", "igor", "osipov");

        User actual = stringToUserConverter.convert("Oss=oss_password=igor=osipov");

        assertNotNull(actual);
        assertEquals("can be userName: Oss", expected.getUsername(), actual.getUsername());
        assertEquals("can be password: oss_password", expected.getPassword(), actual.getPassword());
        assertEquals("can be name: igor", expected.getName(), actual.getName());
        assertEquals("can be name: osipov", expected.getSurname(), actual.getSurname());
    }
}
