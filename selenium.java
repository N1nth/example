djhdhjdsjdsjdsdsjdjjdjsdsdjkjsdcsdc//----------------- Основные команды (l 40) ----------------------//

driver.get("https://yandex.ru/");
driver.navigate().to("https://google.com"); //открыть сайт в браузере

driver.navigate().back(); //вернуться на предыдущую страницу
driver.navigate().forward(); //вернуться на страницу вперед
driver.navigate().refresh(); //обновить страницу
driver.quit(); //завершить работу драйвера (закрыть браузер)

driver.manage().window().maximize(); //открыть браузер на весь экран
driver.manage().window().setSize(new Dimension(500, 500)); //задать размер браузера

System.out.println("Title: " + driver.getTitle()); //получить текст title страницы
System.out.println("URL: " + driver.getCurrentUrl()); //получить ссылку страницы



//----------------- Ожидания (l 41, 50) ----------------------//

//установить неявное ожидание в 10 секунд
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


//установить явное ожидание (+ еще другие условия)
WebDriverWait wait = new WebDriverWait(driver, 5);
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("_")));



//----------------- Поиск веб-элементов (l 42) -------------------//

WebElement link = driver.findElement(By.linkText("Почта")); //поиск элемента по тексту
WebElement link2= driver.findElement(By.partialLinkText("Завести")); //поиск эдемента по части текста
WebElement searchField = driver.findElement(By.name("text")); //поиск эелемента по ее имени
WebElement searchButton = driver.findElement(By.className("home-logo")); //поиск эелемента по имени класса
WebElement span = driver.findElement(By.id("wd-wrapper-_weather")); //поиск эелемента по id
WebElement logo = driver.findElement(By.cssSelector("wrapper")); //поиск по css-селектору
WebElement logo = driver.findElement(By.xpath("//div[@role='navigation']/a[@data-id='video']"));



//----------------- Работа с кнопками (l 43) -------------------//

driver.findElement(By.xpath("//input[@id='Button']")).click(); //нажать на кнопку
driver.findElement(By.xpath("//input[@id='Button']")).submit(); //если у элемента есть type = "submit"

button.getText() //получить текст кнопки



//------------- Работа с текстовыми полями (l 44) --------------//

driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Selenium"); //ввод текста "Selenium"

//вывести на экран значение, введенное в поле
System.out.println(driver.findElement(By.xpath("//div[@id='searchText']/input")).getAttribute("value"));

driver.findElement(By.xpath("//div[@id='searchText']/input")).clear(); //очистить текстовое поле



//------------- Работа со ссылками (l 45) --------------//

//найти ссылку - вывести текст ссылки на экран - перейти по ссылке
WebElement link = driver.findElement(By.xpath("//li[@id='n-browse']/a"));
System.out.println(link.getText());
link.click();



//------------- Работа с чекбоксами и радио-кнопками (l 46) --------------//

driver.findElement(By.xpath("_")).click(); //выделить чекбокс/радио-кнопку
driver.findElement(By.xpath("_")).isSelected(); // проверить, выделен ли чекбокс/радио-кнопка



//------------- Работа с выпадающими списками (l 47) --------------//

//Сначала кликаем на сам список - далее на конкретное значение из списка
driver.findElement(By.xpath("//div[@id = 'Gender']//div[@title = 'Пол']")).click();
driver.findElement(By.xpath("//div[text()='Женский']/parent::div[@role = 'option']")).click();



//------------- Поиск списка эелементов (l 48) --------------//

//получили список эелементов и тут же сохраняем в лист
//МЕТОД findElements ВОЗВРАЩАЕТ ЛИСТ
List<WebElement> checkboxes = driver.findElements(By.xpath("__"));

checkboxes.get(1).click(); //возвращаем второй элемент
checkboxes.size //размер списка


//------------- Работа с таблицами (l 49) --------------//



//------------- Выполнение сложных действий (l 51) --------------//

WebElement link = driver.findElement(By.xpath(...));
WebElement element = driver.findElement(By.xpath(...));

Actions actions = new Actions(driver);

actions.moveToElement(link).build().perform(); //наведение курсора на эелемент "линк"
actions.dragAndDrop(element, link).build().perform(); //перенос элемента "элемент" в элемент "линк"
actions.clickAndHold(element).moveToElement(link).release().build().perform(); //нажатие и удерживание элемента "элемент"
// и в это же время наведение курсора на элемент "линк" и "release" - отпустить
actions.doubleClick(element); //двойной клик
actions.contextClick(element); // нажатие правой кнопкой мышкин на элемент



//------------- Выполнение javascript (l 52) --------------//

JavascriptExecutor jse = (JavascriptExecutor)driver;
jse.executeScript("alert('HelloWord');");


//можно, например, скролить страницу вниз и т.п. использование js
jse.executeScript("window.scrollBy(0, 1000), objects:'' "); //вниз
jse.executeScript("window.scrollBy(0, -1000), objects:'' "); //вверх



