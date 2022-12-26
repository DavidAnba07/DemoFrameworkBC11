package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utils.BaseClass;

import java.util.List;

import static java.lang.Integer.parseInt;

public class TrenPage extends BaseClass {
    public TrenPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    By locatorTxtOrigen = By.xpath("//input[@placeholder='Origen']");
    By locatorTxtDestino = By.xpath("//input[@placeholder='Destino']");
    By locatorBtnViajeros = By.xpath("//span[contains(text(),'1 viajero')]");
    By locatorAumentarViajeros = By.xpath("//button[@aria-label='Aumentar el número de adultos']");
    By locatorReducirViajeros = By.xpath("//button[@aria-label='Reducir el número de adultos']");
    By locatorAgregarNinho = By.xpath("//span[contains(text(),'Añadir un niño')]");
    By locatorAgregarNinhoAdicional = By.xpath("//button[@aria-label='Aumentar el número de niños']");
    By locatorAgregarBebe11Meses = By.xpath("//li[contains(text(),'Bebé, 0-11 meses')]");
    By locatorAgregarNinho2Anios = By.xpath("//li[contains(text(),'2 años')]");
    By locatorBtnBuscar= By.xpath("//button[contains(text(),'Buscar')]");
    By locatorRBOrigen= By.xpath("//div[@role='listbox']/div/div[2]/button");
    By locatorMesSiguiente = By.xpath("//button[@aria-label=\"Next month\"]");
    By locatorFIda=By.xpath("//button[contains(text(),15)]");
    By locatorFVuelta= By.xpath("//button[contains(text(),30)]");
    By locatorSoloIda = By.xpath("//div[contains(text(),'Solo ida')]");
    By locatorPrimerPasaje = By.xpath("//section[@data-role='results']//following::span[1][@size=24]");

    //locators quién reserva

    By locatorNombre = By.xpath("//input[@name='name']");
    By locatorApellido = By.xpath("//input[@name='surname']");
    By locatorEmail = By.xpath("//input[@name='email' and @id = 'contact-email']");
    //By locatorCodigoArea = By.xpath("//div[contains(text(),'+34')]");
    By locatorCodigoArea= By.xpath("//div[@class='arrow down']");
    By locatorCodigoAreaArg = By.xpath("//li[@data-country-code='ar']");
    By locatorNumero = By.xpath("//input[@name='phone']");
    By locatorSra = By.xpath("//input[@value='FEMALE']");
    By locatorDia = By.xpath("//input[@placeholder='DD']");
    By locatorMes = By.xpath("//select[@aria-label='Selecciona el mes']");
    By locatorAnho = By.xpath("//input[@placeholder='AAAA']");
    //By locatorTipoDoc = By.xpath("//div[@data-test='document-type-input']");
    //By locatorTipoDoc = By.xpath("//select[@aria-label='groups.1.travellers.1.documentType']");
    //By locatorPA = By.xpath("//option[@value='PA']");
    By locatorTipoDocPa= By.xpath("//div[@class='traveller-info__documents-wrapper']//descendant-or-self::input");
    By locatorNumeroDoc = By.xpath("//input[@name='groups.1.travellers.1.documentNumber']");
    //By locatorCheckNoGracias = By.xpath("//div[@class='radio']//child::check");
    By locatorCheckNoGracias = By.xpath("//label[@class='insurance__noThanks-radio-label']//child:: span[@class='check']");
    By locatorPaquetePremium = By.xpath("//b[contains(text(),'Paquete de Servicio Premium')]");
    By locatorBtnSiguiente = By.xpath("//button[contains(text(),'Siguiente')]");


    public int contadorPasajerosAdultos(){

        WebElement locatorContadorPasajerosAdultos = buscarElementoWeb(By.xpath("//div[contains(text(),'Adultos')]//parent::div//parent::div//following-sibling::span"));
        int totalPasajerosAdultos= Integer.parseInt(locatorContadorPasajerosAdultos.getText());
        System.out.println(totalPasajerosAdultos);
        return totalPasajerosAdultos;
    }

    public void completarBusquedaOrigenDestino(String origen, String destino) {
        esperarXSegundos(2000);
        agregarTexto(esperarAElementoWeb(locatorTxtOrigen), origen);
        esperarXSegundos(2000);
        click(locatorRBOrigen);
        esperarXSegundos(2000);
        agregarTexto(esperarAElementoWeb(locatorTxtDestino), destino);
        esperarXSegundos(4000);
        click(locatorRBOrigen);
        esperarXSegundos(5000);
    }
    public void completarBusquedaMes() {
        click(locatorMesSiguiente);
        esperarXSegundos(1000);
        click(locatorMesSiguiente);
        esperarXSegundos(1000);
        click(locatorFIda);
        esperarXSegundos(2000);
        click(locatorFVuelta);
        esperarXSegundos(3000);
    }

