/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary.domain;

/**
 *
 * @author Vertti
 */
public abstract class Field {

    protected String name;
    private String content;

    @Override
    public String toString() {
        return name.substring(0, 1).toUpperCase() + name.substring(1) + ": ";
    }

    public String nameContentPrint(){
        return toString() + getContent() + "\n";
    }
    
    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public boolean setContent(String content) {
        if (!isValidContent(content)) {
            return false;
        }
        this.content = content;
        return true;
    }
    
    public boolean isValidContent(String s) {
        return true;
    }
}
