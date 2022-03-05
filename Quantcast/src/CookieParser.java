import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.*;

public class CookieParser {
    private Pattern _cookiePattern;

    public CookieParser() {
        _cookiePattern = Pattern.compile("^(.+?),(.+?)T"); //setting the regex pattern to separate the first cookie and the date
    }

    public void parse(String filename, CookieLog cookieLog) {
        try {
            File file = new File(filename); //getting the file and using scanner to traverse through the file
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Matcher cookieMatcher = _cookiePattern.matcher(line); //Matcher is matching the cookie regex parameters we set
                if (cookieMatcher.find()) { //when it finds a corresponding match they will get be put into cookieLog
                    String cookie = cookieMatcher.group(1);
                    String date = cookieMatcher.group(2);

                    cookieLog.addCookie(date, cookie);
                }

            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("No such file.");
        }
    }
}
