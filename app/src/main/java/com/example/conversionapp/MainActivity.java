package com.example.conversionapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Conversion conversion = new Conversion();
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialiseUI(savedInstanceState);
    }

    void initialiseUI(Bundle savedInstanceState) {
        Button convert = findViewById(R.id.bConvert);
        convert.setOnClickListener(clickListener);
        restoreUI(savedInstanceState);
        convertValue();
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            convertValue();
        }
    };

    void convertValue() {
        EditText inch = findViewById(R.id.etInch);
        EditText foot = findViewById(R.id.etFoot);
        EditText mile = findViewById(R.id.etMile);
        checkBox = findViewById(R.id.check1);

        String sTotalResult = conversion.ResultToCenti(inch.getText().toString(), foot.getText().toString(), mile.getText().toString());
        TextView result = findViewById(R.id.totalResult);

        double metre = Double.parseDouble(sTotalResult) * 0.01;

        if (checkBox.isChecked()) {
            String metreResult = String.format("%3.2f", metre);
            result.setText(metreResult + " m");
        } else {
            result.setText(sTotalResult + " cm");
        }

    }

    protected void onSaveInstanceState(Bundle state) {

        EditText inch = findViewById(R.id.etInch);
        EditText foot = findViewById(R.id.etFoot);
        EditText mile = findViewById(R.id.etMile);
//        TextView result = findViewById(R.id.totalResult);

        String sInch = inch.getText().toString();
        String sFoot = foot.getText().toString();
        String sMile = mile.getText().toString();
//        String sResult = result.getText().toString();

        state.putString("Inch", sInch);
        state.putString("Foot", sFoot);
        state.putString("Mile", sMile);
//        state.putString("TotalResult", sResult);

        super.onSaveInstanceState(state);
    }

    private void restoreUI(Bundle state){
        if (state == null){ return; }
        String sInch = state.getString("Inch");
        EditText inch = findViewById(R.id.etInch);
        inch.setText(sInch);

        String sFoot = state.getString("Foot");
        EditText foot = findViewById(R.id.etFoot);
        foot.setText(sFoot);

        String sMile = state.getString("Mile");
        EditText mile = findViewById(R.id.etMile);
        mile.setText(sMile);

//        String sResult = state.getString("TotalResult");
//        TextView result = findViewById(R.id.totalResult);
//        result.setText(sResult);
    }
}
