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

public class CurrencyResultForm extends BaseForm {
	private static String formlocator = "//li[@data-currency='USD']";
	public String Reg_y_e;
	private RemoteWebDriver driver = browser.getDriver();

	List<WebElement> elements = driver.findElements(By
			.xpath("//div[contains(@class,'pprice')]"));// Поиск элементов с
														// одинаковым классом

	@DataProvider(name = "TestSuite")
	public void getTestData(ITestContext context) {
		Reg_y_e = context.getCurrentXmlTest().getParameter("reg_y_e");
	}

	public void CountElements() { // Метод подсчета соответствующих записей на
									// странице
		int i = 1;
		Pattern p = Pattern.compile(Reg_y_e);
		for (WebElement x : elements) {
			Matcher m = p.matcher(x.getText());
			System.out.println(i++ + ")Цена в y.e.:" + x.getText() + "\n");
			assert (m.matches()); // Проверка валюты
		}
	}

	public CurrencyResultForm() {
		super(By.xpath(formlocator), "CurrencyResultForm form");
	}
}
