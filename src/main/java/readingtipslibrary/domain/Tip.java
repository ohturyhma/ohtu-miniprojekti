/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary.domain;

import java.util.HashMap;
/**
 *
 * @author Vertti
 */
public abstract class Tip {
    protected TypeField type;
    protected HashMap<String, Field> fields;
    protected String[] fieldNames;
    
    public TypeField getType() {
        return type;
    }
    
    public Field getField(String s){
        if (fields.containsKey(s))
            return fields.get(s);
        return null;
    }
    
    public String[] getFieldNames(){
        return fieldNames;
    }
    
    public String getName(){
        return "";
    }
    
    public static Tip tipFromType(String type){
        switch(type){
            case "blogpost": return new Blogpost();
            case "book": return new Book();
            case "podcast": return new Podcast();
            case "video": return new Video();
        }
        return null;
    }
    
    @Override
    public String toString(){
        String s = "";
        for(Field f : fields.values()){
            s += f.nameContentPrint();
        }
        return s;
    }

}
