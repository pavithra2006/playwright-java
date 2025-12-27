import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

import java.util.Arrays;

public class WindowHandling {
    public static void main(String[] args) {
        try (Playwright pw = Playwright.create()) {
            Browser bw = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext bc1 = bw.newContext(new Browser.NewContextOptions().setPermissions(Arrays.asList("camera","microphone", "notifications")));
//            BrowserContext bc2= bw.newContext();
//            Page pg1 = bc1.newPage();
//            Page pg2 = bc2.newPage();
//
//            //creates two browsers
//            pg1.navigate("http://google.com");
//            pg2.navigate("http://amazon.com");
//            Page pg = bc1.newPage();
//            pg.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//            Page pgPopup = pg.waitForPopup(() -> {
//                pg.click("a[href='https://www.youtube.com/c/OrangeHRMInc']");
//            });
//            System.out.println(pgPopup.title() + pgPopup.url()); // print popup page details
//            pgPopup.close();
//            System.out.println(pg.title()); // print parent page title
//            pg.close();

            Page pg = bc1.newPage();
            pg.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            pg.pause();
            Page popupPg = pg.waitForPopup(() -> {
                pg.click("a[target='_blank']"); // creates new blank window( will work in selenium as well)
            });
            pg.bringToFront();
            popupPg.waitForLoadState(); // waits for new window to completely load
            System.out.println(popupPg.url());
            popupPg.navigate("http://google.com");
            System.out.println(popupPg.url());

            popupPg.close();
            System.out.println(pg.url());
        }
    }
}
