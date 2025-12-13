import com.microsoft.playwright.*;

import java.awt.*;

public class Alerts {

    public static void main(String[] args) {
        try (Playwright pw = Playwright.create()) {

            //delay each action by 2000ms --> each action is 2sec slow
            Browser bw = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
            BrowserContext bc = bw.newContext(new Browser.NewContextOptions().setViewportSize(850, 1500));
            Page pg = bc.newPage();
            pg.navigate("https://the-internet.hackerearth.com/javascript_alerts");
            //listener will be applicable only for this page
            pg.onDialog(dialog -> { //lamda
                System.out.println(dialog.message()); // displays content in js popups
//               dialog.accept();  or dialog.dismiss(); --> either we can accept / accept with text / dismiss
                dialog.accept("ABC");

            });
            //if there are  no listener
            pg.click("text=Click for JS Alert"); // automatically clicks ok
            pg.click("text=Click for JS Confirm"); // automatically clicks cancel
            pg.click("text=Click for JS Prompt"); // automatically clicks cancel
        }
    }

}
