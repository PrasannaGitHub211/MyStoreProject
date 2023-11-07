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
public class AddToCartPage extends BaseClass{
	
	Action act = new Action();
	
	@FindBy(xpath="//div[@aria-label='M']")
	WebElement mediumSize;
	
	@FindBy(xpath="//div[@aria-label='XS']")
	WebElement extraSmallSize;
	
	@FindBy(xpath="//div[@aria-label='S']")
	WebElement smallSize;
	
	@FindBy(xpath="//div[@aria-label='L']")
	WebElement largeSize;
	
	@FindBy(xpath="//div[@aria-label='XL']")
	WebElement extraLargeSize;
	
	@FindBy(xpath="//div[@aria-label='Blue']")
	WebElement blueColor;
	
	@FindBy(xpath="//div[@aria-label='Orange']")
	WebElement orangeColor;
	
	@FindBy(xpath="//div[@aria-label='Purple']")
	WebElement purpleColor;
	
	@FindBy(xpath="//input[@title='Qty']")
	WebElement qtyTextBox;
	
	@FindBy(id="product-addtocart-button")
	WebElement addToCartBtn;
	
	@FindBy(xpath="//span[normalize-space()='Add to Wish List']")
	WebElement addToWishListBtn;
	
	@FindBy(xpath="//a[normalize-space()='Details']")
	WebElement detailsTab;
	
	@FindBy(xpath="//a[normalize-space()='More Information']")
	WebElement moreDeatilsTab;
	
	@FindBy(xpath = "//div[@aria-controls='reviews']//a[@class='data switch']")
	WebElement reviewTab;
	
	@FindBy(xpath="//a[contains(text(),'shopping cart')]")
	WebElement shoppingCartBtnText;
	
	public AddToCartPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
//	public void selectSize(String size)
//	{
//		if(size=="XS")
//		{
//			act.click(driver, extraSmallSize);
//		}
//		else if(size=="S")
//		{
//			act.click(driver, smallSize);
//		}
//		else if(size=="M")
//		{
//			act.click(driver, mediumSize);
//		}
//		else if(size=="L")
//		{
//			act.click(driver, largeSize);
//		}
//		else if(size=="XL")
//		{
//			act.click(driver, extraLargeSize);
//		}
//	}
//	
//	public void selectColor(String color)
//	{
//		if(color=="blue")
//		{
//			act.click(driver, blueColor);
//		}
//		else if(color=="orange")
//		{
//			act.click(driver, orangeColor);
//		}
//		else if(color=="purple")
//		{
//			act.click(driver, purpleColor);
//		}
//	}
	
	
	public void selectSize(String size)
	{
	    if(size != null) {
	        if(size.equalsIgnoreCase("XS")) {
	            act.click(getDriver(), extraSmallSize);
	        }
	        else if(size.equalsIgnoreCase("S")) {
	            act.click(getDriver(), smallSize);
	        }
	        else if(size.equalsIgnoreCase("M")) {
	            act.click(getDriver(), mediumSize);
	        }
	        else if(size.equalsIgnoreCase("L")) {
	            act.click(getDriver(), largeSize);
	        }
	        else if(size.equalsIgnoreCase("XL")) {
	            act.click(getDriver(), extraLargeSize);
	        }
	    }
	}

	public void selectColor(String color)
	{
	    if(color != null) {
	        if(color.equalsIgnoreCase("blue")) {
	            act.click(getDriver(), blueColor);
	        }
	        else if(color.equalsIgnoreCase("orange")) {
	            act.click(getDriver(), orangeColor);
	        }
	        else if(color.equalsIgnoreCase("purple")) {
	            act.click(getDriver(), purpleColor);
	        }
	    }
	}

	
	public void enterQuantity(String qty)
	{
		act.clearTextField(qtyTextBox);
		act.type(qtyTextBox, qty);
	}
	
	
	public void clickOnAddToCartBtn()
	{
		act.click(getDriver(), addToCartBtn);
	}
	
	public ShoppingCartPage clickOnShoppingCartBtnText()
	{
		act.click(getDriver(), shoppingCartBtnText);
		return new ShoppingCartPage();
	}
}
