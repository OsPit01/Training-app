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
    public void testConvertBlankString() {
        String actual = " ";

        stringToUserConverter.convert(actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertNullString() {
        stringToUserConverter.convert(null);
    }

    @Test
    public void testConvertUser() {
        User actual = null;
        User expected = null;

        assertEquals("can be User: null", expected, actual);
    }

    @Test
    public void testConvertWithDash() {
        User actual = stringToUserConverter.convert("vany-kaka=dimon-maradona=Van-Clock-Dimon=rbIba-gold");

        assertNotNull(actual);
        assertEquals("can be name:Van-Clock-Dimon", "Van-Clock-Dimon", actual.getName());
        assertEquals("can be surname: rbIba-gold", "rbIba-gold", actual.getSurname());
        assertEquals("can be password: dimon-maradona", "dimon-maradona", actual.getPassword());
        assertEquals("can be username: vany-kaka", "vany-kaka", actual.getUsername());
    }

    @Test
    public void testConvertUserOfThreeWords() {

        User actual = stringToUserConverter.convert("serega three zero=vany short boy=Van Clock Vandam=pushkin aleksandr lol");

        assertNotNull(actual);
        assertEquals("can be: Van Clock Vandam", "Van Clock Vandam", actual.getName());
        assertEquals("can be:pushkin aleksandr lol", "pushkin aleksandr lol", actual.getSurname());
        assertEquals("can be:vany short boy", "vany short boy", actual.getPassword());
        assertEquals("can be: serega three zero", "serega three zero", actual.getUsername());

    }

    @Test
    public void testConvert() {
        User actual = stringToUserConverter.convert("Oss=oss_password=igor=osipov");

        assertNotNull(actual);
        assertEquals("can be userName: Oss", "Oss", actual.getUsername());
        assertEquals("can be password: oss_password", "oss_password", actual.getPassword());
        assertEquals("can be name: igor", "igor", actual.getName());
        assertEquals("can be name: osipov", "osipov", actual.getSurname());
    }
}
