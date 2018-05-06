package infocefetcontagem.meucinema;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import infocefetcontagem.meucinema.cliente.ClienteActivity;
import infocefetcontagem.meucinema.servidor.ServidorActivity;

public class InicialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);

        //relaciona view e variável
        Button bt_cliente = (Button)findViewById(R.id.cliente_button);
        Button bt_servidor = (Button)findViewById(R.id.servidor_button);

        bt_cliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InicialActivity.this, ClienteActivity.class);
                startActivity(intent);
            }
        });

        //chama activity do servidor
        bt_servidor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InicialActivity.this, ServidorActivity.class);
                startActivity(intent);
            }
        });
    }
}
