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

    @Test
    public void testConvert() {
        String expected = "igor=igor_password=ihar=osipov";
        User user = new User("igor", "igor_password", "ihar", "osipov");

        String actual = userToStringConverter.convert(user);

        assertNotNull(actual);
        assertEquals(expected, actual);
    }
}
