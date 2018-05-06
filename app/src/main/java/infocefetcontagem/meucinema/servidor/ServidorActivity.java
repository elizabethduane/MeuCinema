package infocefetcontagem.meucinema.servidor;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import infocefetcontagem.meucinema.R;
import infocefetcontagem.meucinema.dados.CinemaContract.FilmeTable;
import infocefetcontagem.meucinema.dados.CinemaDbHelper;
import infocefetcontagem.meucinema.dados.Filme;

public class ServidorActivity extends AppCompatActivity {

    private CinemaDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servidor);

        dbHelper = new CinemaDbHelper(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        contarFilmes();
    }

    public void carregaFilmes(View v){

        boolean erro = false;

        Filme aux = new Filme("Pedro Coelho","Fantasia",85, R.drawable._livre, R.drawable.pedro_coelho);

        aux.setDirecao("Will Gluck");
        aux.setElenco("Domhnall Gleeson, Rose Byrne, Sam Neill e Marianne Jean-Baptiste");
        aux.setImgBanner(R.drawable.pedro_coelho_banner);
        aux.setSinopse("Pedro Coelho é um animal rebelde que apronta todas no quintal e até dentro " +
                "da casa do Mr. McGregor (Domhnall Gleeson), com quem trava uma dura batalha pelo " +
                "carinho da amante de animais Bea (Rose Byrne)." );

        if(insert(aux)==-1)
            erro = true;

        aux = new Filme("Rampage: Destruição Total","Ação",107,R.drawable._14anos, R.drawable.rampage);
        if(insert(aux)==-1)
            erro = true;


        aux = new Filme("Somente o Mar Sabe","Drama",110,R.drawable._12anos, R.drawable.somente_mar);
        if(insert(aux)==-1)
            erro = true;

        aux = new Filme("Os Farofeiros","Comédia",103,R.drawable._12anos, R.drawable.farofeiros);
        if(insert(aux)==-1)
            erro = true;
        aux = new Filme("Vingadores: Guerra Infinita","Ação",150,R.drawable._12anos, R.drawable.vingadores);
        if(insert(aux)==-1)
            erro = true;
        aux = (new Filme("Tudo Que Quero","Drama/Comédia",93,R.drawable._10anos, R.drawable.tudo_quero));
        if(insert(aux)==-1)
            erro = true;
        aux = (new Filme("Deixe a Luz do Sol Entrar","Drama/Romance",96,R.drawable._14anos, R.drawable.deixe_luz));
        if(insert(aux)==-1)
            erro = true;

        aux = new Filme("Pantera Negra", "Ação", 135,R.drawable._14anos, R.drawable.pantera_negra);
        aux.setDirecao("Ryan Coogler");
        aux.setElenco(" Chadwick Boseman, Michael B. Jordan, Lupita Nyong'o");
        aux.setImgBanner(R.drawable.pantera_negra_banner);
        aux.setSinopse(" Após a morte do rei T'Chaka (John Kani), o príncipe T'Challa (Chadwick Boseman) " +
                "retorna a Wakanda para a cerimônia de coroação. Nela são reunidas as cinco tribos que compõem " +
                "o reino, sendo que uma delas, os Jabari, não apoia o atual governo. T'Challa logo " +
                "recebe o apoio de Okoye (Danai Gurira), a chefe da guarda de Wakanda, da irmã Shuri " +
                "(Letitia Wright), que coordena a área tecnológica do reino, e também de Nakia (Lupita Nyong'o), " +
                "a grande paixão do atual Pantera Negra, que não quer se tornar rainha. Juntos, " +
                "eles estão à procura de Ulysses Klaue (Andy Serkis), que roubou de Wakanda um " +
                "punhado de vibranium, alguns anos atrás." );
        if(insert(aux)==-1)
            erro = true;

        if(!erro)
            Toast.makeText(this,"Filmes inseridos!",Toast.LENGTH_SHORT).show();

        dbHelper.close();

        contarFilmes();

    }

    private long insert(Filme atual){

        //retornar o banco de dados para escrita
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        //cria objeto com valores para ser inserido
        ContentValues values = new ContentValues();

        values.put(FilmeTable.COLUMN_NOME, atual.getNome());
        values.put(FilmeTable.COLUMN_GENERO,atual.getGenero());
        values.put(FilmeTable.COLUMN_DURACAO,atual.getDuracao());
        values.put(FilmeTable.COLUMN_CLASSIFICACAO,atual.getImgClassificacao());
        values.put(FilmeTable.COLUMN_IMAGEM,atual.getImgResourceId());
        values.put(FilmeTable.COLUMN_ELENCO,atual.getElenco());
        values.put(FilmeTable.COLUMN_DIRECAO,atual.getDirecao());
        values.put(FilmeTable.COLUMN_SINOPSE,atual.getSinopse());
        values.put(FilmeTable.COLUMN_BANNER,atual.getImgBanner());

        long retorno = db.insert(FilmeTable.TABLE_NAME,null,values);

        if(retorno == -1){
            Toast.makeText(this,"Erro ao inserir "+ atual.getNome(),Toast.LENGTH_SHORT).show();
        }

        dbHelper.close();

        return retorno;

    }

    public void removeFilmes(View v){

        //retornar o banco de dados para escrita
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.delete(FilmeTable.TABLE_NAME,null,null);

        Toast.makeText(this,"Filmes deletados!",Toast.LENGTH_SHORT).show();

        dbHelper.close();

        contarFilmes();
    }

    public void contarFilmes(){

        //retornar o banco de dados para escrita
       SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cursor = db.query(FilmeTable.TABLE_NAME,null,null,null,null,null,null);

        int qtFilmes = cursor.getCount();

        TextView count = (TextView)findViewById(R.id.qt_textView);

        count.setText("Banco de Dados contém " + qtFilmes + " Filmes.");

    }

}
