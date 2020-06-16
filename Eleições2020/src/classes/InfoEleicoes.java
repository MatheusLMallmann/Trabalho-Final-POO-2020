package classes;

import java.util.List;

public interface InfoEleicoes {
	
	public void informaCandidatoMaisJovemeVelho(List<Candidato> listaCandidatos);
		
	public void informaCandidatoMaisMenosVotado(List<Candidato> listaCandidatos);	
	
	public void resultadoEleicao(List<Candidato> listaCandidatos);
}
