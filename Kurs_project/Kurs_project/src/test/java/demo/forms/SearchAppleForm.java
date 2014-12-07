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
import webdriver.elements.Button;

public class SearchAppleForm extends BaseForm {
	
	private static String formlocator = "//select[@id='lmfr0']";
	//private static String formlocator = "//select[@id='//option[@value='apple']']";
	public String Reg;
	private RemoteWebDriver driver = browser.getDriver();
	List<WebElement> elements = driver.findElements(By
					.xpath("//strong[contains(@class,'pname')]")); // Поиск элементов с одинаковым классом

	private Button button_clear_form = new Button(
			By.linkText("Очистить форму"), "Clear form button"); // Кнопка
																	// "Очистить форму"
	
	@DataProvider(name = "TestSuite")
	public void getTestData(ITestContext context) {
		Reg = context.getCurrentXmlTest().getParameter("reg");
	}
	
	public void clickButton_clear_form() { // Нажатие на кнопку "Очистить форму"
		button_clear_form.click();
	}
	
	public void CountElements() { // Метод подсчета соответствующих записей на
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
	
	public SearchAppleForm() {
		super(By.xpath(formlocator), "Catalog.onliner.by/mobile form");
	}

}
