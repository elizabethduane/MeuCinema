package infocefetcontagem.meucinema.dados;

public class Filme{

    //informaçoes principais
    private String nome;
    private String genero;
    private int duracao;
    private int imgClassificacao;
    private int imgResourceId;  //guarda o id da imagem da pasta drawable

    //informações secundárias
    private String elenco;
    private String direcao;
    private String sinopse;
    private int imgBanner;

    public Filme(String nome, String genero, int duracao, int imgClassificacao, int imgResourceId){

        this.nome = nome;
        this.genero = genero;
        this.duracao = duracao;
        this.imgClassificacao = imgClassificacao;
        this.imgResourceId = imgResourceId;

    }

    //getters

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public int getDuracao() {
        return duracao;
    }


    public int getImgResourceId() {
        return imgResourceId;
    }

    public int getImgClassificacao() {
        return imgClassificacao;
    }

    public String getElenco() {
        return elenco;
    }

    public void setElenco(String elenco) {
        this.elenco = elenco;
    }

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public int getImgBanner() {
        return imgBanner;
    }

    public void setImgBanner(int imgBanner) {
        this.imgBanner = imgBanner;
    }
}
