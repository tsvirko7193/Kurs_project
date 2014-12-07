package demo.forms;

import org.openqa.selenium.By;

import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.Label;

public class EnterForm extends BaseForm {
	private static String formlocator = "//button[@class='top-search-button']";
	private Button button_find = new Button(By.className("top-search-button"),
			"Find button");// Кнопка "Найти"

	private Label lbl_find = new Label(By.className("g-top-i"),
			"Find button");// Кнопка "Найти"
	
	public void clicklbl_find() { // Нажатие на кнопку "Найти"
		lbl_find.click();
	}
	
	public void clickButton_find() { // Нажатие на кнопку "Найти"
		button_find.click();
	}

	public EnterForm() {
		super(By.xpath(formlocator), "Enter form");
	}

}

