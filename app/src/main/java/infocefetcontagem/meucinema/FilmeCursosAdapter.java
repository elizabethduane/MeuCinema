package infocefetcontagem.meucinema;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import infocefetcontagem.meucinema.CinemaContract.FilmeTable;

public class FilmeCursosAdapter extends CursorAdapter {

    public FilmeCursosAdapter(Context context, Cursor c){
        super(context,c,0);
    }
    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        // Identifica a TextView no layout item_filme.xml cuja  a ID  é nome_filme
        TextView nomeTextView = (TextView) view.findViewById(R.id.nome_filme);
        // Recupera o nome do filme relacionado ao objeto filmeAtual e
        // atribuiu o texto na TextView nomeFilme
        String nome = cursor.getString(cursor.getColumnIndexOrThrow(FilmeTable.COLUMN_NOME));
        nomeTextView.setText(nome);

        // Identifica a TextView no layout item_filme.xml cuja  a ID  é genero_filme
        TextView generoTextView = (TextView) view.findViewById(R.id.genero_filme);
        // Recupera o gênero do filme relacionado ao objeto filmeAtual e
        // atribuiu o texto na TextView genero
        String genero = cursor.getString(cursor.getColumnIndexOrThrow(FilmeTable.COLUMN_GENERO));
        generoTextView.setText(genero);

        // Identifica a TextView no layout item_filme.xml cuja  a ID  é duracao_filme
        TextView duracaoTextView = (TextView) view.findViewById(R.id.duracao_filme);
        // Recupera a duracao do filme relacionado ao objeto filmeAtual, concatena com o texto "min."
        // e atribuiu o texto na TextView duracao
        int duracao = cursor.getInt(cursor.getColumnIndexOrThrow(FilmeTable.COLUMN_DURACAO));
        duracaoTextView.setText(duracao + "min.");

        // Identifica a ImageView no layout item_filme.xml cuja  a ID  é classificacao_filme
        ImageView classificacaoImageView = (ImageView) view.findViewById(R.id.classificacao_filme);
        // Recupera a classificacao e a cor de fundo do filme relacionado ao objeto filmeAtual e
        // atribuiu o texto e a cor na TextView classificacao"
        int classificacao = cursor.getInt(cursor.getColumnIndexOrThrow(FilmeTable.COLUMN_CLASSIFICACAO));
        classificacaoImageView.setImageResource(classificacao);


        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) view.findViewById(R.id.img_filme);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        int icon = cursor.getInt(cursor.getColumnIndexOrThrow(FilmeTable.COLUMN_IMAGEM));
        iconView.setImageResource(icon);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        return LayoutInflater.from(context).inflate(R.layout.item_filme, parent, false);


    }

}
