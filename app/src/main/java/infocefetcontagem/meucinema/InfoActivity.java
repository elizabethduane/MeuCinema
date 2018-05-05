package infocefetcontagem.meucinema;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);


        Filme atual = (Filme) getIntent().getSerializableExtra("dadosFilme");

        TextView nomeTextView = (TextView)findViewById(R.id.nome_filme);
        TextView generoFilme = (TextView) findViewById(R.id.genero_filme);
        TextView elencoTextView = (TextView)findViewById(R.id.texto_elenco);
        TextView direcaoTextView = (TextView)findViewById(R.id.texto_direcao);
        TextView duracaoTextView = (TextView)findViewById(R.id.texto_duracao);
        TextView sinopseTextView = (TextView)findViewById(R.id.sinopse_filme);
        ImageView bannerImageView = (ImageView)findViewById(R.id.banner_filme);
        ImageView classificacaoImageView = (ImageView)findViewById(R.id.classificacao_filme);

        //verifica se recebeu o objeto de filme
        if (atual != null){

            //muda o título da Activity
            this.setTitle("FILME");

            //atribuiu os valores para cada view
            nomeTextView.setText(atual.getNome());
            generoFilme.setText(atual.getGenero());
            elencoTextView.setText(atual.getElenco());
            direcaoTextView.setText(atual.getDirecao());
            duracaoTextView.setText(atual.getDuracao()+ " min");
            sinopseTextView.setText(atual.getSinopse());
            bannerImageView.setImageResource(atual.getImgBanner());
            classificacaoImageView.setImageResource(atual.getImgClassificacao());


        }else{

            //finaliza a Intent
            this.finish();
        }
    }
}
