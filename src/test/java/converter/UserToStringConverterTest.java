package converter;

import model.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class UserToStringConverterTest {

    final UserToStringConverter userToStringConverter = new UserToStringConverter();

    /*  @Test
  public void createdUser() {
User user = new User("igor","igor_password","ihar","osipov");
User newUser = Mockito.mock(User.class);
assertEquals("ihar",newUser.getSurname());
   }
*/
    @Test
    public void testConvert() {
        User user = new User("igor", "igor_password", "ihar", "osipov");
        String actual = userToStringConverter.convert(user);
        assertNotNull(actual);
        String expected = "igor=igor_password=ihar=osipov";
        assertEquals(expected, actual);
    }
}