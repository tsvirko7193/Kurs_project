package demo.test;

import webdriver.BaseTest;
import demo.forms.EnterForm;
import demo.forms.MainForm;
import demo.forms.SearchResult;

public class SearchAppleTest extends BaseTest {
	public void runTest() {

		int step = 1;

		// Главная страница сайта http://www.onliner.by/

		logger.step(step++);
		MainForm MainForm = new MainForm();
		MainForm.getTestData(context);
		MainForm.SetText_txb_search();// Ввод в окно поиска “Apple”

		logger.step(step++);
		EnterForm EnterForm = new EnterForm();
		EnterForm.clickButton_find();
		EnterForm.clickButton_find();// Нажатие на кнопку “Найти”

		// Страница содержит каталог мобильных телефонов фирмы Apple

		logger.step(step++);
		SearchResult SearchResult = new SearchResult();
		SearchResult.getTestData(context);
		SearchResult.AssertElements();// Проверка результатов запроса

	}
}
