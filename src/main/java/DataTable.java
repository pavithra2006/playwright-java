import com.microsoft.playwright.*;

public class DataTable {
    public static void main(String[] args) {
        try(Playwright pw = Playwright.create()){
            Browser bw = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page pg = bw.newContext(new Browser.NewContextOptions().setViewportSize(800,1500)).newPage();
            pg.navigate("https://datatables.net/");
            Locator rows = pg.locator("#example tr"); //select all rows in table --> 12
            Locator softwareEngRow = rows.locator(":scope", new Locator.LocatorOptions().setHasText("Software Engineer"));
            for(int i = 0; i < softwareEngRow.count(); i++){
                String name = softwareEngRow.nth(i).locator("td >> nth=0").textContent();
                System.out.println(name);
            }

//            rows.locator(":scope").allTextContents().forEach(e->System.out.println(e));
            System.out.println("*************");
            softwareEngRow.locator(":scope").allTextContents().forEach(e->System.out.println(e));








        }
    }
}
