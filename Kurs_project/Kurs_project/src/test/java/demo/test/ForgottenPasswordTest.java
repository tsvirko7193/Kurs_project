package demo.test;

import demo.forms.MainForm;
import demo.forms.RecoveryPasswordForm;
import demo.forms.RegistrationForm;
import webdriver.BaseTest;

public class ForgottenPasswordTest extends BaseTest {

	public void runTest() {
		
		int step = 1;

		// Главная страница сайта http://www.onliner.by/

		logger.step(step++);
		MainForm MainForm = new MainForm();
		MainForm.clickButton_reg();// Нажатие на кнопку “Вход”

		// Страница регистрации на сайте

		logger.step(step++);
		RegistrationForm RegistrationForm = new RegistrationForm();
		RegistrationForm.click_btn_forget();// Нажатие на кнопку “Не помню”

		// Главная страница сайта http://www.onliner.by/.Присутствует кнопка с
		// именем пользователя

		logger.step(step++);
		RecoveryPasswordForm RecoveryPasswordForm = new RecoveryPasswordForm();
		RecoveryPasswordForm.assert_btn_send_password();// Проверка наличия
														// кнопки “Выслать мне
														// пароль”
	}
}
