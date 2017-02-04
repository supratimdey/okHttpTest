package com.example.supratimdey.networkokhttp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.internal.Excluder;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.*;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private Button btStart;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = (TextView) findViewById(R.id.textview);
        btStart   = (Button) findViewById(R.id.button);
        editText   =  (EditText) findViewById(R.id.editText);

        btStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String url = "http://api.androidhive.info/contacts/"; //"https://jsonplaceholder.typicode.com/posts/";

                OkHttpHandler handler = new OkHttpHandler();

                ContactList contactList ;

                try {


                     contactList = handler.execute(url).get();
                     tvResult.setText(String.valueOf(contactList.getContacts().size()));
                    // List<Contact> contacts= contactList.getContacts();
                    editText.setText(contactList.getContacts().get(0).getPhone().getMobile());
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                catch (ExecutionException e) {
                    e.printStackTrace();
                }

            }
        });

    }
    //private class OkHttpHandler extends AsyncTask<String,Void,Blog[]> {
    private class OkHttpHandler extends AsyncTask<String,Void,ContactList> {

        OkHttpClient client = new OkHttpClient();

        ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            dialog = new ProgressDialog(MainActivity.this);
            dialog.setTitle("Getting Data...");
            dialog.setMessage("downloading json");
            dialog.show();
        }


        @Override  //protected Blog[] doInBackground(String... params)
        protected ContactList doInBackground(String... params) {

            Request.Builder builder = new Request.Builder();

            builder.url(params[0]);

            Request request = builder.build();

            try {
                Response response = client.newCall(request).execute();
                //return response.body().string().toString();

                final Gson gson = new Gson();
                //final Blog[] blogs = gson.fromJson(response.body().charStream(),Blog[].class);
                final ContactList contactList = gson.fromJson(response.body().charStream(),ContactList.class);

                Log.d("count of contacts:",String.valueOf(contactList.getContacts().size()));

                return contactList;

            } catch (Exception e){
                Log.d("exp rt null:",e.getMessage());
            }
            return null;
        }


        @Override
        //protected void onPostExecute(Blog[] blogs) {
        protected void onPostExecute(ContactList contactList) {
            super.onPostExecute(contactList);
            dialog.dismiss();
        // done here
        }

    }



}
