package edu.ib.lab13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class SimpleRequestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_request);
    }

    public void onClick(View view) {
        final TextView textView = findViewById(R.id.tvResponse);
        final EditText editText = findViewById(R.id.edtSimpleRequest);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = editText.getText().toString(); //on nam zwraca editible dlatego musimy toString

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> {
            textView.setText("Response \n" + response.substring(0,200));
                }, error -> {
            textView.setText("error");
        });

        queue.add(stringRequest);

    }
}