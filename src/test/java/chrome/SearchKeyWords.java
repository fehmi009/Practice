package chrome;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchKeyWords {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/fehmibaltaci/Downloads/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();

		driver.get("https://www.google.com/");

		driver.findElement(By.name("q")).sendKeys("pen");
		
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//a[@aria-label='Page 2']")).click();

		List<WebElement> penElements = driver.findElements(By.xpath("//*[@id='center_col']//following-sibling::h3"));
		
		int count = penElements.size();
		
		System.out.println("COUNT OF ELEMENTS  " + count);

		// String array olusturuyoruz ve mevcudunu elementlerimiz ka. taneyse kadar yapiyoruz
		
		String[] ARRAY_ELEMENTS = new String[count];
		
		//Suanda bos bir string array var elimizde 
		// for loop kullanip bunun icini dolduruyoruz 

		int i = 0;

		for (WebElement a : penElements) {
			ARRAY_ELEMENTS[i] = a.getText();
			i++;
			// penElements listesindeki elemanlari teker teker aldik ve 
			// ArrayElements in icine teker teker for loop  yardimiyla koyuyoruz
		}

		String stringOf_myElements = Arrays.toString(ARRAY_ELEMENTS);
		// Arrayi string haline getirmemiz lazim cunki split() method kullanicaz

		String[] wordsInTheList = stringOf_myElements.split(" ");
		
		// Split methodu kullanildiginda sonuc her zaman Array olusturur !!!
		// onun icin string array e assign ettik

		System.out.println(Arrays.toString(wordsInTheList));
		
		
		
		// string array icinden teker teker kelimeleri alip "pen" kelimesini ariyacagiz 
		// boyle bir durumda for-each loop kullanmak daha kolay olabilir !!!
		int penCount = 0;
		
		for (String s : wordsInTheList) {
			if (s.toLowerCase().contains("pen"))
				penCount++;
			else
				penCount += 0;
		}
		
		System.out.println("Count of pen in the page -->  " + penCount);
		
		System.out.println("Count of all words in the page -->  " + wordsInTheList.length);
	}

}
