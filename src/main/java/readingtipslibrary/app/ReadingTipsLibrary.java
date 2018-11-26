package readingtipslibrary.app;

import java.util.Scanner;

public class ReadingTipsLibrary {
    
    public static void main(String[] args) throws Exception {  
        ReadingTipsApplication application = new ReadingTipsApplication();
        application.init(new Scanner(System.in));
        application.run();
    }

}
