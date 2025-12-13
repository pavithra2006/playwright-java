import com.microsoft.playwright.*;

import java.awt.*;

public class ReactApplication {
    public static void main(String[] args) {
        try (Playwright pw = Playwright.create()) {
            //import tool kit from java awt import java.awt.*;
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            int height = (int) dim.getHeight(); // cast double to int - 864
            int width = (int) dim.getWidth(); // 1536
            System.out.println(height + " ," + width);

            Browser bw = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext bc = bw.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
            Page pg = bc.newPage();
            pg.navigate("https://www.netflix.com/in/");

            pg.fill("input[name='email'] >> nth=0", "abc");
            pg.click("text=Get Started >> nth=0");
            pg.pause();
        }
    }
}