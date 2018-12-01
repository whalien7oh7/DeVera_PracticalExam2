package ina.devera.com.devera_practicalexam2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText exam1;
    private EditText exam2;
    private TextView ave;


    SharedPreferences prefs = this.getSharedPreferences(
            "com.devera.ina", Context.MODE_PRIVATE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        exam1 = (EditText) findViewById(R.id.exam1);
        exam2 = (EditText) findViewById(R.id.exam2);
        ave = (TextView) findViewById(R.id.ave);
    }

    public void calculateave (View v) {
        String exam1Str = exam1.getText().toString();
        String exam2Str = exam2.getText().toString();

        if (exam1Str != null && !"".equals(exam1Str)
                && exam1Str != null  &&  !"".equals(exam1Str)) {
            float exam1Value = Float.parseFloat(exam1Str);
            float exam2Value = Float.parseFloat(exam2Str);


            float Ave = (exam1Value + exam2Value) / 2;

        }
}

    private void displayAve(float Ave) {
        String aveLabel = "";

        aveLabel = Ave + "\n\n" + aveLabel;

        Intent i = new Intent(this, MainActivity.class);

        String getrec=aveLabel;

        Bundle bundle = new Bundle();

        bundle.putString("stuff", getrec);

        i.putExtras(bundle);

        startActivity(i);

    }

}
