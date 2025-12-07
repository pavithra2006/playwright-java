import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowDOM {
    public static void main(String[] args) {
        try(Playwright pw = Playwright.create()){
            Page pg = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newPage();

            pg.navigate("https://selectorshub.com/xpath-practice-page/");
            //page --> DOM --> elements
            //page --> DOM --> shadow DOM --> elements
            //page --> DOM --> iframe --> shadow DOM --> elements


            pg.fill("#pizza", "test");

            pg.pause();

        }
    }
}
