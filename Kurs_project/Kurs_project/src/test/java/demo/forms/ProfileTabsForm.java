package demo.forms;

import org.openqa.selenium.By;

import webdriver.BaseForm;
import webdriver.elements.Button;

public class ProfileTabsForm extends BaseForm {
	private static String formlocator = "//div[@class='b-hdtopic']";
	
	private Button button_catalog = new Button(
			By.linkText("Каталог"), "Кнопка Каталог");
	

	public void clickButton_catalog() { // Нажатие на кнопку "Каталог"
		button_catalog.click();
	}
	
	public ProfileTabsForm() {
		super(By.xpath(formlocator), "Catalog.onliner.by/mobile form");
	}
}
