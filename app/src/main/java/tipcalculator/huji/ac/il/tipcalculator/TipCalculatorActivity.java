package tipcalculator.huji.ac.il.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends AppCompatActivity {
    private EditText amount;
    private CheckBox round;
    private TextView tipDisplay;
    private String bill;
    private double tipPercentage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        amount = (EditText)findViewById(R.id.edtBillAmount);
        round = (CheckBox)findViewById(R.id.chkRound);
        tipDisplay = (TextView)findViewById(R.id.txtTipResult);
        tipPercentage = 0.12;
    }



    public void calculate(View v){

        try {
            bill = amount.getText().toString();
            double tip = Double.parseDouble(bill) * tipPercentage;
            boolean toRound = round.isChecked();
            if(toRound)
                tipDisplay.setText((int)tip+"$");
            else
                tipDisplay.setText(tip+"$");
        }catch(Exception e){
            amount.setHint("Please enter bill.");
        }

    }
}
