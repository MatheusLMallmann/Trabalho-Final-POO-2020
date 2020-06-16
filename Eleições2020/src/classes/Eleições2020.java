package classes;

import exceptions.EleitorNullException;
import exceptions.CandidatoNullException;
import exceptions.EleitorJaVotouException;

import java.util.List;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class Eleições2020 {
	
	public static void main(String[] args) {
				
		try {
			List<Candidato> listaCandidatos = new ArrayList<Candidato>();
			List<Eleitores> listaEleitores = new ArrayList<Eleitores>();
			
			listaCandidatos.add(new Candidato("João Silva", "Partido Qualquer", 75, 015));
			listaCandidatos.add(new Candidato("João Abobado", "Partido", 54, 025));
			listaEleitores.add(new Eleitores("asd", "215487", LocalDate.of(2000, Month.JANUARY, 12)));
			listaEleitores.add(new Eleitores("asds", "245784", LocalDate.of(2000, Month.MARCH, 12)));
			listaEleitores.add(new Eleitores("asds", "245784", LocalDate.of(2000, Month.JUNE, 12)));
			listaEleitores.add(new Eleitores("asds", "245784", LocalDate.of(2000, Month.NOVEMBER, 12)));
			ResultadoEleicao resultados = new ResultadoEleicao();
			
			
			listaEleitores.get(0).votar(015, listaCandidatos);
			listaEleitores.get(1).votar(null, listaCandidatos);
			listaEleitores.get(2).votar(025, listaCandidatos);
			listaEleitores.get(3).votar(0, listaCandidatos);
			
			
			resultados.atribuicaoVotos(listaEleitores);
			resultados.resultadoEleicao(listaCandidatos);
		}catch(EleitorNullException e) {
			System.out.println(e.getMessage());
		}catch(CandidatoNullException e) {
			System.out.println(e.getMessage());
		}catch(EleitorJaVotouException e) {
			System.out.println(e.getMessage());
		}
	}
}
