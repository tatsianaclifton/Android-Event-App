package com.tatsiana.post;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetActivity extends AppCompatActivity {

        String info = "";
        ListView mListView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_get);
            Intent intent = getIntent();
            String passedArg = intent.getStringExtra("args");
            info = passedArg;
            Log.i("Passed", passedArg);

            String[] myDataArray = {};

            try {
                JSONArray jsonArray = new JSONArray(info);

                myDataArray = new String[jsonArray.length()];

                for (int i = 0; i < jsonArray.length(); i++){

                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String name = jsonObject.getString("name");

                    myDataArray[i] = name;

                    //String date = jsonObject.getString("date");
                    //Log.i("Name: ", name);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            ArrayAdapter<String> stringAdapter = new ArrayAdapter<>(this, R.layout.item, myDataArray);
            //ArrayAdapter<String> stringAdapter2 = new ArrayAdapter<>(this, R.layout.item, myDataArray2);
            mListView = (ListView) findViewById(R.id.mListView);
            mListView.setAdapter(stringAdapter);

        }

    public void goBack(View view){
        Intent intent = new Intent(GetActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
