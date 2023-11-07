package com.mystore.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass{
	Action act = new Action();

	String indexPageAssumedExpectedTitle = "New Luma Yoga Collection";
	@FindBy(xpath="(//span[@class='info'])[1]")
	WebElement indexPageAssumedTitle;
	
	
	@FindBy(xpath="(//ul[@class='header links']//li)[2]")
	WebElement signInBtn;
	
	@FindBy(xpath="(//ul[@class='header links']//li)[3]")
	WebElement createAccountBtn;
	
	@FindBy(id="search")
	WebElement searchTextBox;
	
//	@FindBy(className="action showcart")
//	WebElement cartIcon;
	
	@FindBy(xpath = "//*[@class='action showcart']")
	WebElement cartIcon;

	
	@FindBy(className = "logo")
	WebElement myStoreLogo;
	
	@FindBy(xpath="//span[@class='base']")
	WebElement signInPageHeading;  //after navigating to signIn page we will use this web element
	
	
	
	public IndexPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public void validateIndexPageTitle()
	{
		String actualIndexPageTitle = indexPageAssumedTitle.getText();
		System.out.println(actualIndexPageTitle);
		Assert.assertEquals(actualIndexPageTitle, indexPageAssumedExpectedTitle);
	}
	
	public SignInPage clickOnSignIn()
	{
		
		act.click(getDriver(), signInBtn);
		return new SignInPage();
	}
	
	public CreateAccountPage clickOnCreatAccount()
	{
		act.click(getDriver(),createAccountBtn);
		return new CreateAccountPage();
	}
	public boolean validateLogo()
	{
		return act.isDisplayed(getDriver(), myStoreLogo);
	}
	
//	public String getMyStoreTitle()
//	{
//		String myStoreTitle = driver.getTitle();	
//		
//		return myStoreTitle;
//	}
	
	
	public SearchResultPage searchProduct(String productName)
	{
		act.type(searchTextBox, productName);
		searchTextBox.sendKeys(Keys.ENTER);
		return new SearchResultPage();
	}
	
	

}
