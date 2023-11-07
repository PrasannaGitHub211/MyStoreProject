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
public class ReviewAndPaymentPage extends BaseClass {
	
	Action act =  new Action();
	
	@FindBy(xpath="(//div[@data-role='title'])[3]")
	WebElement pymntMthodTitle;
	
	@FindBy(xpath="(//div[@class='payment-method-content']//div)[44]")
	WebElement plcOrderBtn;
	
	@FindBy(xpath="//button[@data-bind='click: back']")
	WebElement editShipToBtn;
	
	@FindBy(xpath="//button[@data-bind='click: backToShippingMethod']")
	WebElement editShipMethodBtn;
	
	public ReviewAndPaymentPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateReviewAndPaymtPageHeading()
	{
		return act.isDisplayed(getDriver(), pymntMthodTitle);
	}
	
	public ShippingAddressPage clickOnEditShipToBtn()
	{
		act.click(getDriver(), editShipToBtn);
		return new ShippingAddressPage();
	}
	
	public ShippingAddressPage clickOnEditShipMethodBtn()
	{
		act.click(getDriver(), editShipMethodBtn);
		return new ShippingAddressPage();
	}

	public OrderConfirmationOrSummaryPage clickOnPlcOrderBtn()
	{
		act.click(getDriver(), plcOrderBtn);
		return new OrderConfirmationOrSummaryPage();
	}
}
