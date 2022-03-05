import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


class CookieTester {

    @Test
    void TestCookieDateNotListed() throws NullPointerException{ //should return pass because no activity is listed on this date
        CookieLog cookieLog = new CookieLog();
        cookieLog.addCookie("2018-12-09","AtY0laUfhglK3lC7");
        assertNull(cookieLog.mostActiveCookie("2018-13-09"));

    }
    @Test
    void TestCookieSingleCookie() { //should return pass
        CookieLog cookieLog = new CookieLog();
        cookieLog.addCookie("2018-12-09","AtY0laUfhglK3lC7");
        assertEquals("AtY0laUfhglK3lC7" ,cookieLog.mostActiveCookie("2018-12-09")[0]);

    }

    @Test
    void TestCookieMultipleCookiesSameDate() //Should return pass
    {
        CookieLog cookieLog = new CookieLog();
        cookieLog.addCookie("2018-12-09","AtY0laUfhglK3lC7");
        cookieLog.addCookie("2018-12-09","SAZuXPGUrfbcn5UA");
        cookieLog.addCookie("2018-12-09","5UAVanZf6UtGyKVS");
        assertEquals("AtY0laUfhglK3lC7" ,cookieLog.mostActiveCookie("2018-12-09")[0]);
        assertEquals("SAZuXPGUrfbcn5UA" ,cookieLog.mostActiveCookie("2018-12-09")[1]);
        assertEquals("5UAVanZf6UtGyKVS" ,cookieLog.mostActiveCookie("2018-12-09")[2]);

    }
}
