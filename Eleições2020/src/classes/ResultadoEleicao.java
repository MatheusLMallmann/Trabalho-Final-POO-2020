package classes;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ResultadoEleicao implements InfoEleicoes{
	
	private double votosValidos = 0.0;
	private double votosBrancos = 0.0;
	private double votosNulos = 0.0;
	private double totalVotos = 0.0;
	
	public double getVotosValidos() {
		return votosValidos;
	}

	public double getVotosBrancos() {
		return votosBrancos;
	}

	public double getVotosNulos() {
		return votosNulos;
	}

	public double getTotalVotos() {
		return totalVotos;
	}

	public void setTotalVotos() {
		this.totalVotos = getVotosBrancos() + getVotosNulos() + getVotosValidos();
	}
	
	public void atribuicaoVotos(List<Eleitores> listaEleitores) {		
		for(int i = 0; i < listaEleitores.size(); i++) {
			if(listaEleitores.get(i).getVotoValido() == true) {
				this.votosValidos += 1.0;
			}else if(listaEleitores.get(i).getVotoBranco() == true) {
				this.votosBrancos += 1.0;
			}else if(listaEleitores.get(i).getVotoNulo() == true) {
				this.votosNulos += 1.0;				
			}						
		}	
	}
	
	public void resultadoEleicao(List<Candidato> listaCandidatos) {
		this.setTotalVotos();		
		double porcentagemVotos = 0.0;
		
		System.out.println("Total de votos: " + (int)this.totalVotos);
		System.out.println("Total de votos válidos: " + (int)this.votosValidos);
		System.out.println("Total de votos brancos: " + (int)this.votosBrancos);
		System.out.println("Total de votos nulos: " + (int)this.votosNulos);
		
		for(int i = 0; i < listaCandidatos.size(); i++) {
			if(listaCandidatos.get(i).getVotos() == 0) {
				porcentagemVotos = 0.0;
			}else {
				porcentagemVotos = listaCandidatos.get(i).getVotos() / (double)this.totalVotos;
			}					
			System.out.println("Candidato " + listaCandidatos.get(i).getNomeCandidato() + " tem " + 
								porcentagemVotos * 100.0 + " % do total de votos.");			
		}
	}
	
	@Override
	public void informaCandidatoMaisJovemeVelho(List<Candidato> listaCandidatos) {
		Comparator<Candidato> comparadorIdade = Comparator.comparing(Candidato::getIdade).reversed();
		
		Collections.sort(listaCandidatos, comparadorIdade);
		
		System.out.println("Lista dos candidatos do mais velho para o mais novo");
		listaCandidatos.forEach(System.out::println);
	}

	@Override
	public void informaCandidatoMaisMenosVotado(List<Candidato> listaCandidatos) {
		Comparator<Candidato> comparadorVotos = Comparator.comparing(Candidato::getVotos).reversed();
		
		Collections.sort(listaCandidatos, comparadorVotos);
		
		System.out.println("Lista dos candidatos do mais votado para o menos votado");
		listaCandidatos.forEach(System.out::println);
	}
}