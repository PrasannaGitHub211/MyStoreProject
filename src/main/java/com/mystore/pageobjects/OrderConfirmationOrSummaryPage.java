/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author Shree Computers
 *
 */
public class OrderConfirmationOrSummaryPage extends BaseClass{
	Action act  = new Action();
	
	@FindBy(xpath="//span[@data-ui-id='page-title-wrapper']")
	WebElement SummaryPageHeading;
	
	
	@FindBy(xpath="//body//div//main//p[1]")
	WebElement summaryNum;
	
	@FindBy(xpath="(//a)[43]")
	WebElement printRecieptTxtBtn;
	
	@FindBy(xpath="//div[@class='checkout-success']//div//div/a")
	WebElement contnShopBtn;
	
	public OrderConfirmationOrSummaryPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateOrderSumPage()
	{
		return act.isDisplayed(getDriver(), SummaryPageHeading);
	}
	
	public HomePage clickOnContinueShpBtn()
	{
		act.click(getDriver(), contnShopBtn);
		return new HomePage();
	}

}
