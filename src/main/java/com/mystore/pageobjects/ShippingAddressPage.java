/**
 * 
 */
package com.mystore.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author Shree Computers
 *
 */
public class ShippingAddressPage extends BaseClass{
	
	Action act = new Action();

		@FindBy(xpath="(//li[@id='shipping']//div)[1]")
		WebElement shippAdrsPageHeadig;
		
		@FindBy(xpath="(//span)[18]")
		WebElement newAdressBtn;
		
		@FindBy(xpath="(//form[@id='co-shipping-form']//div//div//div[1])[1]")
		WebElement firstNameTextBox ;
		
		@FindBy(xpath="(//div[@id='shipping-new-address-form']//div)[2]")
		WebElement firstNameTxtBoxPopUp;
		
		@FindBy(xpath="(//form[@id='co-shipping-form']//div//div//div[1])[2]")
		WebElement lastNameTextBox;
		
		@FindBy(xpath="(//div[@id='shipping-new-address-form']//div)[4]")
		WebElement lastNameTxtBoxPopUp;
		
		@FindBy(xpath="(//form[@id='co-shipping-form']//div//div//div[1])[3]")
		WebElement companyTextBox;
		
		@FindBy(xpath="(//div[@id='shipping-new-address-form']//div)[6]")
		WebElement companyTxtBoxPopUp;
		
		@FindBy(xpath="(//form[@id='co-shipping-form']//div//div//div[1])[4]")
		WebElement strtAdrsTxtBox;
		
		@FindBy(xpath="(//div[@id='shipping-new-address-form']//div)[8]")
		WebElement strtAdrsTxtBoxPopUp;
		
		
		@FindBy(xpath="(//form[@id='co-shipping-form']//div//div//div[1])[8]")
		WebElement cityTxtBox;
		
		@FindBy(xpath="(//div[@id='shipping-new-address-form']//div)[15]")
		WebElement cityTxtBoxPopUp;
		
		@FindBy(xpath="(//form[@id='co-shipping-form']//div//div//div[1])[9]")
		WebElement stateDropDownWE;
		
		@FindBy(xpath="(//div[@id='shipping-new-address-form']//div)[17]")
		WebElement stateDropDownPopUp;
		
		
		@FindBy(xpath="(//form[@id='co-shipping-form']//div//div//div[1])[11]")
		WebElement postalCodeTxtBox;
		
		@FindBy(xpath="(//div[@id='shipping-new-address-form']//div)[21]")
		WebElement  postalCodeTxtBoxPopUp;
		
		@FindBy(xpath="(//form[@id='co-shipping-form']//div//div//div[1])[12]")
		WebElement countryDropDownWE;
		
		@FindBy(xpath="(//div[@id='shipping-new-address-form']//div)[23]")
		WebElement countryDropDownPopUp;
		
		@FindBy(xpath="(//form[@id='co-shipping-form']//div//div//div[1])[13]")
		WebElement phnNumTxtBox;
		
		@FindBy(xpath="(//div[@id='shipping-new-address-form']//div)[25]")
		WebElement phnNumTxtBoxPopUp;
		
		@FindBy(xpath="//button[@data-role='action']//span[contains(text(),'Cancel')]")
		WebElement canclBtnPopUp;
		
		
		@FindBy(xpath="//button[@class='action action-select-shipping-item']")
		WebElement shipHere;
		
		@FindBy(xpath="//footer//button[1]")
		WebElement shipHereBtnPopUp;
		
		@FindBy(xpath="//input[@value='flatrate_flatrate']")
		WebElement fltRateRadioBtn;
		
		@FindBy(xpath="//input[@value='tablerate_bestway']")
		WebElement bstWayradioBtn;
		
		@FindBy(xpath="//div[@id='shipping-method-buttons-container']//div")
		WebElement nxtBtn;
		
		
		@FindBy(xpath="//input[@id='shipping-save-in-address-book']")
		WebElement saveAdressCheckBoxPopUp;
		
		public ShippingAddressPage()
		{
			PageFactory.initElements(getDriver(), this);
		}
		
		public void validateShippingAdressPage()
		{
			String ExpectedHeadingTxt = "Shipping Address";
			String shippingAdressHeadTxt = shippAdrsPageHeadig.getText();
			Assert.assertEquals(shippingAdressHeadTxt, ExpectedHeadingTxt);
//			return act.isDisplayed(driver, shippAdrsPageHeadig);
		}
		
		public ReviewAndPaymentPage createNewAdressIfNotLogin(String firstName,String lastName,String company,
				String street,String city,String stateDropDown,String postal,String countryDropDown,String phone)
		{
			
//			act.click(driver, firstNameTextBox);
			act.type(firstNameTextBox, firstName);
			act.type(lastNameTextBox, lastName);
			act.type(companyTextBox, company);
			act.type(strtAdrsTxtBox, street);
			act.type(cityTxtBox, city);
			act.click(getDriver(), stateDropDownWE);
			act.selectByVisibleText(stateDropDown, stateDropDownWE);
			act.type(postalCodeTxtBox, postal);
			act.click(getDriver(), countryDropDownWE);
			act.selectByVisibleText(countryDropDown, countryDropDownWE);
			act.type(phnNumTxtBox, phone);
			act.click(getDriver(), fltRateRadioBtn);
//			act.click(driver, nxtBtn);
			return new ReviewAndPaymentPage();
			
		}
		
		public ReviewAndPaymentPage fillShippingAdressFormPopUpIfLoginToAddNewAdress(String fsName,String lsName,String cmnNm,String stAdrs,String city,String stateDpVal,String postCode,String cntry,String phnNumber) throws InterruptedException
		{
			Thread.sleep(5000);
			act.click(getDriver(), newAdressBtn);
			act.type(firstNameTxtBoxPopUp, fsName);
			act.type(lastNameTxtBoxPopUp, lsName);
			act.type(companyTxtBoxPopUp, cmnNm);
			act.type(strtAdrsTxtBoxPopUp, stAdrs);
			act.type(cityTxtBoxPopUp, city);
			act.click(getDriver(), stateDropDownPopUp);
			act.selectByVisibleText(stateDpVal, stateDropDownPopUp);
			act.type(postalCodeTxtBoxPopUp, postCode);
			act.click(getDriver(), countryDropDownPopUp);
			act.selectByVisibleText(cntry, countryDropDownPopUp);
			act.type(phnNumTxtBoxPopUp, phnNumber);
			act.click(getDriver(), saveAdressCheckBoxPopUp);
			act.click(getDriver(), shipHereBtnPopUp);
			act.click(getDriver(), nxtBtn);
			return new ReviewAndPaymentPage();
		}
		
		public ReviewAndPaymentPage clickOnNextBtn()
		{
			act.click(getDriver(), nxtBtn);
			return new  ReviewAndPaymentPage();
		}
		
		public ReviewAndPaymentPage clickOnBestWayShipMethod()
		{
			act.click(getDriver(), bstWayradioBtn);
			act.click(getDriver(), nxtBtn);
			return new  ReviewAndPaymentPage();
		}
		
		public ReviewAndPaymentPage clickOnFlatRateShipMethod()
		{
			act.click(getDriver(), fltRateRadioBtn);
			act.click(getDriver(), nxtBtn);
			return new  ReviewAndPaymentPage();
		}
}
