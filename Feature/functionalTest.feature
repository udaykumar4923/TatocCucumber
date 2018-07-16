Feature: Automating Tatoc Basic Course

Scenario: Opens Grid Gate Page After CLicking Basic Course Link
	Given user is on tatoc course url
	When user clicks on Basic Course Link
	Then browser navigates to gridgate page
	
Scenario: opens frame and dungeon page when user clicks on greed grid box
	Given user is on gridgate page
	When user clicks on green gridbox
	Then browser navigates to frame and dungeon page
	
Scenario: opens DragANdDrop page when clicked with matching colour
	Given user is on frame and dungeon page
	When user clicks on repaint color button color of second box changes
	And user clicks on proceed button 
	Then browser navigates to DragAndDrop page.
	
Scenario: opens popup windows page when clicked proceed after completing drag and drop action
	Given user is on draganddrop page
	When user completes DragAndArop action
	And click on proceed link
	Then browser navigates to Token Generation button
	
Scenario: open token task page when clicked proceed after completing LaunchWindow task
	Given user is on popup window  page
	When user luanch winodw
	And user Submits after typing in textbos
	And user clicks proceed
	Then browser navigtes to Token generation page
	
Scenario: gives message of course complete when token task is completed
	Given user is on Token generation Page
	When user generate the token
	And Submit the token
	And click on proceed link
	Then end basic couse message is displayed  