package demo.test;

import demo.forms.FalsePasswordForm;
import demo.forms.MainForm;
import demo.forms.RegistrationForm;
import webdriver.BaseTest;

public class FalseRegistrationTest extends BaseTest {

	public void runTest() {
		int step = 1;

		// Главная страница сайта http://www.onliner.by/

		logger.step(step++);
		MainForm MainForm = new MainForm();
		MainForm.clickButton_reg();// Нажатие на кнопку “Вход”

		// Страница регистрации на сайте

		logger.step(step++);
		RegistrationForm RegistrationForm = new RegistrationForm();
		RegistrationForm.getTestData(context);
		RegistrationForm.sendKeysWithoutPassword();// Ввод логина без пароля,
													// нажатие на кнопку “Вход”

		// Страница регистрации, содержащая надпись “Неверный пароль”

		logger.step(step++);
		FalsePasswordForm FalsePasswordForm = new FalsePasswordForm();
		System.out.println("Проверка наличия надписи “Неверный пароль”");
		FalsePasswordForm.assert_lbl_false_password(); // Проверить наличие
														// надписи “Неверный
														// пароль”

		logger.step(step++);
		RegistrationForm.sendKeysWithoutLogin_Password();// Очистить окно
															// логина, нажатие
															// на кнопку “Вход”

		// Страница регистрации, содержащая надпись “Неверный ник или e-mail”

		logger.step(step++);
		System.out.println("Проверка наличия надписи “Неверный ник или e-mail ”");
		FalsePasswordForm.assert_lbl_false_login_password();// Проверить наличие
															// надписи “
															// Неверный ник или
															// e-mail ”
	}
}
