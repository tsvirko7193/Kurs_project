package demo.forms;

import org.openqa.selenium.By;

import webdriver.BaseForm;
import webdriver.elements.Button;

public class RecoveryPasswordForm extends BaseForm {
	private static String formlocator = "//div[@class='logo']";
	private Button btn_send_password = new Button(
			By.xpath("(//div[@class='btn'])"),
			"Send me the password button"); // Кнопка "Выслать мне пароль"
	
	public void assert_btn_send_password() { // Нажатие на кнопку "Не помню"
		assert(btn_send_password.isPresent());
	}
	
	public RecoveryPasswordForm() {
		super(By.xpath(formlocator), "Registration page form");
	}

}
