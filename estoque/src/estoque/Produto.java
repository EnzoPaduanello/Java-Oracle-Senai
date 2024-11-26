package estoque;

public class Produto {
    private int idProduto;
    private String nome;
    private String descricao;
    private float preco;
    private int quantidade;
    private int idCategoria;
    private int idUsuario;

    // Construtor vazio
    public Produto() {}

    // Construtor com parâmetros
    public Produto(String nome, String descricao, float preco, int quantidade, int idCategoria, int idUsuario) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.idCategoria = idCategoria;
        this.idUsuario = idUsuario;
    }

    // Getters e setters
    public int getIdProduto() { return idProduto; }
    public void setIdProduto(int idProduto) { this.idProduto = idProduto; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public float getPreco() { return preco; }
    public void setPreco(float preco) { this.preco = preco; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public int getIdCategoria() { return idCategoria; }
    public void setIdCategoria(int idCategoria) { this.idCategoria = idCategoria; }
    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
}