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
public class ShoppingCartPage extends BaseClass{
	Action act = new Action();
	@FindBy(xpath="(//span[@class='base'])[1]")
	WebElement ShoppingCartHeading;
	
	
	@FindBy(xpath="//span[normalize-space()='Move to Wishlist']")
	WebElement moveToWishListTxtBtn;
	
	@FindBy(xpath="//input[@title='Qty']")
	WebElement qtyTextBox;
	
	@FindBy(xpath="//a[@title='Edit item parameters']")
	WebElement editItem;
	
	@FindBy(xpath="(//a[@title='Remove item'])[2]")
	WebElement removeItem;
	
	@FindBy(xpath="//button[@title='Update Shopping Cart']")
	WebElement updtShopingCartBtn;
	
	@FindBy(xpath="//strong[@id=\"block-discount-heading\"]")
	WebElement discountCodeTxtBtn;
	
	@FindBy(id="coupon_code")
	WebElement discountCodeTxtBox;
	
	@FindBy(xpath="(//button[@value='Apply Discount'])[1]")
	WebElement applyDiscountBtn;
	
	@FindBy(xpath="//button[@data-role='proceed-to-checkout']")
	WebElement proceedToCheckOutBtn;
	
	@FindBy(xpath="//li[@class=\"item\"]//a//span")
	WebElement checkOutMulplAdress;
	
	public ShoppingCartPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateShopCartPage()
	{
		return act.isDisplayed(getDriver(), ShoppingCartHeading);
	}
	
	public ShippingAddressPage clickOnProceedToCheckOut()
	{
		act.click(getDriver(), proceedToCheckOutBtn);
		return new ShippingAddressPage();
	}
}