    public void aumentarViajero(){
        esperarXSegundos(5000);
        click(locatorAumentarViajeros);
    }

    public void reducirViajero() {
        click(locatorBtnViajeros);
        esperarXSegundos(1000);
        click(locatorReducirViajeros);


    }
    //pendiente
    public void agregarNihno() {
        esperarXSegundos(2000);
        click(locatorAgregarNinho);
        esperarXSegundos(2000);
        click(locatorAgregarNinho2Anios);
    //    ScrollElementoWeb(locatorAgregarNinhoAdicional);
    //    for(int i=1;i<=cantidadNinhos;i+=1)
    //        System.out.println(i);
    //        click(locatorAgregarNinhoAdicional);
    //        esperarXSegundos(1000);
    //        click(locatorAgregarNinho2Anios);
    //        esperarXSegundos(1000);

    }

    public void clickBuscar () {
        click(esperarAElementoWeb(locatorBtnBuscar));
        esperarXSegundos(3000);
    }

    public String getUrl1(){
        String url1 = driver.getCurrentUrl();
        return url1;
    }

    public String getUrl2(){
        String url2 = driver.getCurrentUrl();
        return url2;
    }

    public int obtenerTotalPasajerosResultadoBusqueda(){
        WebElement locatorContadorPasajeros = buscarElementoWeb(By.xpath("//div[@class=\"search-summary__passsengers\"]//following-sibling::span"));
        String numeroPasajeros = locatorContadorPasajeros.getText();
        int valor= Integer.parseInt(numeroPasajeros);
        return valor;
    }

    public void boletoSoloIda(){
        click(locatorSoloIda);
    }

    public void completarFormularioSoloIda(){
        click(locatorMesSiguiente);
        esperarXSegundos(1000);
        click(locatorMesSiguiente);
        esperarXSegundos(1000);
        click(locatorFIda);
        esperarXSegundos(2000);
    }

    public void presionarTab(){
        WebElement element = driver.findElement(By.xpath("//div[@class='traveller-info__documents-wrapper']//descendant-or-self::input"));
        element.sendKeys(Keys.TAB);

    }

    public void clickPrimerPasaje(){
        click(locatorPrimerPasaje);
    }

    public void seleccionarCodigoArea() {
        esperarXSegundos(2000);
        WebElement element = driver.findElement(By.xpath("//div[@class='arrow down']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", element);
    }

    public void seleccionarMes(){
        driver.findElement(By.xpath("//select/option[@value='10']")).click();

    }
    public void seleccionarSra(){
        WebElement element = driver.findElement(By.xpath("//input[@value='FEMALE']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", element);

    }
    public void seleccionarDroplist(){
        esperarXSegundos(3000);
        WebElement element = driver.findElement(By.xpath("//div[@data-test='document-type-input']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='PA'", element);
    }

    public void formularioQuienReserva(String nombre, String apellido, String email, String numero, String DD, String anho) {
        agregarTexto(esperarAElementoWeb(locatorNombre),nombre);
        esperarXSegundos(1000);
        ScrollElementoWeb(locatorApellido);
        agregarTexto(esperarAElementoWeb(locatorApellido),apellido);
        esperarXSegundos(1000);
        agregarTexto(esperarAElementoWeb(locatorEmail),email);
        esperarXSegundos(2000);
        //click(locatorCodigoArea);
        seleccionarCodigoArea();
        esperarXSegundos(2000);
        ScrollElementoWeb(locatorCodigoAreaArg);
        click(locatorCodigoAreaArg);
        agregarTexto(esperarAElementoWeb(locatorNumero),numero);
        esperarXSegundos(1000);
        ScrollElementoWeb(locatorSra);
        //click(locatorSra);
        seleccionarSra();
        esperarXSegundos(1000);
        agregarTexto(esperarAElementoWeb(locatorDia),DD);
        esperarXSegundos(1000);
        click(locatorMes);
        seleccionarMes();
        esperarXSegundos(1000);
        agregarTexto(esperarAElementoWeb(locatorAnho),anho);
        esperarXSegundos(1000);
        agregarTexto(locatorTipoDocPa,"Pasaporte");
        presionarTab();
        agregarTexto(locatorNumeroDoc,"1234567");
        esperarXSegundos(2000);
        ScrollElementoWeb(locatorNumeroDoc);
        ScrollElementoWeb(locatorPaquetePremium);
        click(locatorCheckNoGracias);
        esperarXSegundos(1000);
        click(locatorBtnSiguiente);


    }


}


