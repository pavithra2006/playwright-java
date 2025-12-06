import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.util.List;

public class textSelector {
    public static void main(String[] args) {
        try (Playwright pw = Playwright.create()) {

            Page pg = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(10)).newPage();
            pg.setDefaultNavigationTimeout(60000);
            pg.navigate("https://www.orangehrm.com/30-day-free-trial/");

           pg.locator("div.btn-toolbar input:has-text('Get Your Free')").click();

            // if there is no text , it will take value attribute

//            //Text Selector
//            Locator ppLink = pg.locator("text = Privacy Policy");
//            System.out.println(ppLink.count());
//            for (int i = 0; i < ppLink.count(); i++) {
//                System.out.println(ppLink.nth(i).textContent().trim());
//                if (ppLink.nth(i).textContent().trim().contains("Service Privacy Policy")) {
//                    ppLink.nth(i).click();
//                    break;
//                }
//            }


        }
    }

}
