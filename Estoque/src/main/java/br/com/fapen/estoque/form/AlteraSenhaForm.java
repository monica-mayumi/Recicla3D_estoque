package br.com.fapen.estoque.form;

public class AlteraSenhaForm {

	private Integer idUsuario;
	private String novaSenha;
	private String novaSenhaConfirma;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer integer) {
		this.idUsuario = integer;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

	public String getNovaSenhaConfirma() {
		return novaSenhaConfirma;
	}

	public void setNovaSenhaConfirma(String novaSenhaConfirma) {
		this.novaSenhaConfirma = novaSenhaConfirma;
	}

}
