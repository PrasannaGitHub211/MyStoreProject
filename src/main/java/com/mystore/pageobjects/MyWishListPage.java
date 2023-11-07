/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mystore.base.BaseClass;

/**
 * @author Shree Computers
 *
 */
public class MyWishListPage extends BaseClass {
	
	String myWishListPageExpectedTitle = "My Wish List";
	
	
	@FindBy(xpath="//span[@class='base']")
	WebElement wishListPageTitle;
	
	
	public MyWishListPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public void validateWishListPageTitle()
	{
		String actualWishListPageTitle = wishListPageTitle.getText();
		System.out.println(actualWishListPageTitle);
		Assert.assertEquals(actualWishListPageTitle, myWishListPageExpectedTitle);
	}
	
}
