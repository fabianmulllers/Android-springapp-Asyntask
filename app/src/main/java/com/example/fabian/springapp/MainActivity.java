package com.example.fabian.springapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fabian.springapp.Controller.Request;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contenido_main);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
      /*  Request hola = new Request();
       hola.onStart();*/
    }


    @Override
    protected void onStart(){
        super.onStart();
        new HttpRequestTask().execute();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


  private class HttpRequestTask extends AsyncTask<Void, Void, Nombres[]> {
        @Override
        protected Nombres[] doInBackground(Void... params) {
            try {
                //final String url = "http://rest-service.guides.spring.io/greeting";
                String url = "http://192.168.1.35/APIREST/public/v1/user";
                RestTemplate restTemplate = new RestTemplate();


// Add the String message converter
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
              // result  = new ArrayList<>();
                //Stringo result = restTemplate.getForObject(url, Stringo.class);
              // names result = restTemplate.getForObject(url,names.class);
                ResponseEntity<Nombres[]> responseEntity = restTemplate.getForEntity(url, Nombres[].class);
                //System.out.println(restTemplate.getForObject(url,names.class));
               //return result;
               // HttpStatus statusCode = responseEntity.getStatusCode();

                //System.out.println(statusCode);

                 //Nombres[] result = responseEntity.getBody();
                //System.out.println(result);

                //return result;
               // System.out.println("este es el body"+responseEntity.getBody());
                //System.out.println("este es el header"+responseEntity.getHeaders());
                return responseEntity.getBody();

            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return null;
        }

        @Override
        protected void onPostExecute(Nombres[] result) {
            //RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relative);
            String[] arreglo = new String[result.length];


            for(Nombres item:result){

               // String[] textArray = {"One", "Two", "Three", "Four"};

                //for( int i = 0; i < textArray.length; i++ )
                //{
                    //TextView textView = new TextView(relativeLayout.getContext());
                int numero ;
                numero= Integer.parseInt(item.getId());

                 arreglo[numero-1] = item.getId()+" "+item.getName()+" "+item.getEmail();
                }
            ListView lista   = (ListView)findViewById(R.id.list);
            ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(),R.layout.texto,R.id.textocontent,arreglo);
            lista.setAdapter(arrayAdapter);
               /* System.out.println(item.getId());
                System.out.println(item.getName());
                System.out.println(item.getEmail());
                System.out.println(item.getCreated_at());
                System.out.println(item.getUpdated_at());
                TextView id= (TextView) findViewById(R.id.textView);
                id.setText(item.getId());
                TextView name= (TextView) findViewById(R.id.textView2);
                name.setText(item.getName());
                TextView email= (TextView) findViewById(R.id.textView3);
                email.setText(item.getEmail());
                TextView create= (TextView) findViewById(R.id.textView4);
                create.setText(item.getCreated_at());*/

            //}
            /*TextView id = (TextView) findViewById(R.id.id_value);
            TextView content=(TextView) findViewById(R.id.content_value);
            id.setText(result.getId());
            content.setText(result.getContent());*/
        }

    }




}
