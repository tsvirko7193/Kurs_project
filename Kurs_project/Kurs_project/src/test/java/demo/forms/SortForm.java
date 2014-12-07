package demo.forms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import webdriver.BaseForm;

public class SortForm extends BaseForm {
	
	private static String formlocator = "//body[@class='ten-skin']";
	private RemoteWebDriver driver = browser.getDriver();
	
	List<WebElement> elements = driver
			.findElements(By
					.xpath("//div[contains(@class,'pprice pprice_byr')]"));// Поиск элементов с одинаковым классом

	
	public void CountElements() { // Метод подсчета соответствующих записей на
		// странице
		int i = 1;
		System.out.println("Сортировка по цене(по убыванию)");
		for (WebElement x : elements) {
			System.out.println(i++ + ")Цена:" + x.getText() + "\n");
		}
	}
	
	public SortForm() {
		super(By.xpath(formlocator), "Catalog.onliner.by/mobile form");
	}
}
