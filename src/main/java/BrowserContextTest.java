import com.microsoft.playwright.*;

public class BrowserContextTest {
    public static void main(String[] args) {
        try (Playwright pw = Playwright.create()) {
            Browser br = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext bc1 = br.newContext();
            Page p1 = bc1.newPage();
            p1.navigate("https://www.orangehrm.com/30-day-free-trial/");
            //fill--> css id , data to be sent in ui
            p1.fill("#Form_getForm_subdomain", "user1");
            // bc1.close();

            BrowserContext bc2 = br.newContext();
            Page p2 = bc2.newPage();
            p2.navigate("http://automationpractice.com/index.php");

        }
    }
}
