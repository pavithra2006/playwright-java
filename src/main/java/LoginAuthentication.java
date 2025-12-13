import com.microsoft.playwright.*;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

public class LoginAuthentication {
    public static void main(String[] args) {
        try (Playwright pw = Playwright.create()) {
            Browser bw = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext bc = bw.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("appLogin2.json")));
            Page pg = bc.newPage();
            pg.navigate("https://practicetestautomation.com/practice-test-login/");

            Locator successLogin = pg.locator("h1:has-text('Logged In Successfully')");
            assertThat(successLogin).isVisible();
            System.out.println("done");


//            BrowserContext bc = bw.newContext(new Browser.NewContextOptions().setViewportSize(800, 1500));
//            Page pg = bc.newPage();
//            pg.navigate("https://practicetestautomation.com/practice-test-login/");
//
//            pg.fill("#username", "student");
//            pg.fill("#password", "Password123");
//            pg.click("text=Submit");
//
//
//
//            Locator successLogin = pg.locator("h1:has-text('Logged In Successfully')");
//            successLogin.waitFor();
//            assertThat(successLogin).isVisible();
//            bc.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("appLogin2.json")));
//            System.out.println("done");

        }

    }
}
