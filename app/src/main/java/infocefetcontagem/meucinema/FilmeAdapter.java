package infocefetcontagem.meucinema;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import infocefetcontagem.meucinema.dados.Filme;

public class FilmeAdapter extends ArrayAdapter<Filme>{

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param listaFilmes A List of AndroidFlavor objects to display in a list
     */

    public FilmeAdapter(Context context, ArrayList<Filme> listaFilmes) {
        super(context, 0, listaFilmes);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listFilmeView = convertView;
        if(listFilmeView == null) {
            listFilmeView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_filme, parent, false);
        }

        // Obtem o objeto atual de do ArrayList Filme
        Filme filmeAtual = getItem(position);

        // Identifica a TextView no layout item_filme.xml cuja  a ID  é nome_filme
        TextView nomeTextView = (TextView) listFilmeView.findViewById(R.id.nome_filme);
        // Recupera o nome do filme relacionado ao objeto filmeAtual e
        // atribuiu o texto na TextView nomeFilme
        nomeTextView.setText(filmeAtual.getNome());

        // Identifica a TextView no layout item_filme.xml cuja  a ID  é genero_filme
        TextView generoTextView = (TextView) listFilmeView.findViewById(R.id.genero_filme);
        // Recupera o gênero do filme relacionado ao objeto filmeAtual e
        // atribuiu o texto na TextView genero
        generoTextView.setText(filmeAtual.getGenero());

        // Identifica a TextView no layout item_filme.xml cuja  a ID  é duracao_filme
        TextView duracaoTextView = (TextView) listFilmeView.findViewById(R.id.duracao_filme);
        // Recupera a duracao do filme relacionado ao objeto filmeAtual, concatena com o texto "min."
        // e atribuiu o texto na TextView duracao
        String duracao = filmeAtual.getDuracao() + "  min.";
        duracaoTextView.setText(duracao);

        // Identifica a ImageView no layout item_filme.xml cuja  a ID  é classificacao_filme
        ImageView classificacaoImageView = (ImageView) listFilmeView.findViewById(R.id.classificacao_filme);
        // Recupera a classificacao e a cor de fundo do filme relacionado ao objeto filmeAtual e
        // atribuiu o texto e a cor na TextView classificacao
        classificacaoImageView.setImageResource(filmeAtual.getImgClassificacao());


        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listFilmeView.findViewById(R.id.img_filme);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        iconView.setImageResource(filmeAtual.getImgResourceId());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listFilmeView;

    }
}
