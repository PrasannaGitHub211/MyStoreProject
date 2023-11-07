package com.mystore.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass{
	Action act = new Action();
	
	//	@FindBy(xpath="//a[contains(text(),'Radiant Tee')]")
	
	//	@FindBy(xpath="(//div[contains(@class, 'product')])[3]")
	
	@FindBy(xpath="(//div//ol/li)[1]")
	WebElement productResult;
	
	public SearchResultPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isProductAvailble()
	{
		return act.isDisplayed(getDriver(), productResult);
	}
//	public AddToCartPage clickOnProduct()
//	{
//		act.click(driver, productResult);
//		return new AddToCartPage();
//	}
	
	
//	public AddToCartPage clickOnProduct() {
//	    WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(20)); // Replace 10 with your desired timeout duration in seconds.
//	    wait.until(ExpectedConditions.elementToBeClickable(productResult));
//	    act.click(driver, productResult);
//	    return new AddToCartPage();
//	}
	
	public AddToCartPage clickOnProduct() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 300);");

	    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div//ol/li)[1]")));
	    act.click(getDriver(), productResult);
	    return new AddToCartPage();
	}

}
