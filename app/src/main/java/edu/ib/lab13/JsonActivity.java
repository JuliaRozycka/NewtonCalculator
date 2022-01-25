package edu.ib.lab13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

public class JsonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
    }

    public void onClick(View view) {

        final TextView textView = findViewById(R.id.tvResponse);
        String url = "http://api.open-notify.org/iss-now.json";

        RequestQueue queue = Volley.newRequestQueue(this);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
        response -> {
            Map m = gson.fromJson(response, Map.class);
            ISS iss = gson.fromJson(m.get("iss_position").toString(), ISS.class);
            textView.setText(iss.toString());
        }, error -> {
            textView.setText("error");
        });

        queue.add(stringRequest);

    }
}