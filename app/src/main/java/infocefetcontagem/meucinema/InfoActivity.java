package infocefetcontagem.meucinema;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import infocefetcontagem.meucinema.dados.CinemaContract.FilmeTable;
import infocefetcontagem.meucinema.dados.CinemaDbHelper;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        //muda o título da Activity
        this.setTitle("FILME");

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        //verifica se recebeu o objeto de filme
        if (bundle != null){

            //To edit
            String idFilme = bundle.get("id").toString();
            carregaDados(idFilme);


        }else{

            //finaliza a Intent
            this.finish();
        }
    }


    void carregaDados(String idFilme){

        TextView nomeTextView = (TextView)findViewById(R.id.nome_filme);
        TextView generoFilme = (TextView) findViewById(R.id.genero_filme);
        TextView elencoTextView = (TextView)findViewById(R.id.texto_elenco);
        TextView direcaoTextView = (TextView)findViewById(R.id.texto_direcao);
        TextView duracaoTextView = (TextView)findViewById(R.id.texto_duracao);
        TextView sinopseTextView = (TextView)findViewById(R.id.sinopse_filme);
        ImageView bannerImageView = (ImageView)findViewById(R.id.banner_filme);
        ImageView classificacaoImageView = (ImageView)findViewById(R.id.classificacao_filme);


        CinemaDbHelper dbHelper = new CinemaDbHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String columns[] = {
                FilmeTable.COLUMN_NOME,
                FilmeTable.COLUMN_GENERO,
                FilmeTable.COLUMN_ELENCO,
                FilmeTable.COLUMN_DIRECAO,
                FilmeTable.COLUMN_DURACAO,
                FilmeTable.COLUMN_SINOPSE,
                FilmeTable.COLUMN_BANNER,
                FilmeTable.COLUMN_CLASSIFICACAO
        };

        String whereClause = FilmeTable._ID + "=" + idFilme;

        Cursor cursor = db.query(FilmeTable.TABLE_NAME,columns,whereClause,null,null,null,null);

        if(cursor != null){

            cursor.moveToFirst();

            //busca o valor de resposta da query e atribuiu os valores para cada view

            String aux = cursor.getString(cursor.getColumnIndexOrThrow(FilmeTable.COLUMN_NOME));
            nomeTextView.setText(aux);

            aux = cursor.getString(cursor.getColumnIndexOrThrow(FilmeTable.COLUMN_GENERO));
            generoFilme.setText(aux);

            aux = cursor.getString(cursor.getColumnIndexOrThrow(FilmeTable.COLUMN_ELENCO));
            elencoTextView.setText(aux);

            aux = cursor.getString(cursor.getColumnIndexOrThrow(FilmeTable.COLUMN_DIRECAO));
            direcaoTextView.setText(aux);

            int duracao  = cursor.getInt(cursor.getColumnIndexOrThrow(FilmeTable.COLUMN_DURACAO));
            duracaoTextView.setText(duracao + " min.");

            aux = cursor.getString(cursor.getColumnIndexOrThrow(FilmeTable.COLUMN_SINOPSE));
            sinopseTextView.setText(aux);

            int imgAux = cursor.getInt(cursor.getColumnIndexOrThrow(FilmeTable.COLUMN_BANNER));
            bannerImageView.setImageResource(imgAux);

            imgAux = cursor.getInt(cursor.getColumnIndexOrThrow(FilmeTable.COLUMN_CLASSIFICACAO));
            classificacaoImageView.setImageResource(imgAux);

        }else{
            Toast.makeText(this, "Erro ao abrir informações do filme.", Toast.LENGTH_SHORT).show();
        }
    }
}
