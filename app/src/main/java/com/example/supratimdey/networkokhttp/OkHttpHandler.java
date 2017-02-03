package com.example.supratimdey.networkokhttp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Supratim Dey on 1/30/2017.
 */

public class OkHttpHandler extends AsyncTask<String,Void,Blog[]>{

    OkHttpClient client = new OkHttpClient();




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
}
