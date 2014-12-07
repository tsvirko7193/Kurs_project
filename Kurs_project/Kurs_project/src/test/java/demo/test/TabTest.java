package demo.test;

import demo.forms.CatalogForm;
import demo.forms.MainForm;
import demo.forms.MobileForm;
import demo.forms.ProfileTabsForm;
import demo.forms.RegistrationForm;
import demo.forms.TabForm;
import webdriver.BaseTest;

public class TabTest extends BaseTest {
	public void runTest() {
		int step = 1;
		
		// Главная страница сайта http://www.onliner.by/
		
		logger.step(step++);
		MainForm MainForm = new MainForm();
		MainForm.clickButton_reg();  //Нажатие на кнопку “Вход”
		
		// Страница регистрации на сайте
		
		logger.step(step++);
		RegistrationForm RegistrationForm = new RegistrationForm();
		RegistrationForm.getTestData(context);
		RegistrationForm.sendKeys();   //Ввод логина и пароля, нажатие на кнопку “Вход”
		
		// Главная страница сайта http://www.onliner.by/.Присутствует кнопка с
				// именем пользователя
		
		logger.step(step++);
		MainForm.clickButton_mobile();  //Нажатие на кнопку “Мобильные телефоны” 
		
		//Страница содержит каталог мобильных телефонов и смартфонов
		
		logger.step(step++);
		MobileForm MobileForm = new MobileForm();
		MobileForm.clickButton_tab();  //Нажатие на кнопку “Apple  iPhone 6 (16Gb)”
		
		//Страница содержит кнопку “Добавить в закладки”
		
		logger.step(step++);
		TabForm TabForm = new TabForm();
		TabForm.clickButton_add();   //Нажатие на кнопку “Добавить в закладки”
		
		//Страница закладок профиля
		
		logger.step(step++);
		TabForm.clickButton_tabs();//Нажатие на кнопку “Закладки”
		
		//Страница каталога профиля
		
		logger.step(step++);
		ProfileTabsForm ProfileTabsForm = new ProfileTabsForm();
		ProfileTabsForm.clickButton_catalog();  //Нажатие на кнопку “Каталог”
		
		logger.step(step++);
		CatalogForm CatalogForm = new CatalogForm();// Проверка закладки “Apple  iPhone 6 (16Gb)”
		CatalogForm.assertButton_tabprofile();
		
		logger.step(step++);
		CatalogForm.clickButton_delete();//Удаление закладки профиля
}
}
