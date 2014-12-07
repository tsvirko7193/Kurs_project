package demo.test;

import demo.forms.CurrencyResultForm;
import demo.forms.MainForm;
import demo.forms.MobileForm;
import webdriver.BaseTest;

public class SwitchCurrencyTest extends BaseTest {

	public void runTest() {

		int step = 1;

		// Главная страница сайта http://www.onliner.by/

		logger.step(step++);
		MainForm MainForm = new MainForm();
		MainForm.clickButton_mobile();// Нажатие на кнопку “Мобильные телефоны”

		// Страница каталога мобильных телефонов и смартфонов

		logger.step(step++);
		MobileForm MobileForm = new MobileForm();
		MobileForm.clickButton_y_e();// Нажатие на кнопку “ у.е.”

		// Каталог мобильных телефонов и смартфонов с ценой, указанной в y.e

		logger.step(step++);
		CurrencyResultForm CurrencyResultForm = new CurrencyResultForm();
		CurrencyResultForm.getTestData(context);
		CurrencyResultForm.CountElements();// Проверка валюты, вывод цен,
											// указанной в y.e
	}

}
