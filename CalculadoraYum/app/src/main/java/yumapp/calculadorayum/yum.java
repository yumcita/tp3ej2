package yumapp.calculadorayum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class yum extends AppCompatActivity implements View.OnClickListener {

    EditText num1, num2;
    Button sumar, restar, multiplicar, dividir;
    TextView resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yum);

        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);

        sumar = (Button) findViewById(R.id.sumar);
        restar = (Button) findViewById(R.id.restar);
        multiplicar = (Button) findViewById(R.id.multiplicar);
        dividir = (Button) findViewById(R.id.dividir);

        resultado = (TextView) findViewById(R.id.resultado);

        sumar.setOnClickListener(this);
        restar.setOnClickListener(this);
        multiplicar.setOnClickListener(this);
        dividir.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try {
            String n1 = num1.getText().toString();
            String n2 = num2.getText().toString();

            double entero1 = Double.parseDouble(n1);
            double entero2 = Double.parseDouble(n2);
            double res = 0;


            switch (v.getId()) {
                case R.id.sumar:
                    res = entero1 + entero2;
                    break;
                case R.id.restar:
                    res = entero1 - entero2;
                    break;
                case R.id.multiplicar:
                    res = entero1 * entero2;
                    break;
                case R.id.dividir:

                    if(entero2 != 0) {
                        res = entero1 / entero2;
                    }else {
                        Toast.makeText(getApplicationContext(), "Invalido", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }

            resultado.setText("" + res);

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Tenes que ingresar 2 numeros.", Toast.LENGTH_SHORT).show();
        }
    }
}
