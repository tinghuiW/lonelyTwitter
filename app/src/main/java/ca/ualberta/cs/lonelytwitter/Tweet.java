/*
* Class name: Tweet
*
* Version: Version 1.0
*
* Date: September 28, 2017
*
*Copyright (c) Team X, CMPUT301, University of Alberta - All Right Reserved. You may use, distribute, or modify this code under terms and conditions of the Code of Students behavior at university of Alberta
*
 */
package ca.ualberta.cs.lonelytwitter;
import android.widget.EditText;

import java.util.Date;


/**
 * Represents a Tweet
 *
 * @author tinghui
 * @versiion 1.0
 * @see  NormalTweet
 * @see  ImportantTweet
 * @since 1.0
 */

public abstract class Tweet implements TweetTable {
    private String message;
    private Date date;
    private EditText bodyText;

    /**
     * Constructs Tweet object
     *
     * @param message
     */

    public Tweet(String message){
        this.message = message;
        this.date = new Date();

    }

    /**
     * Constructs Tweet object
     *
     * @param message tweet message
     * @param date tweet date
     */

    public Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }

    /**
     * set tweet data
     * @param date
     */

    public void setDate(Date date){
        this.date = date;
    }

    /**
     * set tweet message
     *
     * @param message Tweet message
     * @throws TweetTooLongException
     */

    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() <= 140){
            this.message = message;
        }
        else{
            throw  new TweetTooLongException();
        }
    }

    /**
     * return tweet message
     * @return date
     */

    public  Date getDate(){
        return date;
    }

    /**
     * return tweet message
     * @return message
     */

    public String getMessage(){
        return message;
    }
    public abstract Boolean isImportant();
}
