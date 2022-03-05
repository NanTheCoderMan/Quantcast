import java.util.HashMap;
import java.util.Map.Entry;
public class CookieLog {

    //every date is associated with a map which maps a cookie to its occurence count
    HashMap<String, HashMap<String, Integer>> _cookieLog;

    public CookieLog() {
        _cookieLog = new HashMap<>();
    }

    public void addCookie(String date, String cookie) { //adds the cookies to the cookie log hash map
        if (!_cookieLog.containsKey(date)) {
            _cookieLog.put(date, new HashMap<>());
        }

        _cookieLog.get(date).merge(cookie, 1, Integer::sum);
    }


    public String[] mostActiveCookie(String date) { //returns string array of the cookies from the date given
        if (!_cookieLog.containsKey(date)) {
            System.out.println("No activity on this date.");
            return null;
        }

        var cookieSet = _cookieLog.get(date).entrySet();
        int moveActiveCount = cookieSet.stream().max((c1, c2) -> c1.getValue() - c2.getValue()).get().getValue();

        return cookieSet.stream().filter(c -> c.getValue() == moveActiveCount).map(Entry::getKey).toArray(String[]::new);
    }
}
