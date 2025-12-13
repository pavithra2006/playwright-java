import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class NthLocator {
    public static void main(String[] args) {
        try(Playwright pw = Playwright.create()){
            Page pg = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newContext().newPage();
            pg.navigate("https://www.bigbasket.com/");
pg.pause();
            Locator popularCategories0 = pg.locator("h4:has-text('Popular Categories') + ul li a >> nth=0");
            Locator popularCategories1 = pg.locator("h4:has-text('Popular Categories') + ul li a >> nth=1");
            Locator popularCategoriesMinus1 = pg.locator("h4:has-text('Popular Categories') + ul li a >> nth=-1");

            System.out.println(popularCategories0.textContent() + " " + popularCategories1.textContent() + " " + popularCategoriesMinus1.textContent());

        }
    }
}
