import com.microsoft.playwright.*;
import com.microsoft.playwright.options.FilePayload;

import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandling {
    public static void main(String[] args) {
        try (Playwright pw = Playwright.create()) {

            Browser bw = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext bc = bw.newContext(new Browser.NewContextOptions().setViewportSize(850, 1500).setRecordVideoDir(Paths.get("myVideos/")).setRecordVideoSize(850,1500));
            //only with bc is closed after execution video will be created
            Page pg = bc.newPage();
//            pg.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
//
//            Single file upload
//            pg.setInputFiles("selector", Paths.get("file path"));
//            pg.setInputFiles("input[type='file']", Paths.get("appLogin2.json"));
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//           import java.nio.file.Path / Paths
//            pg.setInputFiles("input[type='file']", new Path[0]); //this will deselect uploaded file
//
//            Multiple file upload - upload button input should allow multiple file upload
//            pg.setInputFiles("input[type='file']", new Path[]{
//                    Paths.get("appLogin2.json"),
//                    Paths.get("example.png"),
//                    Paths.get("pom.xml")
//            });
//
//            pg.setInputFiles("input[type='file']", new Path[0]);    //deselect all uploaded files
//            fileName, mimeType, contentToBeAddedInFile
//            pg.setInputFiles("input[type='file']", new FilePayload("fileName.txt", "text/plain", "file content to be add".getBytes(StandardCharsets.UTF_8)));

            pg.navigate("https://chromedriver.storage.googleapis.com/index.html?path=2.0/");
            // will wait until page is completely downloaded
            //import download from playwright
            Download download = pg.waitForDownload(() -> { // runnable callback
                pg.click("a:text('chromedriver_linux32.zip')");
            });
//            download.cancel();
            System.out.println(download.failure());  // if download is not failure then it will return null

            System.out.println(download.url()); // returns the url which is downloading file
            System.out.println(download.page().title()); // returns page title
            System.out.println(download.path().toString()); // stores in temporary folder - C:\Users\Pumpkin\AppData\Local\Temp\playwright-artifacts-2BEhTh\68699775-c86b-49a5-ab5f-bbb4c79048d2

            // to save file in specific path
            download.saveAs(Paths.get("test.zip")); // it will store in same project directory with this file name
    bc.close();
        }
    }
}
