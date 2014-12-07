package demo.forms;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import webdriver.BaseForm;

public class SearchResult extends BaseForm {
	private static String formlocator = "//h1[contains(.,'Результаты поиска')]";
	public String Reg;
	
	private RemoteWebDriver driver = browser.getDriver();
	List<WebElement> elements = driver.findElements(By
					.xpath("//strong[contains(@class,'pname')]")); // Поиск элементов с одинаковым классом

	@DataProvider(name = "TestSuite")
	public void getTestData(ITestContext context) {
		Reg = context.getCurrentXmlTest().getParameter("reg");
	}
	
	public void AssertElements() { // Метод подсчета соответствующих записей на
		// странице
		int i = 0;
		Pattern p = Pattern.compile(Reg);
		for (WebElement x : elements) {
			Matcher m = p.matcher(x.getText());
			if (m.find())
				i++;
			System.out.println(x.getText() + "\n" + "Фирма Apple:" + m.matches());
			assert(m.matches()); //Проверка соответствует ли запись запросу
		}
		System.out.println("Количество найденных записей: " + i);
		
	}
	public SearchResult() {
		super(By.xpath(formlocator), "SearchResult form");
	}
}
