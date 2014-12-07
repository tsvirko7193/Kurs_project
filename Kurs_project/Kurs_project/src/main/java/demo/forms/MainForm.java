package demo.forms;

import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.TextBox;


public class MainForm extends BaseForm {

	private static String formlocator = "//div[@id='container']";
	public String Search;
	
	private Button button_reg = new Button(
			By.xpath("(//div[@class='auth-bar__item auth-bar__item--text'])"),
			"Кнопка войти"); // Кнопка "Войти"

	private Button button_exit = new Button(By.className("exit"), "Exit button");// Кнопка "Выйти"
	private TextBox txb_search = new TextBox(By.xpath("//input[@id='g-search-input']"), "Search textbox");// Окно поиска
	private Button button_mobile = new Button(
			By.linkText("Мобильные телефоны"), "Mobile button");
	
	@DataProvider(name = "TestSuite")
	public void getTestData(ITestContext context) {
		Search = context.getCurrentXmlTest().getParameter("search");
	}
	
	public void SetText_txb_search() { // Ввод текста в строку поиска
		txb_search.setText(Search);
	}
	
	public void clickButton_mobile() { // Нажатие на кнопку "Мобильные телефоны"
		button_mobile.click();
	}

	public void clickButton_reg() { // Нажатие на кнопку "Вход"
		button_reg.click();
	}

	public void assertButton_exit() { // Проверка наличия кнопки "Выход"
		assert (button_exit.isPresent());
	}

	public MainForm() {
		super(By.xpath(formlocator), "onliner.by form");
	}

}
