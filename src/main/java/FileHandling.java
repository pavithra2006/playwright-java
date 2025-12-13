import com.microsoft.playwright.*;

import java.awt.*;

public class FileHandling {
    public static void main(String[] args) {
        try (Playwright pw = Playwright.create()) {

            Browser bw = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext bc = bw.newContext(new Browser.NewContextOptions().setViewportSize(850, 1500));
            Page pg = bc.newPage();
            pg.navigate("https://www.netflix.com/in/");

            pg.fill("input[name='email'] >> nth=0", "abc");
            pg.click("text=Get Started >> nth=0");
            pg.pause();
        }
    }
}
