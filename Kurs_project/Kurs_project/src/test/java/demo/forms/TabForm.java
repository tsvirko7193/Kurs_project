package demo.forms;

import org.openqa.selenium.By;

import webdriver.BaseForm;
import webdriver.elements.Button;

public class TabForm extends BaseForm{
	private static String formlocator = "//div[@class='b-offers-heading']";
	
	private Button button_addtag = new Button(By.tagName("u"), "Кнопка Добавить в закладки");
	private Button button_tabs = new Button(By.linkText("Закладки"), "Кнопка Закладки");
	
	public void clickButton_tabs() { // Нажатие на кнопку "Закладки"
		button_tabs.click();
	}
	
	public void clickButton_add() { // Нажатие на кнопку "Добавить в закладки"
		button_addtag.click();
	}

	public TabForm() {
		super(By.xpath(formlocator), "Catalog.onliner.by/mobile form");
	}
}
