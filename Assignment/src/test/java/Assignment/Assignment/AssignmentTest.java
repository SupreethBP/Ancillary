package Assignment.Assignment;

import org.testng.annotations.Test;

public class AssignmentTest extends BaseTest
{
	@Test
	public void reviewcomments1()
	{
		Assignment1Pom a1= new Assignment1Pom(driver);
		a1.searchButton();
		a1.selectFirstItem();
		a1.reviews(driver);
		a1.commentsList();
	}

}
