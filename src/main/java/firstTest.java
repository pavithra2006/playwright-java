import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class firstTest {
	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
			LaunchOptions launch = new LaunchOptions(); // LaunchOptions is a class
			launch.setChannel("msedge");

			launch.setHeadless(false);
			launch.setSlowMo(200);
			Browser browser = playwright.chromium().launch(launch);
			Page page = browser.newPage();
			page.navigate("https:amazon.com");
			System.out.println(page.title());
			System.out.println(page.url());
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue shopping")).click();
			page.pause();

//			browser.close(); playwright.close();

		}
	}
}
