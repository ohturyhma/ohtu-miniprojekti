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
public class TypeField extends Field {
    
    public static final String[] POSSIBLE_TYPES = new String[]{"blogpost", "book", "podcast", "video"};
    
    public TypeField(){
        name = "type";
    }
    
    @Override
    public boolean isValidContent(String content){
        for(String s : POSSIBLE_TYPES){
            if (content.equals(s))
                return true;
        }
        return false;
    }
}
