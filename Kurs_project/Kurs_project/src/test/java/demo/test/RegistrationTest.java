package demo.test;

import webdriver.BaseTest;
import demo.forms.*;

public class RegistrationTest extends BaseTest {

	public void runTest() {

		int step = 1;

		// Главная страница сайта http://www.onliner.by/

		logger.step(step++);
		MainForm MainForm = new MainForm();
		MainForm.clickButton_reg(); // Нажатие на кнопку “Вход”

		// Страница регистрации на сайте

		logger.step(step++);
		RegistrationForm RegistrationForm = new RegistrationForm();
		RegistrationForm.getTestData(context);
		RegistrationForm.sendKeys();// Ввод логина и пароля, нажатие на кнопку
									// “Вход”

		// Главная страница сайта http://www.onliner.by/.Присутствует кнопка с
		// именем пользователя

		logger.step(step++);
		System.out.println("Проверка наличия кнопки “Выход” на странице");
		MainForm.assertButton_exit();// Проверка наличия кнопки “Выход” на
										// странице
	}
}
