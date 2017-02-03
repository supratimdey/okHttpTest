package com.example.supratimdey.networkokhttp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.internal.Excluder;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.*;
import java.io.IOException;
import java.util.concurrent.ExecutionException;


public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private Button btStart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = (TextView) findViewById(R.id.textview);
        btStart   = (Button) findViewById(R.id.button);

        btStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String url = "https://jsonplaceholder.typicode.com/posts/";

                OkHttpHandler handler = new OkHttpHandler();
                Blog[] blogs = null;

                try {

                     blogs = handler.execute(url).get();

                    tvResult.setText(blogs[1].getTitle());

                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                catch (ExecutionException e) {
                    e.printStackTrace();
                }

            }
        });

    }

    private class OkHttpHandler extends AsyncTask<String,Void,Blog[]> {

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


        @Override
        protected Blog[] doInBackground(String... params) {

            Request.Builder builder = new Request.Builder();

            builder.url(params[0]);

            Request request = builder.build();

            try {
                Response response = client.newCall(request).execute();
                final Gson gson = new Gson();

                final Blog[] blogs = gson.fromJson(response.body().charStream(),Blog[].class);

                Log.d("Info count of blogs :",String.valueOf(blogs.length));

                return blogs;

            } catch (Exception e){

            }
            return null;
        }

        @Override
        protected void onPostExecute(Blog[] blogs) {
            super.onPostExecute(blogs);
            dialog.dismiss();

        }

    }



}
