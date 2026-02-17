## Selenium

An open source web-automation framework broken down into multiple extensions:

 - **Selenium IDE** - extension that allows for recording and playback of browser actions
 - **Selenium Grid** - allows for multiple and parallel tests
 - **Selenium Remote Control** - allows for a server-client relationship to control remote browsers from a single origin
 - **Selenium Web Driver** - facilitates a realtime browser that can communicate with your automated test code.

### Selenium Web Driver

The web driver acts as a layer between a browser instance and an automated testing suite via JSON. This allows for browser support (Chromium, Firefox, Safari) depending on the driver used, as well as language-agnostic suites.

The driver is able to mimic human actions such as mouse clicks, key presses, scrolling, and drag and drops. Further, it can hook up into CI/CD tools and various frameworks.

A general workflow looks like this:
 1. Create a web driver.
 2. Send a request to the web page via the driver.
 3. Select elements from the web page to interact with using **locator** functions such as by ID, text, class.
 4. Perform actions and await results.

### Page Object Model

A design pattern where helpers for locating elements are stored in a repository that is then imported where needed. Helps avoid code duplication, especially as sites evolve over time.
 - Within Selenium, generally expressed through annotations such as `@FindBy`.

### Selenium in Java

To use Selenium in Java, add the `selenium-java` dependency into your Maven's `pom.xml` file.

Then, import the following packages:

```Java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
```

Create your web driver like so:

```Java
WebDriver myDriver = new ChromeDriver();
```

And then load a page using the `.get` method of your web driver:

```Java
myDriver.get("https://www.selenium.dev/selenium/web/web-form.html");
```

If we want to navigate from this webpage, we can use the `navigate().to(url)` method as well.

We're also able to go forward and back using the `navigate().forward()` and `navigate().back()` methods respectively.

Note that this may take some time, and you'll want to wait for the page to load before moving on. This can be done through Selenium's implicit or explicit waits.

You may try something like this:

```Java
myDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
```

Reference: https://www.selenium.dev/documentation/webdriver/getting_started/first_script/

#### Selenium Locators

To work with elements in your web page, you need to select them using Selenium's built-in locators.

To get an element, use the `findElement` (find first element) or `findElements` (find all elements as a list) methods of your web driver.

To select, use the `By` class' static methods to serve as locators. In total, there are 8 different locators:
 1. `id` - the id of the element
 2. `className` - a class the element has
 3. `tagName` - the element's html tag
 4. `cssSelector` - a string that can act as a css selector for the desired element
 5. `name` - the name attribute of the element
 6. `linkText` - the text displayed of an anchor element (can be an alias like "Home Page")
 7. `partialLinkText` - partial matching of an anchor element
 8. `xpath` - an XML for the element. Example: `//tagName[@attribute='value']`

In sum, it would look like this:

```Java
WebElement myButton = myDriver.findElement(By.id("page-button"));
```

Reference: https://www.selenium.dev/documentation/webdriver/elements/locators/

#### Element Interactions

Lastly, we're able to interact with our elements using five different actions:

 1. `click()` - Clicks the center of the element if available. Can throw an exception if it's obscured.
 2. `sendKeys(string)` - Sends keyboard inputs (i.e. types out a string) to a `text` or `content-editable` field. Can throw an exception otherwise. 
 3. `clear()` - Resets the element back to its original state such as a form input. Throws an exception if the element isn't editable/resettable.
 4. `select` - Only for form select objects (create using `new Select(selectElement)`). Many different variants such as `selectByIndex`, `selectByVisibleText`, and `SelectByValue`.
 5. `submit()` - Can be called on any form element to submit the form. Not advisable for Selenium versions 4+ in favor of clicking the submit button of the form.

For our button, we could do something like:

```Java
myButton.click();
```

We can then get properties from our elements with various methods such as `getText()`, `getClass()`, or `getSize()`.

Reference: https://www.selenium.dev/documentation/webdriver/elements/interactions/ and https://www.selenium.dev/documentation/webdriver/support_features/select_lists/

### Testing with Selenium

Note that Selenium is NOT a test suite. Instead, it only serves to automate web interactions that we can then *use* within our tests. To actually perform tests with it, we combine it with a testing framework such as JUnit.

 - We can setup the webdriver in a `@beforeAll`
 - Tear it down in an `@afterAll`
 - Assert values from our elements' `getText()` and much more!