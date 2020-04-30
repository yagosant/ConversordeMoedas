package com.yago.conversordemoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //instancia a viewholder, usando o m por ter sido criado por vc
    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // this.mViewHolder. manipula os elementos
        this.mViewHolder.editValor = findViewById(R.id.editValor);
        this.mViewHolder.textDolar = findViewById(R.id.textDolar);
        this.mViewHolder.textEuro = findViewById(R.id.textEuro);
        this.mViewHolder.btnCalculate = findViewById(R.id.btnCalculate);

        //metodo de clique para calcular
        this.mViewHolder.btnCalculate.setOnClickListener(this);
        //metodo para limpar os campos
        this.clearValues();

    }

    //metodo para limpar os campos
    private void clearValues() {
        this.mViewHolder.textDolar.setText("");
        this.mViewHolder.textEuro.setText("");
    }

    //metodo de clique dos botoes
    @Override
    public void onClick(View v) {
        //verifica qual botao foi clicado
     if (v.getId() == R.id.btnCalculate){
         //logica do botao de clique
         String value = this.mViewHolder.editValor.getText().toString();
         //verifico se veio vazio
         if ("".equals(value)){
             Toast.makeText(this, R.string.msg_erro_valor, Toast.LENGTH_LONG).show();
         }else{
            Double real = Double.valueOf(value);
            this.mViewHolder.textDolar.setText(String.format("%,2f",(real/ 5.25)));
            this.mViewHolder.textEuro.setText(String.format("%,2f",(real/ 5.70)));
         }
     }
    }

    //o viewHolder verifica o findviewbyid uma unica vez, possui todos os elemento de interface
    private static class ViewHolder{
        EditText editValor;
        TextView textDolar, textEuro;
        Button btnCalculate;
    }
}
