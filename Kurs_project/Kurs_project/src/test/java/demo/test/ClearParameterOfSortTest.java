package demo.test;

import demo.forms.MainForm;
import demo.forms.MobileForm;
import demo.forms.SearchAppleForm;
import webdriver.BaseTest;

public class ClearParameterOfSortTest extends BaseTest {

	public void runTest() {
		
		int step = 1;
		
		// Главная страница сайта http://www.onliner.by/

		logger.step(step++);
		MainForm MainForm = new MainForm();
		MainForm.clickButton_mobile(); // Нажатие на кнопку “Мобильные телефоны”

		// Страница содержит каталог мобильных телефонов и смартфонов

		logger.step(step++);
		MobileForm MobileForm = new MobileForm();
		MobileForm.clickButton_select_producer(); // Выбор производителя “Apple”

		logger.step(step++);
		MobileForm.clickButton_search(); // Нажатие на кнопку “Подобрать”

		// Страница содержит каталог мобильных телефонов фирмы Apple

		logger.step(step++);
		SearchAppleForm SearchAppleForm = new SearchAppleForm();
		SearchAppleForm.clickButton_clear_form();// Нажатие на кнопку “Очистить
													// форму”

		// Страница содержит несортированный каталог мобильных телефонов

		logger.step(step++);
		MobileForm MobileForm1 = new MobileForm();
		MobileForm1.getTestData(context);
		MobileForm1.AssertElements();// Проверка наличия хотя бы одного телефона
										// на сиранице марки “Samsung”

	}
}
