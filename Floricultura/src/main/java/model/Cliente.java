package model;

import dao.ClienteDAO;

public class Cliente {
	
	private int idCliente;
    private String nome;
    private String cpf;
    private String nascimento;
    private String email;
    private String telefone;
    private String senha;
    Endereco endereco;
    
    public Cliente() {
    }
    
    public Cliente(int idCliente, String nome, String cpf, String nascimento, String email, String telefone, String senha) {
		this.idCliente = idCliente;
		this.nome = nome;
		this.cpf = cpf;
		this.nascimento = nascimento;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
	}



	public Cliente(String nome, String email, String telefone, String senha) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;

    }
    
    public Cliente(int idCliente, String nome, String email, String telefone) { //adicionar parametro de cpf
    	this.idCliente = idCliente;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        //adicionar refencia de cpf
        
    }
    
    public Cliente(int idCliente, String nome, String email, String telefone, String senha) {
        this.idCliente = idCliente;
    	this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;

    }

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNascimento() {
		return nascimento;
	}
	
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;	
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void salvar() {
        new ClienteDAO().cadastrarCliente(this);
    }
	
	public void remover() {
        new ClienteDAO().removerCliente(this.idCliente);
    }
}