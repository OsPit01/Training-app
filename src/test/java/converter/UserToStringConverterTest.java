package converter;

import model.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserToStringConverterTest {

    private final UserToStringConverter userToStringConverter = new UserToStringConverter();

    @Test(expected = IllegalArgumentException.class)
    public void testConvertNull() {
        userToStringConverter.convert(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertFieldsNull() {
        User user = new User(null, null, null, null,null);

        userToStringConverter.convert(user);
    }

    @Test
    public void testConvert() {
        String expected = "igor=igor_password=ihar=osipov=admin";
        User user = new User("igor", "igor_password", "ihar", "osipov","admin");

        String actual = userToStringConverter.convert(user);

        assertNotNull(actual);
        assertEquals(expected, actual);
    }
}
