/*
* Class name: NormalTweet
*
* Version: Version 1.0
*
* Date: September 28, 2017
*
*Copyright (c) Team X, CMPUT301, University of Alberta - All Right Reserved. You may use, distribute, or modify this code under terms and conditions of the Code of Students behavior at university of Alberta
*
 */
package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Represents a NormalTweet
 * @author tinghui
 * @see Tweet
 */

public class NormalTweet extends Tweet{

    /**
     * set NormalTweet
     * @param message message
     */
    public NormalTweet(String message){
        super(message);
    }

    /**
     * set message
     * @param message message
     * @param date date
     */

    public NormalTweet(String message, Date date){
        super(message, date);
    }

    @Override
    public Boolean isImportant(){
        return Boolean.FALSE;
    }
}
