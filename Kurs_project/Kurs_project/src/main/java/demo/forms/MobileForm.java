package demo.forms;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import webdriver.BaseForm;
import webdriver.elements.Button;

public class MobileForm extends BaseForm {

	// private static String formlocator = "//h1[@id='unline']";
	private static String formlocator = "//h1[contains(.,'Каталог мобильных телефонов и смартфонов')]";
	private RemoteWebDriver driver = browser.getDriver();
	public String Reg_samsung;
	
	private Button button_sort = new Button(By.linkText("Цене"), "Sort by price button"); // Кнопка
																					// "Сортировать по цене"

	private Button button_y_e= new Button(
			By.xpath("//li[@class='catalog-bar__switcher-item']"), "Y.e button"); // Кнопка
																			// "Y.e"

	private Button button_select_operation_system = new Button(
			By.xpath("//option[@value='ios']"), "Operation_system sort button"); // Кнопка
																			// "Apple iOS"
	
	private Button button_select_producer = new Button(
			By.xpath("//option[@value='apple']"), "Producer sort button"); // Кнопка
																			// "Выбор производителя"

	private Button button_add_producer = new Button(
			By.xpath("//a[@class='unvis']"), "Add_producer button"); // Кнопка
																// "Добавить"
																// производителя

	private Button button_search = new Button(
			By.xpath("//input[@name='search']"), "Search button"); // Кнопка
																	// "Подобрать"


	private Button button_clear_form = new Button(
			By.xpath("//a[@class='unvis']"), "Clear form button"); // Кнопка
																	// "Очистить форму"
	
	private Button button_tab = new Button(
			By.linkText("Apple iPhone 6 (16Gb)"), "Tab button"); // Кнопка
																	// "Apple iPhone 6 (16Gb)"

	
	List<WebElement> elements = driver.findElements(By
			.xpath("//strong[contains(@class,'pname')]")); // Поиск элементов с одинаковым классом

	@DataProvider(name = "TestSuite")
	public void getTestData(ITestContext context) {
		Reg_samsung = context.getCurrentXmlTest().getParameter("reg_samsung");
	}

	public void AssertElements() { // Метод подсчета соответствующих записей на
		// странице
		int i = 0;
		Pattern p = Pattern.compile(Reg_samsung);
		for (WebElement x : elements) {
			Matcher m = p.matcher(x.getText());
			if (m.find())
				i++;
			System.out.println(x.getText() + "\n" + "Фирма Samsung:"
					+ m.matches());
		}
		Assert.assertNotNull(i);// Проверка наличия хотя бы одного телефона на
								// странице марки "Samsung"
		System.out.println("Количество найденных записей: " + i);

	}
	
	public void clickButton_y_e() { // Нажатие на кнопку "y.e"
		button_y_e.click();
	}
	
	public void clickButton_add_producer() { // Нажатие на кнопку "Добавить"
												// производителя
		button_add_producer.click();
	}

	public void clickButton_search() { // Нажатие на кнопку "Подобрать"
		button_search.click();
	}
	
	public void clickButton_clear_form() { // Нажатие на кнопку "Очистить форму"
		button_clear_form.click();
	}

	public void clickButton_select_operation_system() { // Выбор операционной системы: Apple iOS
		button_select_operation_system.click();
	}
	
	public void clickButton_select_producer() { // Выбор производителя: Apple
		button_select_producer.click();
	}

	public void clickButton_tab() { // Нажатие на кнопку "Apple iPhone 6 (16Gb)"
		button_tab.click();
	}

	public void clickButton_sort() { // Нажатие на кнопку "Сортировать по цене"
		button_sort.click();
	}

	public MobileForm() {
		super(By.xpath(formlocator), "MobileForm form");
	}
}
