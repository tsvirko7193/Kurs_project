package demo.test;

import demo.forms.MainForm;
import demo.forms.SearchAppleForm;
import demo.forms.MobileForm;
import webdriver.BaseTest;

public class ProducerSortTest extends BaseTest {
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
		SearchAppleForm.getTestData(context);
		SearchAppleForm.CountElements(); // Проверка наличия записей на
											// странице, соответствующих
											// заданному запросу

	}
}
