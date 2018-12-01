package ina.devera.com.devera_practicalexam2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText exam1;
    EditText exam2;
    TextView Ave_text;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        exam1 = (EditText) findViewById(R.id.exam1);
        exam2 = (EditText) findViewById(R.id.exam2);
        Ave_text = (TextView) findViewById(R.id.Ave);
    }

    public void calculateave (View v) {
        String exam1Str = exam1.getText().toString();
        String exam2Str = exam2.getText().toString();
        Float exam1Int = Float.parseFloat(exam1Str);
        Float exam2Int = Float.parseFloat(exam2Str);
        Float Ave = (exam1Int+exam2Int)/2;
        Ave_text.setText(Float.toString(Ave));
        writeToFile("Chicken Nuggets",exam1Str+exam2Str+Ave);



}

    public  void writeToFile(String fileName, String body)
    {
        FileOutputStream fos = null;

        try {
            final File dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/DeVeraPracticalExam2/" );

            if (!dir.exists())
            {
                if(!dir.mkdirs()){
                    Log.e("ALERT","could not create the directories");
                }
            }

            final File myFile = new File(dir, fileName + ".txt");

            if (!myFile.exists())
            {
                myFile.createNewFile();
            }
            fos = new FileOutputStream(myFile);
            fos.write(body.getBytes());
            Toast.makeText(getBaseContext(), "Persist Successful",
                    Toast.LENGTH_SHORT).show();
            fos.close();
        } catch (IOException e) {
            Toast.makeText(getBaseContext(), e.getMessage(),
                    Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }




}
