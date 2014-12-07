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

public class SearchAppleiOSForm extends BaseForm {

	private static String formlocator = "//select[@id='lsmart0']";
	public String Reg_oper_sys;
	private RemoteWebDriver driver = browser.getDriver();
	List<WebElement> elements = driver.findElements(By
					.xpath("//td[contains(@class,'pdescr')]/div[position()=1]")); // Поиск элементов с одинаковым классом

	
	@DataProvider(name = "TestSuite")
	public void getTestData(ITestContext context) {
		Reg_oper_sys = context.getCurrentXmlTest().getParameter("reg_oper_sys");
	}
	
	public void CountElements() { // Метод подсчета соответствующих записей на
		// странице
		int i = 0;
		Pattern p = Pattern.compile(Reg_oper_sys);
		for (WebElement x : elements) {
			Matcher m = p.matcher(x.getText());
			if (m.find())
				i++;
			System.out.println(x.getText() + "\n" + "Операционная система Apple iOS:" + m.matches());
			assert(m.matches()); //Проверка соответствует ли запись запросу
		}
		System.out.println("Количество найденных записей: " + i);
		
	}
	
	public SearchAppleiOSForm() {
		super(By.xpath(formlocator), "SearchAppleiOSForm form");
	}

}
