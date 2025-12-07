import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Frames {
    public static void main(String[] args) {
        try (Playwright pw = Playwright.create()) {
            Page pg = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newPage();
            pg.navigate("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");


            pg.frameLocator("//iframe[@name='__uspapiLocator']").locator(".details__form-image").click();

//            FrameLocator is an interface
//            Framelocator with css
//            FrameLocator frameLocator = pg.frameLocator("frame[name='main']");
//            String content = frameLocator.locator("h2").textContent();
//            System.out.println(content);
//            FrameLocator with xpath
//            System.out.println(pg.frameLocator("//frame[@name='main']").locator("h2").textContent());
//            Get frame by framename
//            System.out.println(pg.frame("main").locator("h2").textContent());
        }
    }
}
