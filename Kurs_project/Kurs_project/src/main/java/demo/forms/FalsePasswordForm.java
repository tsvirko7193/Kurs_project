package demo.forms;

import org.openqa.selenium.By;

import webdriver.BaseForm;
import webdriver.elements.Label;

public class FalsePasswordForm extends BaseForm {
	private static String formlocator = "//div[@class='auth-box__line auth-box__line--error js-error']";
	private Label lbl_false_password = new Label(
			By.xpath("//div[contains(.,'Неверный пароль')]"),
			"False Password Label"); // Надпись “Неверный пароль”
	private Label lbl_false_login_password = new Label(
			By.xpath("//div[contains(.,'Неверный ник или e-mail')]"),
			"False Login and password Label"); // Надпись “Неверный логин”

	public void assert_lbl_false_login_password() { // Проверить наличие надписи
													// “Неверный ник или e-mail”
		assert (lbl_false_login_password.isPresent());
	}

	public void assert_lbl_false_password() { // Проверить наличие надписи
												// “Неверный пароль”
		assert (lbl_false_password.isPresent());
	}

	public FalsePasswordForm() {
		super(By.xpath(formlocator), "False Registration page form");
	}
}
