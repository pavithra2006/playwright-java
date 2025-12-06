import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class traceview {
    public static void main(String[] args) {
        try (Playwright pw = Playwright.create()) {
            Browser br = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext bc = br.newContext();
            // Start tracing before creating / navigating a page.
            //Tracing -->interface, StartOptions --> class
            //network calls will also be logged
            bc.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true) // if true takes screenshot of each step, and shows a film
                    .setSnapshots(true) // takes snaps before, during action and after action
                    .setSources(true));
            Page pg = bc.newPage();

            pg.navigate("https://academy.naveenautomationlabs.com/");
            System.out.println(pg.title());
            assertThat(pg).hasTitle("NaveenAutomationLabs");
            assertThat(pg).hasURL("https://academy.naveenautomationlabs.com/");
            //getByRole pierces through shadow dom, nested dom, iframes, elemts b=hidden behind react, etc
            //playwright recommended locator --> role, testid, text, label
            // sees login link via accessibility tree
            //playwright waits for element, but if element is created later then tests would fail
            pg.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();

            Locator popupTitle = pg.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.HEADING, new FrameLocator.GetByRoleOptions().setName("Create an Account"));
            assertThat(popupTitle).isVisible();

            // Stop tracing and export it into a zip archive.-- only if stop method called zip file will be created
            //defaults to root directory --> trace.zip
            bc.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("C:\\Users\\Pumpkin\\IdeaProjects\\playwright-java\\trace.zip")));

        }
    }
}
