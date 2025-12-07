import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.util.List;

public class VisibleText {
    public static void main(String[] args) {
        try (Playwright pw = Playwright.create()) {
            Page pg = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newPage();

            pg.navigate("https://www.amazon.com/");
            Locator visibleLink = pg.locator("a:visible");
            System.out.print(visibleLink.count());
            List<String> stringLink = visibleLink.allTextContents();
//           stringLink.forEach(elm -> System.out.println(elm));

            System.out.println("*************");

            Locator allLink = pg.locator("a");
            System.out.println(allLink.count());
            List<String> allLinks = allLink.allTextContents();

            System.out.println(  pg.locator("xpath=//img >> visible=true").count());
            System.out.println(  pg.locator("xpath=//img").count());
pg.pause();
//            text=Login >> visible=true
        }
    }
}
