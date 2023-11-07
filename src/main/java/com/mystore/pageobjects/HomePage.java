/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author Shree Computers
 *
 */
public class HomePage extends BaseClass {
	Action act = new Action();
	
	@FindBy(id="search")
	WebElement searchTextBox;
	
	@FindBy(xpath="(//button[@type='button'])[1]")
	WebElement arrowIcon;
	
	@FindBy(xpath ="(//a[normalize-space()='My Account'])[1]")
	WebElement myAccount;
	
	@FindBy(xpath="(//a[normalize-space()='My Wish List'])[1]")
	WebElement myWishList;
	
	@FindBy(xpath="(//a[normalize-space()='Sign Out'])[1]")
	WebElement signOut;
	
	public HomePage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
//	public SearchResultPage searchProduct(String searchKeyWord)
//	{
//		act.type(searchTextBoxAndBtn, searchKeyWord);
//		searchTextBoxAndBtn.sendKeys(Keys.ENTER);
//		return new SearchResultPage();
//	}
	
	public SearchResultPage searchProduct(String productName)
	{
		act.type(searchTextBox, productName);
		searchTextBox.sendKeys(Keys.ENTER);
		return new SearchResultPage();
	}
	
	public String getCurrentUrl()
	{
		String homePageURL = getDriver().getCurrentUrl();
		return homePageURL;
	}
	
	public void clickArrowIcon()
	{
		act.click(getDriver(), arrowIcon);
	}
	
	public MyAccountPage clickMyAccount()
	{
		act.click(getDriver(), myAccount);
		return new MyAccountPage();
	}
	
	public MyWishListPage clickMyWishList()
	{
		act.click(getDriver(), myWishList);
		return new MyWishListPage();
	}
	
	public IndexPage clickSignOut()
	{
		act.click(getDriver(), signOut);
		act.pageLoadTimeOut(getDriver(), 6);
		return new IndexPage();
	}
	
	
}