//------------- Работа с Alert (l 53) --------------//

driver.get("http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html");
driver.findElement(By.xpath("//a[text()='jdk-8u121-windows-x64.exe']")).click();
	try {
	    Thread.sleep(3000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

	driver.switchTo().alert().accept();
	

	driver.get("http://google.com");
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("confirm('Are you sure?');");
	try {
	    Thread.sleep(3000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	driver.switchTo().alert().dismiss();



//------------- Работа с Alert (l 54) --------------//

driver.get("http://signup.live.com");
String mainTab = driver.getWindowHandle();
driver.findElement(By.xpath("//a[text()='соглашения об использовании служб Майкрософт']")).click();
for (String tab : driver.getWindowHandles()){
    driver.switchTo().window(tab);
}
driver.findElement(By.xpath("(//span[text()='Часто задаваемые вопросы']/parent::a)[2]")).click();
driver.switchTo().window(mainTab);
driver.findElement(By.xpath(".//*[@id='LastName']")).sendKeys("test");



//------------- Работа со вкладками (l 55) --------------//

driver.get("http://signup.live.com");
String mainTab = driver.getWindowHandle();
driver.findElement(By.xpath("//a[text()='соглашения об использовании служб Майкрософт']")).click();
for (String tab : driver.getWindowHandles()){
    driver.switchTo().window(tab);
}
driver.findElement(By.xpath("(//span[text()='Часто задаваемые вопросы']/parent::a)[2]")).click();
driver.switchTo().window(mainTab);
driver.findElement(By.xpath(".//*[@id='LastName']")).sendKeys("TEST TEXT");



//------------- Работа со вкладками (l 56) --------------//

 //Позволяет узнать доступен или нет элемент (кнопка/баттан)
driver.get("http://www.w3schools.com/jsref/prop_pushbutton_disabled.asp");
WebElement button1 = driver.findElement(By.xpath("//button[text()='My Button']"));
WebElement button2 = driver.findElement(By.xpath("//a[@title='Home']"));
System.out.println(button1.isEnabled());
System.out.println(button2.isEnabled());
	if (button1.isEnabled()) button1.click();
	if (button2.isEnabled()) button2.click();

 //Позволяет узнать выделен элемент или нет (радиобатоны и чекбоксы)
driver.get("http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html");
WebElement rb1 = driver.findElement(By.xpath("(//input[@name='agreementjdk-8u121-oth-JPR'])[1]"));
WebElement rb2 = driver.findElement(By.xpath("(//input[@name='agreementjdk-8u121-oth-JPR'])[2]"));
System.out.println("Radio button 2 selected: " + rb2.isSelected());
	if (!rb1.isSelected()) rb1.click();

 //Позволяет узнать виден ли данный элемент на странице
driver.get("http://ebay.com");
WebElement link1 = driver.findElement(By.xpath("//a[contains(text(), 'Бытовая электроника')]"));
WebElement link2 = driver.findElement(By.xpath("//a[text()='Подписки']"));
System.out.println(link1.isDisplayed());
System.out.println(link2.isDisplayed());
	if (link1.isDisplayed()) link1.click();
		else link2.click();



//------------- Проверка наличия элемента на странице (l 57) --------------//

driver.get("http://github.com");
    if (driver.findElements(By.xpath("//a[text()='Log in']")).size() > 0){
    	System.out.println("Such element is presented");
    }   
    	else System.out.println("Cannot find such element");



//------------- Имитация нажатия клавиш (l 58) --------------//

driver.get("http://en.wikipedia.org/");
WebElement searchInput = driver.findElement(By.xpath("//input[@id=\"searchInput\"]"));

String select = Keys.chord(Keys.CONTROL, "a"); //сочетание клавиш
String cut = Keys.chord(Keys.CONTROL, "x");
String paste = Keys.chord(Keys.CONTROL, "v");

searchInput.sendKeys("test text");
searchInput.sendKeys(select);
searchInput.sendKeys(cut);
searchInput.sendKeys(paste);
searchInput.sendKeys(Keys.ENTER); //нажатие клавиши enter



//------------- Имитация нажатия клавиш (l 59) --------------//

Date dateNow = new Date();
SimpleDateFormat format = new SimpleDateFormat("hh_mm_ss");
String fileName = format.format(dateNow) + ".png";


File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
try {
    FileUtils.copyFile(screenshot, new File("C:\\Screenshots\\" + fileName));
} catch (IOException e) {
    e.printStackTrace();
}



//------------- Имитация нажатия клавиш (l 60) --------------//

driver.get("http://images.google.com");

driver.findElement(By.xpath("//a[@aria-label=\"Поиск по картинке\"]")).click();
driver.findElement(By.xpath("//a[text()='Загрузить файл']")).click();

driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\test\\pic.jpg");






