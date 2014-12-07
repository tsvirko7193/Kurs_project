package demo.forms;

import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.TextBox;

public class RegistrationForm extends BaseForm {

	private static String formlocator = "//div[@class='auth-main']";
	public String Login;
	public String Password;
	private Button button_enter = new Button(
			By.xpath("(//button[@class='auth-box__auth-submit auth__btn auth__btn--green'])"),
			"Enter button"); // Кнопка "Войти"
	private TextBox login = new TextBox(By.className("auth-box__input")); // Поле для ввода логина
	private TextBox password = new TextBox(
			By.xpath("//input[@type='password']"));// Поле для ввода пароля

	private Button button_forget = new Button(
			By.xpath("(//a[@class='auth-box__complementary auth-box__complementary--link'])"),
			"Forgotten password button"); // Кнопка "Не помню"
	
	@DataProvider(name = "TestSuite")
	public void getTestData(ITestContext context) {
		Login = context.getCurrentXmlTest().getParameter("login");
		Password = context.getCurrentXmlTest().getParameter("password");
	}
	
	public void click_btn_forget() { // Нажатие на кнопку "Не помню"
		button_forget.click();
	}
	
	public void sendKeys() { // Ввод логина и пароля, нажатие на кнопку "Войти"
		login.setText(Login);
		password.setText(Password);
		button_enter.click();
	}
	
	public void sendKeysWithoutPassword() { // Ввод логина без пароля, нажатие на кнопку "Войти"
		login.setText(Login);
		button_enter.click();
	}
	
	public void sendKeysWithoutLogin_Password() { //Нажатие на кнопку "Войти" без логина и пароля, 
		login.setText("");
		button_enter.click();
	}
	
	public RegistrationForm() {
		super(By.xpath(formlocator), "Registration page form");
	}

}
