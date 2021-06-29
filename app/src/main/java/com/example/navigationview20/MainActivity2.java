package com.example.navigationview20;

import android.content.ClipData;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.navigationview20.databinding.ActivityMain2Binding;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMain2Binding binding;
    TextView txtresibir;
    TextView txtuser;
    TextView txtnombre;
    String dato;
    String age;
    String alliance;
    String origin;
    String img;
    ImageView image;
    ClipData.Item uno;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.appBarMain.toolbar);
        dato=getIntent().getStringExtra("user");
        age=getIntent().getStringExtra("Age");
        alliance=getIntent().getStringExtra("alliance");
        origin=getIntent().getStringExtra("origin");
        img=getIntent().getStringExtra("img");



                binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*este es para el boton del mesanaje*/
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity2, menu);
        txtnombre=findViewById(R.id.textView);
        txtnombre.setText(dato);

        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
        MenuItem tools =  navigationView.getMenu().findItem(R.id.nav_home);
        SpannableString spanString = new SpannableString(tools.getTitle());
        tools.setTitle(age);

        NavigationView navigationView2 = (NavigationView)findViewById(R.id.nav_view);
        MenuItem tools2 =  navigationView2.getMenu().findItem(R.id.nav_gallery);
        SpannableString spanString2 = new SpannableString(tools2.getTitle());
        tools2.setTitle(alliance);

        NavigationView navigationView3 = (NavigationView)findViewById(R.id.nav_view);
        MenuItem tools3 =  navigationView3.getMenu().findItem(R.id.nav_slideshow);
        SpannableString spanString3 = new SpannableString(tools3.getTitle());
        tools3.setTitle(origin);

        image=findViewById(R.id.imageView);
        Picasso.get().load(img).resize(150, 150).centerCrop() .into(image);




        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);

        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();

    }
    public void  obtnerElementosImgane() {


        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = "https://jsonplaceholder.typicode.com/users/1";
        JSONObject nuevo = new JSONObject();
        JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {



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