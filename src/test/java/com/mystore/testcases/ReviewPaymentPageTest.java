/**
 * 
 */
package com.mystore.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderConfirmationOrSummaryPage;
import com.mystore.pageobjects.ReviewAndPaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingAddressPage;
import com.mystore.pageobjects.ShoppingCartPage;
import com.mystore.pageobjects.SignInPage;

/**
 * @author Shree Computers
 *
 */
public class ReviewPaymentPageTest extends BaseClass {
	Action action = new Action();
	
	IndexPage indexPage;
	SignInPage signInPage;
	HomePage homePage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	ShoppingCartPage shoppingCartPage;
	ShippingAddressPage shippingAdressPage;
	ReviewAndPaymentPage reviewPaymentPage;
	OrderConfirmationOrSummaryPage ocOsp;
	
	@Parameters("browser")
	
	@BeforeMethod(groups={"Smoke","Sanity","Regression"}) 
	public void setup(String browser)
	{
		launchApp(browser);
	}
		
	@AfterMethod(groups={"Smoke","Sanity","Regression"}) 
	public void tearDown()
	{
		getDriver().quit();
	}
	
	@Test(groups="Regression")
	public void validationOfReviewPaymentPage() throws InterruptedException
	{
		indexPage = new IndexPage();
		signInPage = new SignInPage();
		homePage = new HomePage();
		searchResultPage = new SearchResultPage();
		addToCartPage = new AddToCartPage();
		shoppingCartPage = new ShoppingCartPage();
		shippingAdressPage = new ShippingAddressPage();
		reviewPaymentPage =  new ReviewAndPaymentPage();
		
		
		searchResultPage =  homePage.searchProduct("tees");
		boolean result = searchResultPage.isProductAvailble();
		Assert.assertTrue(result);
		
		
		addToCartPage = searchResultPage.clickOnProduct();
		boolean productHasSizeAndColor = true;
		Thread.sleep(5000);;
		// Check if size and color features are available
		if (productHasSizeAndColor) {
		    addToCartPage.selectColor("blue");
		    addToCartPage.selectSize("M");
		}
		// Handle the case where there are no size and color features (productHasSizeAndColor is false).
		// You can add specific handling logic, e.g., proceed without selecting size and color.
		addToCartPage.enterQuantity("2");
		addToCartPage.clickOnAddToCartBtn();
		addToCartPage.clickOnShoppingCartBtnText();
		
		shoppingCartPage.validateShopCartPage();
		shoppingCartPage.clickOnProceedToCheckOut();
		
		Thread.sleep(15000);
		
		shippingAdressPage.validateShippingAdressPage();
		
		//Random text generation 
		String randomFirstName = action.generateRandomFirstName();
		String randomLastName = action.generateRandomLastName();
		String randomCompanyName = action.generateRandomCompanyName();
		String randomStreetName = action.generateRandomStreetName();
		String randomCityName = action.generateRandomCity();
		String randomPostalCode = action.generateRandomPostalCode();
		String randomPhoneNum = action.generateRandomPhoneNumber();
		shippingAdressPage.createNewAdressIfNotLogin(randomFirstName, randomLastName, randomCompanyName, randomStreetName, randomCityName, "Florida", randomPostalCode, "United States", randomPhoneNum);
		reviewPaymentPage.validateReviewAndPaymtPageHeading();
	}
	
	@Test(groups="Regression")
	public void editShipMethod() throws InterruptedException, IOException
	{
		indexPage = new IndexPage();
		signInPage = new SignInPage();
		homePage = new HomePage();
		searchResultPage = new SearchResultPage();
		addToCartPage = new AddToCartPage();
		shoppingCartPage = new ShoppingCartPage();
		shippingAdressPage = new ShippingAddressPage();
		reviewPaymentPage =  new ReviewAndPaymentPage();
		
		signInPage  = indexPage.clickOnSignIn();
		homePage = signInPage.signInMethod(prop.getProperty("username"), prop.getProperty("password"));


		
		searchResultPage =  homePage.searchProduct("tees");
		boolean result = searchResultPage.isProductAvailble();
		Assert.assertTrue(result);
		
		
		addToCartPage = searchResultPage.clickOnProduct();
		boolean productHasSizeAndColor = true;
		Thread.sleep(5000);;
		// Check if size and color features are available
		if (productHasSizeAndColor) {
		    addToCartPage.selectColor("blue");
		    addToCartPage.selectSize("M");
		}
		// Handle the case where there are no size and color features (productHasSizeAndColor is false).
		// You can add specific handling logic, e.g., proceed without selecting size and color.
		addToCartPage.enterQuantity("2");
		addToCartPage.clickOnAddToCartBtn();
		addToCartPage.clickOnShoppingCartBtnText();
		
		shoppingCartPage.validateShopCartPage();
		shoppingCartPage.clickOnProceedToCheckOut();
		
		Thread.sleep(15000);
		
		shippingAdressPage.validateShippingAdressPage();
		shippingAdressPage.clickOnNextBtn();
				
		Thread.sleep(5000);
		reviewPaymentPage.clickOnEditShipMethodBtn();
		
		Thread.sleep(5000);
		shippingAdressPage.clickOnFlatRateShipMethod();
		
		
	}
	
	@Test(groups="Regression")
	public void clickOnPlaceOrderAndVerifyOrderConfirmation() throws InterruptedException
	{
		indexPage = new IndexPage();
		signInPage = new SignInPage();
		homePage = new HomePage();
		searchResultPage = new SearchResultPage();
		addToCartPage = new AddToCartPage();
		shoppingCartPage = new ShoppingCartPage();
		shippingAdressPage = new ShippingAddressPage();
		reviewPaymentPage =  new ReviewAndPaymentPage();
		ocOsp = new  OrderConfirmationOrSummaryPage();
		
		signInPage  = indexPage.clickOnSignIn();
		homePage = signInPage.signInMethod(prop.getProperty("username"), prop.getProperty("password"));


		
		searchResultPage =  homePage.searchProduct("tees");
		boolean result = searchResultPage.isProductAvailble();
		Assert.assertTrue(result);
		
		
		addToCartPage = searchResultPage.clickOnProduct();
		boolean productHasSizeAndColor = true;
		Thread.sleep(5000);;
		// Check if size and color features are available
		if (productHasSizeAndColor) {
		    addToCartPage.selectColor("blue");
		    addToCartPage.selectSize("M");
		}
		// Handle the case where there are no size and color features (productHasSizeAndColor is false).
		// You can add specific handling logic, e.g., proceed without selecting size and color.
		addToCartPage.enterQuantity("2");
		addToCartPage.clickOnAddToCartBtn();
		addToCartPage.clickOnShoppingCartBtnText();
		
		shoppingCartPage.validateShopCartPage();
		shoppingCartPage.clickOnProceedToCheckOut();
		
		Thread.sleep(15000);
		
		shippingAdressPage.validateShippingAdressPage();
		shippingAdressPage.clickOnNextBtn();
				
		Thread.sleep(5000);
		reviewPaymentPage.clickOnEditShipMethodBtn();
		
		Thread.sleep(5000);
		shippingAdressPage.clickOnFlatRateShipMethod();
		
		Thread.sleep(5000);
		reviewPaymentPage.clickOnPlcOrderBtn();
		
		ocOsp.validateOrderSumPage();
		Thread.sleep(3000);
		ocOsp.clickOnContinueShpBtn();
	}
}
