package demo.forms;

import org.openqa.selenium.By;

import webdriver.BaseForm;
import webdriver.elements.Button;

public class CatalogForm extends BaseForm {

	private static String formlocator = "//a[@class='pmchk__del']";

	private Button button_select = new Button(
			By.xpath("//input[@id='selectAllBookmarks']"), "Кнопка Выбрать все");
	private Button button_delete = new Button(
			By.xpath("//a[@class='pmchk__del']"), "Кнопка Удалить закладку");
	private Button button_tabprofile = new Button(
			By.linkText("Apple iPhone 6 (16Gb)"), "Кнопка Каталог");

	public void clickButton_delete() { // Нажатие на кнопку "Выбрать все" и "Удалить закладку"
		button_select.click();
		button_delete.click();
	}

	public void assertButton_tabprofile() { // Проверка наличия закладки Apple
											// iPhone 6 (16Gb)
		assert (button_tabprofile.isPresent());
	}

	public CatalogForm() {

		super(By.xpath(formlocator), "Catalog.onliner.by/mobile form");
	}

}
