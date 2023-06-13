package com.test.SpruceEats.Tests;

import com.test.SpruceEats.Pages.FishFood_Home_Page;
import com.test.SpruceEats.Pages.SeaFood_Page;
import com.test.openchart.pages.Home_Page;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FishFood_Test extends  FishFoodTestBase{
    @Test
    public void FishfoodTest() throws InterruptedException {
        FishFood_Home_Page fishFoodHomePage= new FishFood_Home_Page(driver);
        fishFoodHomePage.clickIngredients(driver);
        SeaFood_Page seaFoodPage= new SeaFood_Page(driver);
        seaFoodPage.seafoodPageValidation("6-Ingredient Roasted Salmon Fillets");


    }


}
