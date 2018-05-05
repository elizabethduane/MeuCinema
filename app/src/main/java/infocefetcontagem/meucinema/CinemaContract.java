package infocefetcontagem.meucinema;

import android.provider.BaseColumns;

public class CinemaContract {


    private CinemaContract(){ };

    public static class FilmeTable implements BaseColumns{
        public static final String TABLE_NAME = "filme";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_NOME = "nome";
        public static final String COLUMN_GENERO = "genero";
        public static final String COLUMN_DURACAO = "duracao";
        public static final String COLUMN_CLASSIFICACAO = "classificacao";
        public static final String COLUMN_IMAGEM = "imagem";
        public static final String COLUMN_ELENCO = "elenco";
        public static final String COLUMN_DIRECAO = "direcao";
        public static final String COLUMN_SINOPSE = "sinopse";
        public static final String COLUMN_BANNER = "banner";
        public static final String COLUMN_FAVORITO = "favorito";

        // Create a String that contains the SQL statement to create the filme table
        public static final String SQL_CREATE_FILME_TABLE =
                "CREATE TABLE " + FilmeTable.TABLE_NAME + " ("
                + FilmeTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + FilmeTable.COLUMN_NOME + " TEXT, "
                + FilmeTable.COLUMN_GENERO + " TEXT, "
                + FilmeTable.COLUMN_DURACAO + " INTEGER, "
                + FilmeTable.COLUMN_CLASSIFICACAO + " INTEGER, "
                + FilmeTable.COLUMN_IMAGEM + " INTEGER, "
                + FilmeTable.COLUMN_ELENCO + " TEXT, "
                + FilmeTable.COLUMN_DIRECAO + " TEXT, "
                + FilmeTable.COLUMN_SINOPSE + " TEXT, "
                + FilmeTable.COLUMN_BANNER + " INTEGER)";

        public static final String SQL_DELETE_FILME_TABLE =
                "DROP TABLE IF EXISTS " + FilmeTable.TABLE_NAME;

    }

}
