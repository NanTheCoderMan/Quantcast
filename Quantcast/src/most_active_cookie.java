public class most_active_cookie {
    public static void main(String[] args) {

        if (args.length != 3) { //checks number of arguments entered
            System.out.println("Wrong number of arguments");
            return;
        }

        String filename = args[0];//assigns file name from first argument
        String date = args[2];//assigns date to search from the last argument

        CookieParser cookieParser = new CookieParser();//create objects for both cookielog and cookieparser
        CookieLog cookieLog = new CookieLog();

        cookieParser.parse(filename, cookieLog); //Parse the given file

        for (String cookie : cookieLog.mostActiveCookie(date)) //Print out result of the date searched
        {
            System.out.println(cookie);
        }

    }
}
