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
import java.util.List;
import static org.junit.Assert.assertFalse;
import readingtipslibrary.dao.DaoService;

/**
 *
 * @author strajama
 */
public class Stepdefs {

    private App app;
    private StubIO io;
    private DaoService daoService;

    private List<String> input = new ArrayList<>();

    @Given("^command insert and type video tip is selected$")
    public void commandInsertTipAndTypeVideoIsSelected() {
        insert("video");
    }

    @Given("^command insert tip and type book is selected$")
    public void commandInsertTipAndTypeBookIsSelected() {
        insert("book");
    }

    @Given("^command insert tip and type podcast is selected$")
    public void commandInsertTipAndTypePodcastIsSelected() {
        insert("podcast");
    }

    @Given("^command insert tip and type blogpost is selected$")
    public void commandInsertTipAndTypeBlogpostIsSelected() {
        insert("blogpost");
    }

    @Given("^command find-all is selected$")
    public void commandFindAllIsSelected() {
        input.add("find-all");
    }

    @When("^title \"([^\"]*)\" and url \"([^\"]*)\" are entered$")
    public void titleAndUrlAreEntered(String title, String url) throws ClassNotFoundException, Exception {
        addAndQuit(title, url);
    }

    @When("^author \"([^\"]*)\" and title \"([^\"]*)\" and isbn \"([^\"]*)\" are entered$")
    public void authorAndTitleAndIsbnAreEntered(String author, String title, String isbn) throws ClassNotFoundException, Exception {
        addAndQuit(author, title, isbn);
    }
    
    @When("^podcastName \"([^\"]*)\" and title \"([^\"]*)\" and description \"([^\"]*)\" are entered$")
    public void podcastNameAndTitleAndDescriptionAreEntered(String podcastName, String title, String description) throws ClassNotFoundException, Exception {
        addAndQuit(podcastName, title, description);
    }

    @When("^author \"([^\"]*)\" and title \"([^\"]*)\" and url \"([^\"]*)\" are entered$")
    public void authorAndTitleAndUrlAreEntered(String author, String title, String url) throws ClassNotFoundException, Exception {
        addAndQuit(author, title, url);
    }

    @Then("^system will respond with \"([^\"]*)\" message$")
    public void systemWillRespondWith(String expected) {
        assertFalse(io.getPrints().contains(expected));
    }

    private void insert(String type) {
        input.add("insert");
        input.add("type");
    }

    private void addAndQuit(String x, String y, String z) throws ClassNotFoundException, Exception {
        input.add(x);
        input.add(y);
        input.add(z);
        input.add("quit");
        io = new StubIO(input);
        app = new App();
        app.init(io);
        app.run();
    }

    private void addAndQuit(String x, String y) throws ClassNotFoundException, Exception {
        input.add(x);
        input.add(y);
        input.add("quit");
        io = new StubIO(input);
        app = new App();
        app.init(io);
        app.run();
    }
    
        private void addDontQuit(String firstArg, String secondArg, String thirdArg, String fourthArg) throws ClassNotFoundException, Exception {
        input.add(firstArg);
        input.add(secondArg);
        input.add(thirdArg);
        input.add(fourthArg);
        io = new StubIO(input);
        app = new App();
        app.init(io);
        app.run();
    }
}
