
import java.util.regex.Pattern;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class firstTest {
	public static void main(String[] args) {
		//tests
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			BrowserContext context = browser.newContext();
			Page page = context.newPage();
			page.navigate("https://playwright.dev");
			// Expect a title "to contain" a substring.
			System.out.println(page.title());
			assertThat(page).hasTitle(Pattern.compile("Playwright"));
		
			Locator getStartedXpath = page.locator("//a[text()='Get started']");
			assertThat(getStartedXpath).isVisible();
			getStartedXpath.click();
			
			Locator installationXpath = page.locator("//h1[text()='Installation']");
			assertThat(installationXpath).isVisible();
		}
	}
}