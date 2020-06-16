package classes;

import java.time.LocalDate;
import java.util.List;

import exceptions.EleitorJaVotouException;
import exceptions.EleitorNullException;

public class Eleitores {
	
	private String nomeEleitor;
	private String tituloEleitor;
	private LocalDate dataNascimento;
	private Boolean votoValido = false;
	private Boolean votoBranco = false;
	private Boolean votoNulo = false;
	
	public Eleitores(String nome, String titulo,
			LocalDate nascimento) throws EleitorNullException{
		if(nome == null ||titulo == null || nascimento == null)
			throw new EleitorNullException("Nenhum campo pode ser nulificado.");
		this.nomeEleitor = nome;
		this.tituloEleitor = titulo;
		this.dataNascimento = nascimento;
	}
	
	public String getTituloEleitor() {
		return tituloEleitor;
	}
	
	public void setVotoValido(Boolean voto) {
		this.votoValido = voto;
	}	

	public Boolean getVotoBranco() {
		return votoBranco;
	}

	public void setVotoBranco(Boolean votoBranco) {
		this.votoBranco = votoBranco;
	}

	public Boolean getVotoNulo() {
		return votoNulo;
	}		
	
	public void setVotoNulo(Boolean votoNulo) {
		this.votoNulo = votoNulo;
	}

	public Boolean getVotoValido() {
		return votoValido;
	}
	
	public Boolean jaVotou() {
		if(this.votoValido == true) {
			return this.votoValido;
		}else if(this.votoBranco == true) {
			return this.votoBranco;
		}else if(this.votoNulo == true) {
			return this.votoNulo;
		}
		
		return false;
	}
	
	public Boolean votar(Integer numeroCandidato,
			List<Candidato> listaCandidatos) throws EleitorJaVotouException {
	
		if(this.jaVotou() == false) {
			if(numeroCandidato == null) {
				this.setVotoNulo(true);
				return true;
			}			
			
			for(int i = 0; i < listaCandidatos.size(); i++) {
				if(listaCandidatos.get(i).getNumeroCandidato().equals(numeroCandidato)) {					
					listaCandidatos.get(i).setVoto(true);						
					this.setVotoValido(true);
					return true;
				}
			}		
			
			this.setVotoBranco(true);
		}else {
			throw new EleitorJaVotouException("Seu voto já foi computado.");
		}
		
		return true;
	}
}
