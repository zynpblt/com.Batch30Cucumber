package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.GMIBANKPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class GMIBANKStepDefinitions {

    GMIBANKPage gmiBankPage = new GMIBANKPage();

    @When("kullanici gmibank sayfasina gider")
    public void kullanici_gmibank_sayfasina_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("GMIBankUrl"));

    }

   @Then("sayfaya giris yapar")
    public void sayfaya_giris_yapar() {
        gmiBankPage.GMIBankLogin();

    }

    @Then("sayfaya giris yaptigini dogrular")
    public void sayfaya_giris_yaptigini_dogrular() {
        gmiBankPage.girisOnayWebElementi.isDisplayed();

    }

    @When("gmibank signout butonuna tikalar")
    public void gmibank_signout_butonuna_tikalar() {
        gmiBankPage.girisOnayWebElementi.click();
        gmiBankPage.signOutWebElementi.click();

    }

    @When("gmibank sayfasindan cikis yaptigini dogrular")
    public void gmibank_sayfasindan_cikis_yaptigini_dogrular() {
        //h2[normalize-space()='THANK YOU FOR USING US...']
        //html//div[@id='app-view-container']/div[1]//h2[.='THANK YOU FOR USING US...']
        //*[@id="app-view-container"]/div[1]/div/div/div/h2
        gmiBankPage.signOutOnayWebElementi.isDisplayed();
    }





    @Then("gmibank signin butonuna tiklar")
    public void gmibankSigninButonunaTiklar() {
        gmiBankPage.signInButonu.click();
    }

    @And("gmibank username kutusuna {string} yazar")
    public void gmibankUsernameKutusunaYazar(String arg0) {
        gmiBankPage.signInButonu.sendKeys("employedj2");
    }

    @And("gmibank password kutusuna {string} yazar")
    public void gmibankPasswordKutusunaYazar(String arg0) {
        gmiBankPage.gmiBankPasswordKutusu.sendKeys("5421587");
    }

    @And("gmibank signin butonuna basar")
    public void gmibankSigninButonunaBasar() {
        gmiBankPage.signInButonu.click();
    }

    @Then("gmibank giris yapilamadigini test eder")
    public void gmibankGirisYapilamadiginiTestEder() {
        Assert.assertTrue(gmiBankPage.hataliGirisWebElementi.isDisplayed());
    }

    @Then("kullanici gecerli username ve password girer")
    public void kullaniciGecerliUsernameVePasswordGirer() {
        gmiBankPage.gmibankUsernameKutusu.sendKeys(ConfigReader.getProperty("gmibankUsernameValid"));
        gmiBankPage.gmiBankPasswordKutusu.sendKeys(ConfigReader.getProperty("gmibankUPasswordValid"));
    }

    @Then("kullanici userIcona tiklar")
    public void kullaniciUserIconaTiklar() {
        gmiBankPage.girisOnayWebElementi.click();
    }

    @Then("kullanici user settings sayfasinda olmalidir")
    public void kullaniciUserSettingsSayfasindaOlmalidir() {
        gmiBankPage.userInfoWebElementi.click();
        String expectedUrl = "https://www.gmibank.com/account/settings";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        System.out.println(expectedUrl.equals(actualUrl) ? "PASS" : "FAIL");

    }

    @And("kullanici language dropdown da secenekleri gorur")
    public void kullaniciLanguageDropdownDaSecenekleriGorur() {
        Select select= new Select(gmiBankPage.languageDropDown);
        gmiBankPage.languageDropDown.click();
        List<WebElement> languageOptions=select.getOptions();
        System.out.println("languageOptions1 = "+languageOptions.get(0).getText());
        System.out.println("LanguageOptions2 ="+languageOptions.get(1).getText());

    }

    @Then("kullanici English ve Turkish den basaka dil seceneginin olmadigini dogrular")
    public void kullaniciEnglishVeTurkishDenBasakaDilSecenegininOlmadiginiDogrular() {
        Select select=new Select(gmiBankPage.languageDropDown);
        List<WebElement> languageOptions = select.getOptions();
        for (WebElement each:languageOptions) {
            boolean languages= each.getText().equals("Turkce") || each.getText().equals("English");
            Assert.assertTrue("user can only select English or Turkish",languages);
        }
    }

    @Then("kullanici My Opertions a tiklar")
    public void kullaniciMyOpertionsATiklar() {
        gmiBankPage.myOperationWebElementi.click();
    }

    @Then("kullanici Manage Customers i secer")
    public void kullaniciManageCustomersISecer() {
        gmiBankPage.manageCustomersWebElementi.click();
    }

    @And("kullanici Create a New Customer a tiklar")
    public void kullaniciCreateANewCustomerATiklar() {
    }

    @And("kullanici  {string} girer")
    public void kullaniciGirer(String ssn) {
        gmiBankPage.searcSSN.sendKeys(ConfigReader.getProperty("ssn"));
    }

    @And("kullanici Search button a tiklar")
    public void kullaniciSearchButtonATiklar() {
        gmiBankPage.searchButton.click();
    }

    @Then("kullanici fail message i gorur")
    public void kullaniciFailMessageIGorur() {
        Assert.assertTrue(gmiBankPage.failedMEssage.isDisplayed());
    }
}

