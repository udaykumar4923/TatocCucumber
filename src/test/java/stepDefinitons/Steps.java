package stepDefinitons;


import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Steps {
	public static WebDriver driver;
	public static String tokenid;
	public static ArrayList windowslist;
	
	@Given("^user is on tatoc course url$")
	public void user_is_on_tatoc_course_url() throws Throwable {
	    driver = new ChromeDriver();
	    driver.get("http://10.0.1.86/tatoc");
	}

	@When("^user clicks on Basic Course Link$")
	public void user_clicks_on_Basic_Course_Link() throws Throwable {
		driver.findElement(By.linkText("Basic Course")).click();
	}

	@Then("^browser navigates to gridgate page$")
	public void browser_navigates_to_gridgate_page() throws Throwable {
	    System.out.println(driver.getCurrentUrl());
	}

	@Given("^user is on gridgate page$")
	public void user_is_on_gridgate_page() throws Throwable {
	    System.out.println("user is on gridgate page");
	}

	@When("^user clicks on green gridbox$")
	public void user_clicks_on_green_gridbox() throws Throwable {
		driver.findElement(By.className("greenbox")).click();
	}

	@Then("^browser navigates to frame and dungeon page$")
	public void browser_navigates_to_frame_and_dungeon_page() throws Throwable {
	    System.out.println(driver.getCurrentUrl());
	}

	@Given("^user is on frame and dungeon page$")
	public void user_is_on_frame_and_dungeon_page() throws Throwable {
	    System.out.println("user is on frame and dungeon page");
	}

	@When("^user clicks on repaint color button color of second box changes$")
	public void user_clicks_on_repaint_color_button_color_of_box_changes() throws Throwable {
		driver.switchTo().frame(driver.findElement(By.id("main")));
		String firstcolor = driver.findElement(By.id("answer")).getAttribute("class");
		driver.switchTo().frame(driver.findElement(By.id("child")));
		String secondcolor = driver.findElement(By.id("answer")).getAttribute("class");
		driver.switchTo().defaultContent();
		while(firstcolor.equals(secondcolor) != true) {
			driver.switchTo().frame(driver.findElement(By.id("main")));
			driver.findElement(By.linkText("Repaint Box 2")).click();
			driver.switchTo().frame(driver.findElement(By.id("child")));
			secondcolor = driver.findElement(By.id("answer")).getAttribute("class");
			driver.switchTo().defaultContent();
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.id("main")));
	}

	@When("^user clicks on proceed button$")
	public void user_clicks_on_proceed_button() throws Throwable {
		driver.findElement(By.linkText("Proceed")).click();
	}

	@Then("^browser navigates to DragAndDrop page\\.$")
	public void browser_navigates_to_DragAndDrop_page() throws Throwable {
	    System.out.println(driver.getCurrentUrl());
	}

	@Given("^user is on draganddrop page$")
	public void user_is_on_dragandrop_page() throws Throwable {
	    System.out.println("user is on drag and drop page");
	}

	@When("^user completes DragAndArop action$")
	public void user_completes_DragAndArop_action() throws Throwable {
		WebElement dragfrom = driver.findElement(By.id("dragbox"));
		WebElement dropto = driver.findElement(By.id("dropbox"));
		Actions act = new Actions(driver);
		act.dragAndDrop(dragfrom,dropto).build().perform();
	}

	@When("^click on proceed link$")
	public void click_on_proceed_link() throws Throwable {
		driver.findElement(By.linkText("Proceed")).click();
	}

	@Then("^browser navigates to Token Generation button$")
	public void browser_navigates_to_Token_Generation_button() throws Throwable {
	    System.out.println(driver.getCurrentUrl());
	}
	

	@Given("^user is on popup window  page$")
	public void user_is_on_popup_window_page() throws Throwable {
		System.out.println("user is on popup windows page");
	}

	@When("^user luanch winodw$")
	public void user_luanch_winodw() throws Throwable {
		driver.findElement(By.partialLinkText("Launch")).click();
	}

	@When("^user Submits after typing in textbos$")
	public void user_Submits_after_typing_in_textbos() throws Throwable {
		windowslist = new ArrayList(driver.getWindowHandles());
		String window1 = ((String)windowslist.get(1));
		System.out.println(window1);
		driver.switchTo().window(window1);
		driver.findElement(By.id("name")).sendKeys("uday");
		driver.findElement(By.id("submit")).click();		
	}
	
	@When("^user clicks proceed$")
	public void user_clicks_proceed() throws Throwable {
		String window2 = (String)(windowslist.get(0));
		driver.switchTo().window(window2);
		driver.findElement(By.linkText("Proceed")).click();
	}

	@Then("^browser navigtes to Token generation page$")
	public void browser_navigtes_to_Token_generation_page() throws Throwable {
	    System.out.println(driver.getCurrentUrl());
	}


	@Given("^user is on Token generation Page$")
	public void user_is_on_Token_generation_Page() throws Throwable {
	    System.out.println("user is on token generation page");
	}

	@When("^user generate the token$")
	public void user_generate_the_token() throws Throwable {
		driver.findElement(By.linkText("Generate Token")).click();
		String token = driver.findElement(By.id("token")).getText();
		tokenid = token.substring(7, token.length());
	}

	@When("^Submit the token$")
	public void submit_the_token() throws Throwable {
		Cookie cookie = new Cookie("Token",tokenid);
		driver.manage().addCookie(cookie);
	}

	@Then("^end basic couse message is displayed$")
	public void end_basic_couse_message_is_displayed() throws Throwable {
		String endMsg = driver.findElement(By.cssSelector("body > div > div.page > span  ")).getText();
	    System.out.println(endMsg);
	}

}
