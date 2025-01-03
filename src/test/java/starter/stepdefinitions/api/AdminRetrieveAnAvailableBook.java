package starter.stepdefinitions.api;

import apiTest.methods.GetMethod;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;

public class AdminRetrieveAnAvailableBook {

    @Steps
    GetMethod getMethod;

    @Given("the user base api url for get one book is set")
    public void the_user_base_api_url_for_get_one_book_is_set() {
        getMethod.setBaseURL();
    }

    @When("user login with username {string} and password {string} for get only one book")
    public void user_login_with_username_and_password_for_get_only_one_book(String username, String password) {
        getMethod.setUsernameAndPassword(username, password);
    }

    @When("user select a book to retrieve using the available index {int}")
    public void user_select_a_book_to_retrieve_using_the_available_index(Integer selectedAvailableIndex) {
        getMethod.setAvailableBookIndexToRetrieve(selectedAvailableIndex);
    }

    @When("user send get request to the endpoint {string} to get the selected book")
    public void user_send_get_request_to_the_endpoint_to_get_the_selected_book(String endpoint) {
        getMethod.sendGetRequest(endpoint);
    }

    @Then("the response status code for user retrieve the selected book should {int}")
    public void the_response_status_code_for_user_retrieve_the_selected_book_should(Integer expectedStatus) {
        getMethod.verifyResponseStatusCode(expectedStatus);
    }

    @Then("user can retrieve the selected book")
    public void user_can_retrieve_the_selected_book() {
        getMethod.displayTheSelectedBook();
    }

}
