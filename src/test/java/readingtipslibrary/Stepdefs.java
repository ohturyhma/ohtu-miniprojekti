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

    @Given("^database has tip of type \"([^\"]*)\" and name \"([^\"]*)\"")
    public void databaseHasTipOfTypeAndName(String type, String name) throws Exception {
        commandAndTypeIsSelected("insert", type);
        switch (type) {
            case "book":
                authorAndTitleAndIsbnAndDescriptionAndUrlAreEntered("author", name, "isbn", "description", "https://someurl.com");
                runTestCase();
                break;
            case "blogpost":
                authorAndTitleAndDescriptionAreEntered("author", name, "description", "https://someurl.com");
                runTestCase();
                break;
            case "podcast":
                authorAndTitleAndDescriptionAreEntered("author", name, "description", "https://someurl.com");
                runTestCase();
                break;
            case "video":
                titleAndUrlAreEntered(name, "description", "https://someurl.com");
                runTestCase();
                break;
        }
        authorAndTitleAndIsbnAndDescriptionAndUrlAreEntered("author", name, "isbn", "description", "https://someurl.com");
        runTestCase();
    }

    @Given("^database has 3 tips with the word comp in their name")
    public void databaseHasTipsWithWord() throws Exception {
        databaseHasTipOfTypeAndName("book", "Introduction to the Theory of Computation");
        databaseHasTipOfTypeAndName("video", "How to avoid compromising your mission");
        databaseHasTipOfTypeAndName("blogpost", "About computers");
    }

    @Given("^command \"([^\"]*)\" is selected$")
    public void commandIsSelected(String command) {
        addParameters(command);
    }

    @When("^type \"([^\"]*)\" is entered$")
    public void typeIsEntered(String type) {
        addParameters(type);
    }

    @When("^name \"([^\"]*)\" is entered$")
    public void nameIsEntered(String name) {
        addParameters(name);
    }

    @When("^title \"([^\"]*)\" and description \"([^\"]*)\" and url \"([^\"]*)\" are entered$")
    public void titleAndUrlAreEntered(String title, String description, String url) throws Exception {
        addParameters(title, description, url);
    }

    @When("^author \"([^\"]*)\" and title \"([^\"]*)\" and isbn \"([^\"]*)\" and description \"([^\"]*)\" and url \"([^\"]*)\" are entered$")
    public void authorAndTitleAndIsbnAndDescriptionAndUrlAreEntered(String author, String title, String isbn, String description, String url) throws Exception {
        addParameters(author, title, isbn, description, url);
    }

    @When("^name \"([^\"]*)\" and title \"([^\"]*)\" and description \"([^\"]*)\" and url \"([^\"]*)\" are entered$")
    public void nameAndTitleAndDescriptionAreEntered(String name, String title, String description, String url) throws Exception {
        addParameters(name, title, description, url);
    }

    @When("^author \"([^\"]*)\" and title \"([^\"]*)\" and description \"([^\"]*)\" and url \"([^\"]*)\" are entered$")
    public void authorAndTitleAndDescriptionAreEntered(String name, String title, String description, String url) throws Exception {
        addParameters(name, title, description, url);
    }

    @When("^type all is entered$")
    public void typeAllIsEntered() {
        addParameters("book", "video", "podcast", "blogpost");
    }

    @Then("^system will respond with \"([^\"]*)\" message$")
    public void systemWillRespondWith(String expected) throws Exception {
        runTestCase();
        assertTrue(io.getPrints().contains(expected));
        emptyDatabase();
    }

    private void runTestCase() throws Exception {
        input.add("quit");
        io = new StubIO(input);
        app = new App();
        app.init(io);
        app.run();
        input = new ArrayList<>();
    }

    private void insert(String type) {
        addParameters("insert", type);
    }

    private void findType(String type) {
        addParameters("find-type", type);
    }

    private void addParameters(String... parameters) {
        input.addAll(Arrays.asList(parameters));
    }

    private void emptyDatabase() throws Exception {
        commandIsSelected("delete-all");
        typeAllIsEntered();
        runTestCase();
    }
}
