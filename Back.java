package com.example.lenovo.login_demo;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by lenovo on 12/21/2017.
 */

public class Back extends AsyncTask<String,Void,String> {

    public String res = "";
    public Toast t;
    Context context ;
    Back(Context c){
        context = c;
    }

    @Override
    protected String doInBackground(String... params) {
        String login_url = "http://192.168.225.75/sign.php";
        try {
            String fname = params[0];
            String lname = params[1];
            String add = params[2];
            String email = params[3];
            String mob = params[4];
            String blood = params[5];
            String pass = params[6];
            URL url = new URL(login_url);
            HttpURLConnection h = (HttpURLConnection)url.openConnection();
            h.setRequestMethod("POST");
            h.setDoOutput(true);
            h.setDoInput(true);
            OutputStream os = h.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
            String data = URLEncoder.encode("a","UTF-8")+"="+URLEncoder.encode(fname,"UTF-8")+"&"+URLEncoder.encode("b","UTF-8")+"="+URLEncoder.encode(lname,"UTF-8")+"&"+URLEncoder.encode("c","UTF-8")+"="+URLEncoder.encode(blood,"UTF-8")+"&"+URLEncoder.encode("d","UTF-8")+"="+URLEncoder.encode(add,"UTF-8")+"&"+URLEncoder.encode("e","UTF-8")+"="+URLEncoder.encode(mob,"UTF-8")+"&"+URLEncoder.encode("f","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"+URLEncoder.encode("g","UTF-8")+"="+URLEncoder.encode(pass,"UTF-8");
            bw.write(data);
            bw.flush();
            bw.close();
            InputStream is = h.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is,"iso-8859-1"));
            res = "";
            String line ="" ;
            while((line = br.readLine())!=null){
                res = res + line;
            }
            br.close();
            is.close();
            h.disconnect();
        } catch (MalformedURLException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
        return res;
    }

    @Override
    protected void onPreExecute() {
       t = new Toast(context);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        t.makeText(context,res,Toast.LENGTH_SHORT);
    }
}
