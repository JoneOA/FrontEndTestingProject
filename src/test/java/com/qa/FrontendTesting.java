package com.qa;

        import org.junit.After;
        import org.junit.Before;
        import org.junit.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;

        import static junit.framework.TestCase.assertFalse;
        import static junit.framework.TestCase.assertTrue;


public class FrontendTesting {

    private ChromeDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Desktop\\seleniumtesting\\src\\main\\java\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.close();
    }


    public void home_clickAddPage() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("//*[@id=\'buttons\']"));
        button.click();
    }

    public void add_inputPokemonId()  throws InterruptedException {
        WebElement inputField = driver.findElementById("idInput");
        Thread.sleep(100);
        inputField.sendKeys("45");
        Thread.sleep(500);
    }

    public void add_submitId() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("//*[@id=\'button\']"));
        Thread.sleep(100);
        button.click();
        Thread.sleep(500);
    }

    public void add_confirmAdd() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("/html/body/div/div[3]/button"));
        Thread.sleep(100);
        button.click();
        Thread.sleep(500);
    }

    public void add_backToHome() throws InterruptedException {
        WebElement button = driver.findElementById("navButton");
        Thread.sleep(100);
        button.click();
        Thread.sleep(500);
    }


    @Test
    public void addTest() throws InterruptedException {
        driver.get("http://35.246.32.85");
        Thread.sleep(2000);

        home_clickAddPage();
        Thread.sleep(500);

        WebElement outputDiv = driver.findElementById("pokeDiv");
        assertFalse(outputDiv.isDisplayed());

        add_inputPokemonId();
        add_submitId();

        assertTrue(outputDiv.isDisplayed());
        Thread.sleep(2000);

        //Cant check if the add to inv function works, selenium doesnt deal with window alerts
    }


    public void home_clickFindButton() throws InterruptedException {
            WebElement button = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/button"));
            button.click();
    }

    public void find_inputPokemonId()  throws InterruptedException {
        WebElement inputField = driver.findElementById("idInput");
        Thread.sleep(100);
        inputField.sendKeys("45");
        Thread.sleep(500);
    }

    public void find_submitId() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/div[3]/button"));
        Thread.sleep(100);
        button.click();
        Thread.sleep(500);
    }

    public void find_openDeleteSin() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/button[2]"));
        Thread.sleep(100);
        button.click();
        Thread.sleep(500);
    }

    public void find_closeDeleteSin() throws InterruptedException{
        WebElement button = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/div[2]/button[1]"));
        Thread.sleep(100);
        button.click();
        Thread.sleep(500);
    }

    public void find_openUpdateSin() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/button[1]"));
        Thread.sleep(100);
        button.click();
        Thread.sleep(500);
    }

    public void find_closeUpdateSin() throws InterruptedException{
        WebElement button = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/button[1]"));
        Thread.sleep(100);
        button.click();
        Thread.sleep(500);
    }

    public void find_showAll() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/div[4]/button"));
        Thread.sleep(100);
        button.click();
        Thread.sleep(500);
    }

    public void find_openUpdateTab() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/table/tbody/tr[1]/td[10]/button[1]"));
        Thread.sleep(100);
        button.click();
        Thread.sleep(500);
    }

    public void find_closeUpdateTab() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/button[1]"));
        Thread.sleep(100);
        button.click();
        Thread.sleep(500);
    }

    public void find_openDeleteTab() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/table/tbody/tr[1]/td[10]/button[2]"));
        Thread.sleep(100);
        button.click();
        Thread.sleep(500);
    }

    public void find_closeDeleteTab() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div[2]/button[1]"));
        Thread.sleep(100);
        button.click();
        Thread.sleep(500);
    }

    @Test
    public void findTest() throws InterruptedException {
        driver.get("http://35.246.32.85");
        Thread.sleep(2000);

        home_clickFindButton();
        Thread.sleep((500));
        WebElement outputDiv = driver.findElementById("pokeDiv");
        WebElement outputTable = driver.findElementById("tableDiv");
        WebElement sinUpdateModal = driver.findElementById("updateSingleInvModal");
        WebElement sinDeleteModal = driver.findElementById("DeleteSingleFromInv");
        WebElement TabUpdateModal = driver.findElementById("updateInvModal");
        WebElement TabDeleteModal = driver.findElementById("DeleteFromInv");

        assertFalse(outputDiv.isDisplayed());
        assertFalse(outputTable.isDisplayed());
        assertFalse(sinUpdateModal.isDisplayed());
        assertFalse(sinDeleteModal.isDisplayed());
        assertFalse(TabUpdateModal.isDisplayed());
        assertFalse(TabDeleteModal.isDisplayed());

        find_inputPokemonId();
        Thread.sleep(100);
        find_submitId();
        Thread.sleep(100);

        find_openDeleteSin();
        Thread.sleep(500);
        assertTrue(sinDeleteModal.isDisplayed());
        find_closeDeleteSin();
        Thread.sleep(100);

        find_openUpdateSin();
        Thread.sleep(500);
        assertTrue(sinUpdateModal.isDisplayed());
        find_closeUpdateSin();
        Thread.sleep(200);

        find_showAll();

        find_openUpdateTab();
        Thread.sleep(500);
        assertTrue(TabUpdateModal.isDisplayed());
        find_closeUpdateTab();
        Thread.sleep(200);

        find_openDeleteTab();
        Thread.sleep(500);
        assertTrue(TabDeleteModal.isDisplayed());
        find_closeDeleteTab();
        Thread.sleep(200);

        assertTrue(outputTable.isDisplayed());
        assertTrue(outputDiv.isDisplayed());
    }

    public void home_clickEditButton() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/button"));
        button.click();
    }

    public void edit_inputPokemonId()  throws InterruptedException {
        WebElement inputField = driver.findElementById("idInputRepl");
        Thread.sleep(100);
        inputField.sendKeys("45");
        Thread.sleep(500);
    }

    public void edit_submitId() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/form/div[3]/button"));
        Thread.sleep(100);
        button.click();
        Thread.sleep(500);
    }

    public void edit_openInTeam() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div/form/div[1]/div/button"));
        Thread.sleep(100);
        button.click();
        Thread.sleep(500);
    }

    public void edit_selectInTeam() throws InterruptedException {
        WebElement button = driver.findElementById("1");
        Thread.sleep(100);
        button.click();
        Thread.sleep(500);
    }

    @Test
    public void editTest() throws InterruptedException {
        driver.get("http://35.246.32.85");
        Thread.sleep(2000);

        home_clickEditButton();
        Thread.sleep(500);

        WebElement existingImg = driver.findElementById("pokemonPic1");
        WebElement replaceImg = driver.findElementById("pokemonPic2");

        edit_inputPokemonId();
        Thread.sleep(100);
        edit_submitId();
        Thread.sleep(500);
        assertTrue(replaceImg.isDisplayed());

        edit_openInTeam();
        Thread.sleep(100);
        edit_selectInTeam();
        Thread.sleep(500);
        assertTrue(existingImg.isDisplayed());
    }

    public void home_clickRemoveButton() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[4]/button"));
        button.click();
    }

    public void remove_openInTeam() throws InterruptedException{
        WebElement button = driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div/div/button"));
        Thread.sleep(100);
        button.click();
        Thread.sleep(500);
    }

    public void remove_selectInTeam() throws InterruptedException {
        WebElement button = driver.findElementById("1");
        Thread.sleep(100);
        button.click();
        Thread.sleep(500);
    }

    public void remove_closeModal() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[2]/button[1]"));
        Thread.sleep(100);
        button.click();
        Thread.sleep(500);
    }

    @Test
    public void removeTest() throws InterruptedException{
        driver.get("http://35.246.32.85");
        Thread.sleep(2000);

        home_clickRemoveButton();
        Thread.sleep(300);
        WebElement outputDiv = driver.findElementById("DeleteFromInv");

        remove_openInTeam();
        Thread.sleep(100);
        remove_selectInTeam();
        Thread.sleep(200);
        assertTrue(outputDiv.isDisplayed());

        remove_closeModal();
        Thread.sleep(200);
        assertFalse(outputDiv.isDisplayed());
    }


}
