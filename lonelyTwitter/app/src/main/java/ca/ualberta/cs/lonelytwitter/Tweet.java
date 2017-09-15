package ca.ualberta.cs.lonelytwitter;
import android.widget.EditText;

import java.util.Date;


/**
 * Created by tinghui on 9/14/17.
 */

public abstract class Tweet implements TweetTable {
    private String message;
    private Date date;
    private EditText bodyText;

    public Tweet(String message){
        this.message = message;
        this.date = new Date();

    }

    public Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() <= 140){
            this.message = message;
        }
        else{
            throw  new TweetTooLongException();
        }
    }

    public  Date getDate(){
        return date;
    }

    public String getMessage(){
        return message;
    }
    public abstract Boolean isImportant();
}
