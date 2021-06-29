package com.example.navigationview20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button bntbusar;
    EditText txuser;
    EditText txtpas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txuser=findViewById(R.id.txtusuario);
        txtpas=findViewById(R.id.editTextTextPassword);
        bntbusar=findViewById(R.id.bntEnviar);

        bntbusar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txuser.getText().length()>0) {
                    obtnerElementosImgane();
                }else{ Toast toast = Toast.makeText(getApplicationContext(), "Ingrese el id  a buscar", Toast.LENGTH_SHORT);
                    toast.show();}

            }
        });
    }
    public void  obtnerElementosImgane() {

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = "https://my-json-server.typicode.com/victorfrancisc/APP/posts";
        JSONObject nuevo = new JSONObject();
        JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject row = response.getJSONObject(i);
                        if(row.getString("user").equals(txuser.getText().toString()) & row.getString("pass").equals(txtpas.getText().toString()))
                        {
                            Intent is=new Intent(MainActivity.this, MainActivity2.class);
                            is.putExtra("user", txuser.getText().toString());
                            is.putExtra("Age", row.getString("Age"));
                            is.putExtra("alliance", row.getString("alliance"));
                            is.putExtra("origin", row.getString("origin"));
                            is.putExtra("img", row.getString("img"));

                            startActivity(is);

                        }


                    }
                     } catch (Exception e) {
                }

            }

        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);


    }

}