import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.util.List;

public class Locators {
    public static void main(String[] args) {
        try (Playwright pw = Playwright.create()) {

            Page pg = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(10)).newPage();
            pg.setDefaultNavigationTimeout(60000);
            pg.navigate("https://www.orangehrm.com/30-day-free-trial/");

            //Single element
            Locator allowAllBtn = pg.locator("text = Allow all");
            allowAllBtn.click();
            Locator countryOption = pg.locator("select#Form_getForm_Country option");
            System.out.println(countryOption.count());
//METHOD1 - iterate on index
//            for (int i = 0; i < countryOption.count(); i++) {
//                //returns innertext for given locator
//                String country = countryOption.nth(i).textContent();
//                System.out.println(country);
//            }
//METHOD2 - create list and iterate
//            List<String> countryList = countryOption.allTextContents();
            //for
//            for(String s: countryList)
//                System.out.println(s);
            //lambda
//            countryList.forEach(ele -> System.out.println(ele.trim()));
            //without trim --> whitelines will be listed
//lamda with method reference
            //  countryList.forEach(System.out::println);

            List<String> countryList2 = countryOption.allInnerTexts();
            countryList2.forEach(elm->System.out.println(elm.trim()));
        }
    }
}
