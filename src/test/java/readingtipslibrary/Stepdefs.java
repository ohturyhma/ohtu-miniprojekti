/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary;

import readingtipslibrary.app.App;
import readingtipslibrary.app.StubIO;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import readingtipslibrary.dao.DaoService;

/**
 *
 * @author strajama
 */
public class Stepdefs {

    private App app;
    private StubIO io;

    private List<String> input = new ArrayList<>();

    @Given("^command \"([^\"]*)\" and type \"([^\"]*)\" is selected$")
    public void commandAndTypeIsSelected(String command, String type) {
        switch (command) {
            case "insert":
                insert(type);
                break;
            case "find-type":
                findType(type);
                break;
            default:
                throw new IllegalArgumentException("Illegal type entered.");
        }
    }

    @Given("^command \"([^\"]*)\" is selected$")
    public void commandFindAllIsSelected(String command) {
        addParameters(command);
    }
    
    @When("^type \"([^\"]*)\" is entered$")
    public void typeIsEntered(String type) {
        addParameters(type);
    }

    @When("^title \"([^\"]*)\" and description \"([^\"]*)\" and url \"([^\"]*)\" are entered$")
    public void titleAndUrlAreEntered(String title, String description, String url) throws Exception {
        addParameters(title, description, url);
    }

    @When("^author \"([^\"]*)\" and title \"([^\"]*)\" and isbn \"([^\"]*)\" and description \"([^\"]*)\" and url \"([^\"]*)\" are entered$")
    public void authorAndTitleAndIsbnAndDescriptionAndUrlAreEntered(String author, String title, String isbn, String description, String url) throws Exception {
        addParameters(author, title,isbn, description, url);
    }
    
        @When("^name \"([^\"]*)\" and title \"([^\"]*)\" and description \"([^\"]*)\" and url \"([^\"]*)\" are entered$")
    public void nameAndTitleAndDescriptionAreEntered(String name, String title, String description, String url) throws Exception {
        addParameters(name, title, description, url);
    }
    
    @When("^author \"([^\"]*)\" and title \"([^\"]*)\" and description \"([^\"]*)\" and url \"([^\"]*)\" are entered$")
    public void authorAndTitleAndDescriptionAreEntered(String name, String title, String description, String url) throws Exception {
        addParameters(name, title, description, url);
    }

    @Then("^system will respond with \"([^\"]*)\" message$")
    public void systemWillRespondWith(String expected) throws Exception {
        runTestCase();
        assertTrue(io.getPrints().contains(expected));
    }

    private void runTestCase() throws Exception {
        input.add("quit");
        io = new StubIO(input);
        app = new App();
        app.init(io);
        app.run();
    }
    
    private void insert(String type) {
        addParameters("insert", type);
    }

    private void findType(String type) {
        addParameters("find-type", type);
    }
    
    private void deleteType(String type) {
        addParameters("delete-type");
    }

    private void addParameters(String...parameters) {
        input.addAll(Arrays.asList(parameters));
    }
}
