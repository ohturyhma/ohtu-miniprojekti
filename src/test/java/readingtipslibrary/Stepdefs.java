/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertTrue;
import readingtipslibrary.dao.BlogService;
import readingtipslibrary.dao.BookService;
import readingtipslibrary.dao.Database;
import readingtipslibrary.dao.PodcastService;
import readingtipslibrary.dao.VideoService;

/**
 *
 * @author strajama
 */
public class Stepdefs {
    
    private static TestApplication test;
    private VideoService videoService;
    private BookService bookService;
    private PodcastService podcastService;
    private BlogService blogService;
    private Database database;
    private static List<String> input;
    
    public Stepdefs() throws ClassNotFoundException {
            input = new ArrayList<>();
            test = new TestApplication();
            test.init(input);
        }
    
    @Given ("^command insert and type video tip is selected$")
    public void commandInsertTipAndTypeVideoIsSelected() {
        input.add("insert");
        input.add("video");
    }
    
    @When ("^title \"([^\"]*)\" and url \"([^\"]*)\" are entered$")
    public void titleAndUrlAreEntered(String title, String url) throws Exception {
        input.add(title);
        input.add(url);
        test.run();
    }
    
    @Then("^system will respond with \"([^\"]*)\"$")
    public void systemWillRespondWith(String expected) {
        assertTrue(test.getPrints().contains(expected));
    }
    
}
