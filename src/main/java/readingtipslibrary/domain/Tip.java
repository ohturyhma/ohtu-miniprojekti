/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary.domain;

import java.util.HashMap;
import java.util.ArrayList;
/**
 *
 * @author Vertti
 */
public abstract class Tip {
    protected TypeField type;
    private HashMap<String, Field> fields;
    private ArrayList<String> fieldNames;
    
    public TypeField getType() {
        return type;
    }
    
    public Field getField(String s){
        if (fields.containsKey(s))
            return fields.get(s);
        return null;
    }
    
    public String[] getFieldNames(){
        return fieldNames.toArray(new String[0]);
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

    protected final void addField(Field f){
        if (fields == null)
            fields = new HashMap<>();
        if (fieldNames == null)
            fieldNames = new ArrayList<>();
        fields.put(f.getName(), f);
        fieldNames.add(f.getName());
    }
}
