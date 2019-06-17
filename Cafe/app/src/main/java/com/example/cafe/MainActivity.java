package com.example.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.quantidade);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.quantidade, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Button button = findViewById(R.id.botao);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent sendEmail = new Intent(Intent.ACTION_SEND);

                // Tipo do conteúdo.
                sendEmail.setType("text/plain");

                // Para passar os destinatários deve-se utilizar um array com
                // os endreços de e-mails.
                String[] addresses = {"hewerton.oliveira@ifc.edu.br"};
                sendEmail.putExtra(Intent.EXTRA_EMAIL, addresses);

                // Corpo do e-mail.
                sendEmail.putExtra(Intent.EXTRA_TEXT, "Olá, quero um café!");

                // Assunto do e-mail.
                sendEmail.putExtra(Intent.EXTRA_SUBJECT, "Café!");

                // Verifica se existe algum app que resolve a intent
                if (sendEmail.resolveActivity(getPackageManager()) != null) {

                    // Inicia a intent
                    startActivity(sendEmail);

                    Log.i("E-mail", "Enviei o intent!");
                }
                Log.i("E-mail", "Botão pressionado!");

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
