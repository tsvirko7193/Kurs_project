package demo.test;

import demo.forms.MainForm;
import demo.forms.MobileForm;
import demo.forms.SearchAppleiOSForm;
import webdriver.BaseTest;

public class OperatingSystemSortTest extends BaseTest {

	public void runTest() {

		int step = 1;
		// Главная страница сайта http://www.onliner.by/
		logger.step(step++);
		MainForm MainForm = new MainForm();
		MainForm.clickButton_mobile(); // Нажатие на кнопку “Мобильные телефоны”

		// Страница содержит каталог мобильных телефонов и смартфонов

		logger.step(step++);
		MobileForm MobileForm = new MobileForm();
		MobileForm.clickButton_select_operation_system(); // Выбор операционной системы “Apple iOS”

		logger.step(step++);
		MobileForm.clickButton_search(); // Нажатие на кнопку “Подобрать”

		// Страница содержит каталог мобильных телефонов с операционной системой “Apple iOS”
		
		logger.step(step++);
		SearchAppleiOSForm SearchAppleiOSForm = new SearchAppleiOSForm();
		SearchAppleiOSForm.getTestData(context);
		SearchAppleiOSForm.CountElements();//Проверка операционной системы у найденных товаров
	}

}
