/*
* Class name: LonelyTwitterActivity
*
* Version: Version 1.0
*
* Date: September 28, 2017
*
*Copyright (c) Team X, CMPUT301, University of Alberta - All Right Reserved. You may use, distribute, or modify this code under terms and conditions of the Code of Students behavior at university of Alberta
*
 */
package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Represents a LonelyTwitterActivity
 * @author tinghui
 *@version 1.0
 * @see TweetTable
 */

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);


		saveButton.setOnClickListener(new View.OnClickListener() {

			/**
			 * set LonelyTwitterActivity
			 * @param v
			 */
			public void onClick(View v) {
				Tweet tweet = new ImportantTweet("");
				NormalTweet tweet1 = new NormalTweet("");
				try {
					tweet.setMessage("Hello");
				} catch (TweetTooLongException e){
					/////printstacktrace////
				}
				ArrayList<Tweet> tweets = new ArrayList<Tweet>();
				tweets.add(tweet);
				tweets.add(tweet1);
				for (Tweet t : tweets){
					Log.d("Some tag", "The isImportant method on this object returns"+ t.isImportant());
				}

				ArrayList<TweetTable> tweetTables = new ArrayList<TweetTable>();
				tweetTables.add(tweet);
				tweetTables.add(tweet1);



				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				saveInFile(text, new Date(System.currentTimeMillis()));
				finish();

			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		String[] tweets = loadFromFile();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * return LonelyTwitterActivity
	 * @return String[]
	 */
	private String[] loadFromFile() {
		ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			String line = in.readLine();
			while (line != null) {
				tweets.add(line);
				line = in.readLine();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tweets.toArray(new String[tweets.size()]);
	}

	/**
	 * set LonelyTwitterActivity
	 * @param text
	 * @param date
	 */
	private void saveInFile(String text, Date date) {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_APPEND);
			fos.write(new String(date.toString() + " | " + text)
					.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}