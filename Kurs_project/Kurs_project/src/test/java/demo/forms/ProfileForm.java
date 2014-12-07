package demo.forms;

import org.openqa.selenium.By;

import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.Label;

public class ProfileForm extends BaseForm  {

	private static String formlocator = "//body[@class='ten-skin']";
	private Label lbAssert = new Label(By.className("m-title"));   // Значение имени профиля
	private Button button_exit = new Button(
			By.className("exit"), "Exit button");
	
	public void searchAssert(){    // Проверка имени профиля на странице
		System.out.println("Имя вашего профиля: " + lbAssert.getText());
		assert(lbAssert.isPresent());
	}
	
	public void clickButton_exit() { // Нажатие на кнопку "Выход"
		button_exit.click();
	}

	public ProfileForm() {
		super(By.xpath(formlocator), "Profile page form");
	}

}
