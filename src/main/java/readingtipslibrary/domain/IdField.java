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
 * @author johyry
 */
public class IdField extends Field {

    public IdField() {
        name = "id";
    }

    @Override
    public boolean isValidContent(String content) {
        Pattern p = Pattern.compile("^[1-9][0-9]*$");
        Matcher m;
        m = p.matcher(content);
        return m.matches();
    }
}

