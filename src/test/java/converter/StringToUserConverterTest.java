package converter;

import model.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StringToUserConverterTest {
    final StringToUserConverter stringToUserConverter = new StringToUserConverter();

    @Test(expected = IllegalArgumentException.class)
    public void testConvertForEmptyString() {
        stringToUserConverter.convert(" ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertForEmptyLines() {
        String actual = "" + "" + "" + "";
        stringToUserConverter.convert(actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertForNullString() {
        stringToUserConverter.convert(null);
    }

    @Test
    public void testConvertNameWithDash() {
        String expected = "Jana-dark";
        User actual = stringToUserConverter.convert("Jana-dark=janka_password=Vany=Vasilevna");

        assertNotNull(actual);
        assertEquals("can be: Jana-dark", expected, actual.getUsername());
    }

    @Test
    public void testConvertNameWithUnderSlash() {
        String expected = "Van_Clock_Dimon";
        User actual = stringToUserConverter.convert("Van_Clock_Dimon=dimon=vany=rbIba");

        assertNotNull(actual);
        assertEquals("can be:Van_Clock_Dimon", expected, actual.getUsername());
    }

    @Test
    public void testConvertNameOfThreeWords() {
        String expected = "Van Clock Vandam";
        User actual = stringToUserConverter.convert("serega=vany_password=Van Clock Vandam=pushkin");

        assertNotNull(actual);
        assertEquals("can be: Van Clock Vandam", expected, actual.getName());
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


