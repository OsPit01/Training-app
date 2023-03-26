package converter;

import model.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StringToUserConverterTest {
    final StringToUserConverter stringToUserConverter = new StringToUserConverter();

    @Test(expected = IllegalArgumentException.class)
    public void testConvertEmptyString() {
        stringToUserConverter.convert(" ");
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
    public void testConvertNameWithUnderSlash() {
        User expected = stringToUserConverter.convert("Van_Clock_Dimon=dimon=vany=rbIba");

        String actual = "Van_Clock_Dimon";


        assertNotNull(actual);
        assertEquals("can be:Van_Clock_Dimon", expected.getUsername(), actual);
    }

    @Test
    public void testConvertNameOfThreeWords() {
        User expected = stringToUserConverter.convert("serega=vany_password=Van Clock Vandam=pushkin");

        String actual = "Van Clock Vandam";

        assertNotNull(actual);
        assertEquals("can be: Van Clock Vandam", expected.getName(), actual);
    }

    @Test
    public void testConvertSurnameOfThreeWords() {
        User expected = stringToUserConverter.convert("serega three zero=vany clock password=colbasa=Van Clock Vandam");

        String actual = "Van Clock Vandam";

        assertNotNull(actual);
        assertEquals("can be: Van Clock Vandam", expected.getSurname(), actual);
    }

    @Test
    public void testConvertPasswordOfThreeWords() {
        User expected = stringToUserConverter.convert("serega=vany clock password=Van Clock Vandam=pushkin");

        String actual = "vany clock password";

        assertNotNull(actual);
        assertEquals("can be:vany clock password", expected.getPassword(), actual);
    }

    @Test
    public void testConvertUsernameOfThreeWords() {
        User expected = stringToUserConverter.convert("serega three zero=vany clock password=colbasa=Van Clock Vandam");

        String actual = "serega three zero";

        assertNotNull(actual);
        assertEquals("can be: serega three zero", expected.getUsername(), actual);
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
