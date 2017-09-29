/*
* Class name: ImportantTweet
*
* Version: Version 1.0
*
* Date: September 28, 2017
*
*Copyright (c) Team X, CMPUT301, University of Alberta - All Right Reserved. You may use, distribute, or modify this code under terms and conditions of the Code of Students behavior at university of Alberta
*
 */
package ca.ualberta.cs.lonelytwitter;

import android.text.BoringLayout;

import java.util.Date;

/**
 * Represents a ImportantTweet
 * @author tinghui
 * @see Tweet
 */


public class ImportantTweet extends Tweet {

    /**
     * set ImportantTweet
     * @param message
     */
    public  ImportantTweet(String message){
        super(message);
    }

    /**
     * set ImportantTweet
     * @param message message
     * @param date date
     */

    public ImportantTweet(String message, Date date) {
        super(message, date);
    }

    @Override


    public Boolean isImportant(){
        return Boolean.TRUE;
    }
}
