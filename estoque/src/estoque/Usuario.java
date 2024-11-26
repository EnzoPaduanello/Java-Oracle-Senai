package estoque;

public class Usuario {
    private int idUsuario;
    private String nome;
    private String email;
    private String senha;
    private int idPerfil;

    // Construtor vazio
    public Usuario() {}

    // Construtor com parâmetros
    public Usuario(String nome, String email, String senha, int idPerfil) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.idPerfil = idPerfil;
    }

    // Getters e setters
    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public int getIdPerfil() { return idPerfil; }
    public void setIdPerfil(int idPerfil) { this.idPerfil = idPerfil; }
}
