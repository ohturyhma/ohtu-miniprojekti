/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Vertti
 */
public class UrlField extends Field {

    public UrlField() {
        name = "url";
    }

    @Override
    public boolean isValidContent(String content) {
        //Pattern to check if this is a valid URL address
        Pattern p = Pattern.compile("^(http://|https://)?(www.)?\\w+.\\w*[.][a-zA-Z]{2,63}($|[/]\\S*)"); //?(www.)?(/w)+.(/w)*.(/w){2-63}/?$");
        Matcher m;
        m = p.matcher(content);
        return m.matches();
    }
}
