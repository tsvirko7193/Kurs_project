package demo.test;

import demo.forms.MainForm;
import demo.forms.MobileForm;
import demo.forms.SortForm;
import webdriver.BaseTest;

public class SortOfGoodsTest extends BaseTest {

	public void runTest() {

		int step = 1;
		
		// Главная страница сайта http://www.onliner.by/
		
		logger.step(step++);
		MainForm MainForm = new MainForm();
		MainForm.clickButton_mobile();//Нажатие на кнопку “Мобильные телефоны”
		
		//Страница каталога мобильных телефонов и смартфонов
		
		logger.step(step++);
		MobileForm MobileForm = new MobileForm();
		MobileForm.clickButton_sort();  //Нажатие на кнопку “Сортировать по цене”
		
		//Главная страница сайта http://www.onliner.by/. Присутствует кнопка с именем пользователя 
		
		logger.step(step++);
		SortForm SortForm = new SortForm();
		SortForm.CountElements(); //Вывод цен после сортировки 
}
}