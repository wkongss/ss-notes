package com.example;

import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FridayTest {
    public static String isFriday(String today) {
        return today.equals("Friday") ? "Yes" : "No";
    }
}

public class StepDefinitions {
    String today;
    String answer;

    @Given("today is {string}")
    public void todayIs(String today) {
        this.today = today;
    }

    @When("I ask if it is Friday")
    public void ifIAsk() {
        this.answer = FridayTest.isFriday(this.today);
    }

    @Then("I should be told {string}")
    public void shouldBeTold(String expectedResponse) {
        assertEquals(expectedResponse, this.answer);
    }

}
