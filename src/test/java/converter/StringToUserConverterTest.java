package converter;

import model.User;
import model.UserRole;
import model.UserStatus;
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
        stringToUserConverter.convert(" ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertNullString() {
        stringToUserConverter.convert(null);
    }

    @Test
    public void testConvertStringWithDash() {
        User expected = new User(
                "vany-kaka",
                "dimon-maradona",
                "Van-Clock-Dimon",
                "rbIba-gold",
                UserRole.ADMIN,
                UserStatus.ACTIVE,
                "email",
                1);

        User actual = stringToUserConverter.convert("vany-kaka=dimon-maradona=Van-Clock-Dimon=rbIba-gold=admin=active=email=1");

        assertNotNull(actual);
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getSurname(), actual.getSurname());
        assertEquals(expected.getPassword(), actual.getPassword());
        assertEquals(expected.getUsername(), actual.getUsername());
    }

    @Test
    public void testConvertStringOfThreeWords() {
        User expected = new User(
                "serega three zero",
                "vany short boy",
                "Van Clock Vandam",
                "pushkin aleksandr lol",
                UserRole.ADMIN,
                UserStatus.BAN,
                "email",

                1);

        User actual = stringToUserConverter.convert(
                "serega three zero=vany short boy=Van Clock Vandam=pushkin aleksandr lol=admin=ban=email=1"
        );

        assertNotNull(actual);
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getSurname(), actual.getSurname());
        assertEquals(expected.getPassword(), actual.getPassword());
        assertEquals(expected.getUsername(), actual.getUsername());
    }

    public void testConvert() {
        User expected = new User(
                "Oss",
                "oss_password",
                "igor",
                "osipov",
                UserRole.ADMIN,
                UserStatus.ACTIVE,
                "email", 1);

        User actual = stringToUserConverter.convert("Oss=oss_password=igor=osipov=admin=active=email=1");

        assertNotNull(actual);
        assertEquals(expected.getUsername(), actual.getUsername());
        assertEquals(expected.getPassword(), actual.getPassword());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getSurname(), actual.getSurname());
        assertEquals(expected.getRole(), actual.getRole());
        assertEquals(expected.getStatus(), actual.getStatus());
    }
}
