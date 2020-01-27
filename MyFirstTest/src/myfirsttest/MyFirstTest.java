/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirsttest;

import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;


public class MyFirstTest {

    /**
     * @param args the command line arguments
     */
 
  
  
  public static void main(String[] args){
     /*
     WebDriver driver = null;
     pages.LoginPage login;
     login= new LoginPage(driver);
     driver=login.chromeDriverConnection();
     login.visit("https://noprd-jit-toms.temu.com.uy:7002/");
     login.Nav();
     login.signIn();
     */
     
     
  }
 
    
// TODO code application logic here
// Aquí inicializamos el controlador web de Chrome
  //WebDriverManager.chromedriver().setup();

  //WebDriver chromedriver= new ChromeDriver();
 
  //chromeDriver.get("http://www.google.com");
   //public WebDriver chromedriver; 
   //ChromeOptions options = new ChromeOptions(); 
   //options.addArguments("-incognito"); 
  // DesiredCapabilities capabilities = DesiredCapabilities.chrome(); 
   //capabilities.setCapability(ChromeOptions.CAPABILITY, options); 
  // WebDriver driver=new ChromeDriver(capabilities); 
  
   
    
    // WebDriverWait wait = new WebDriverWait(driver,20);
     
   // driver.get("https://noprd-jit-toms.temu.com.uy:7002/");
    // driver.findElement(By.xpath("//*[@id=\"details-button\"]")).click();
   // driver.findElement(By.xpath("//*[@id=\"proceed-link\"]")).click();
   // driver.manage().window().setSize(new Dimension(1187, 956));
    
   // driver.findElement(By.linkText("Inicie sesión como usuario de NT")).click();
   // WebElement user = driver.findElement(By.xpath("//*[@id=\"userNameInput\"]"));
   // user.sendKeys("temu\\seolivera");
   // WebElement passw = driver.findElement(By.xpath("//*[@id=\"passwordInput\"]"));
   // passw.sendKeys("mobistar.11");
    
    //driver.findElement(By.xpath("//*[@id=\"submitButton\"]")).click(); // Boton login OK
    
    
    //driver.findElement(By.xpath("//*[@id=\"menuItem_0\"]/ul/li[1]/a/span")).click();
    //driver.get("https://noprd-jit-toms.temu.com.uy:7002/ncobject.jsp?id=9155882510113704246");
    
   // driver.findElement(By.linkText("Órdenes de Venta")).click();
   // WebElement esperaNuevaOrden;//espera explicita
   // esperaNuevaOrden= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/div/div[1]/div/div/div/div/div[1]/button")));
   // esperaNuevaOrden.click();//Nueva orden de Venta
   // WebElement esperaCanal;//espera explicita
   // esperaCanal=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[34]/div/div/div[2]/div/div[2]/table/tbody/tr[2]/td/div/form/table/tbody/tr/td/table/tbody/tr[2]/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/div/i")));
 //  esperaCanal.click();//Canal de Distribucion
  //  list.Listado();
     
//driver.findElement(By.xpath("//*[@id=\"nc_refsel_list\"]/div[2]/div[1]")).click();//Seleccionar Canal de distribucion
     //driver.findElement(By.xpath("//*[@id=\"nc_refsel_list\"]/div[2]/div[1]")).click();
     // driver.findElement(By.cssSelector(".refsel_highlight > .refsel_name")).click();
     //driver.findElement(By.cssSelector("div:nth-child(3) > .nc-toolbars-bottom .nc-toolbar-cell:nth-child(1) > .TableCtrl-button")).click();
   

 
  
 
   //public String Listado(){
     // WebElement canalD = driver.findElement(canalDistribucion);
    //  WebElement elementoAE= driver.findElement(elemntoSAgenteEsp);
  // List<WebElement>elemntcanaldistribucion= canalD.findElements(By.xpath("//*[@id=\"nc_refsel_list\"]/div[2]"));
    // for(int i=0;i<elemntcanaldistribucion.size();i++){
     // if(elemntcanaldistribucion.get(i)== canalD ) {
     //     elemntcanaldistribucion.get(i).click();
     // }
      
    // } 
   //for(int i=0;i<elemntcanaldistribucion.size();i++){
     //  if(elemntcanaldistribucion.get(i).isSelected())
       
        //  elementoAE=elemntcanaldistribucion.get(i);   
 //  }
   // String ele=elementoAE.toString();
  // return ele;
  // }
 // public String Listado(){
   // WebElement canalD = driver.findElement(canalDistribucion);
   // WebElement elementoAE= driver.findElement(elemntoSAgenteEsp); 
  //  List<WebElement>elemntcanaldistribucion= canalD.findElements(By.xpath("//*[@id=\"nc_refsel_list\"]/div[2]"));  
  // elemntcanaldistribucion.get(0);
 // }
}
           
 
    

