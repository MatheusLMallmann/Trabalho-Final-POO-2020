package classes;

import exceptions.CandidatoNullException;

public class Candidato{
	
	private String nomeCandidato;
	private String partidoPolitico;
	private int idadeCandidato;
	private Integer numeroCandidato;
	private Integer votos = 0;	
		
	public Candidato(String nome, String partido, Integer idade, Integer numeroCandidato) throws CandidatoNullException{
		if(nome == null || partido == null || idade == null || numeroCandidato == null)
			throw new CandidatoNullException("Nenhum campo pode ser nulificado.");
		this.nomeCandidato = nome;
		this.partidoPolitico = partido;
		this.idadeCandidato = idade;
		this.numeroCandidato = numeroCandidato;
	}
	
	public String getNomeCandidato() {
		return nomeCandidato;
	}
	
	public String getPartidoPolitico() {
		return partidoPolitico;
	}
	
	public Integer getNumeroCandidato() {
		return numeroCandidato;
	}
	
	public int getVotos() {
		return votos;
	}
	
	public void setVoto(Boolean confirmacaoVoto) {
		this.votos += 1;
	}
	
	public int getIdade() {
		return idadeCandidato;
	}	

	@Override
	public String toString() {
		return getNomeCandidato().toUpperCase() +", "+ getPartidoPolitico() +", "+ " idade: " + getIdade() +", "+ " votos: " + getVotos();
	}
}