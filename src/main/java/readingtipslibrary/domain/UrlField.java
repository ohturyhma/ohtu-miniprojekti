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
public class UrlField extends Field {
    
    public UrlField(){
        name = "url";
    }
    
    @Override
    public boolean isValidContent(String content){
        //Here implement regex for confirming that content actually is url
        return true;
    }
}
