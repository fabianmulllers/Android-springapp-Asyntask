package com.example.fabian.springapp.Controller;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.TextView;import android.widget.TextView;import android.widget.TextView;import android.widget.TextView;

import com.example.fabian.springapp.Nombres;
import com.example.fabian.springapp.R;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by fabian on 24-05-16.
 */


public class Request extends AppCompatActivity {

    @Override
    public void onStart(){
        super.onStart();
        new HttpRequestTask().execute();
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

            for(Nombres item:result){
               /* System.out.println(item.getId());
                System.out.println(item.getName());
                System.out.println(item.getEmail());
                System.out.println(item.getCreated_at());
                System.out.println(item.getUpdated_at());*/
              /*  TextView id= (TextView) findViewById(R.id.textView);
                id.setText(item.getId());
                TextView name= (TextView) findViewById(R.id.textView2);
                name.setText(item.getName());
                TextView email= (TextView) findViewById(R.id.textView3);
                email.setText(item.getEmail());
                TextView create= (TextView) findViewById(R.id.textView4);
                create.setText(item.getCreated_at());
*/
            }
            /*TextView id = (TextView) findViewById(R.id.id_value);
            TextView content=(TextView) findViewById(R.id.content_value);
            id.setText(result.getId());
            content.setText(result.getContent());*/
        }

    }

}
