package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import classes.Candidato;
import classes.Eleitores;
import classes.ResultadoEleicao;
import exceptions.CandidatoNullException;
import exceptions.EleitorJaVotouException;
import exceptions.EleitorNullException;

import java.util.List;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class ResultadoEleiçõesTests {
	
	@Test
	public void infoResultadoVotacaoTest() throws CandidatoNullException, EleitorNullException, EleitorJaVotouException {
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
		
		Double totalVotosEsperados = 4.0;
		Double resultadoObtido = resultados.getTotalVotos();
		
		assertEquals(totalVotosEsperados, resultadoObtido);		
	}
	
	@Test
	public void contagemVotosBrancosTest() throws EleitorNullException, CandidatoNullException, EleitorJaVotouException {
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
		listaEleitores.get(1).votar(0, listaCandidatos);
		listaEleitores.get(2).votar(0, listaCandidatos);
		listaEleitores.get(3).votar(0, listaCandidatos);
		
		
		resultados.atribuicaoVotos(listaEleitores);
		resultados.resultadoEleicao(listaCandidatos);
		
		Double totalVotosEsperados = 3.0;
		Double resultadoObtido = resultados.getVotosBrancos();
		
		assertEquals(totalVotosEsperados, resultadoObtido);	
	}
	
	@Test
	public void verificandoNumeroVotosDeCandidatoTest() throws EleitorNullException, CandidatoNullException, EleitorJaVotouException{
		List<Candidato> listaCandidatos = new ArrayList<Candidato>();
		List<Eleitores> listaEleitores = new ArrayList<Eleitores>();
		
		listaCandidatos.add(new Candidato("João Silva", "Partido Qualquer", 75, 015));
		listaCandidatos.add(new Candidato("João Abobado", "Partido", 54, 025));
		listaEleitores.add(new Eleitores("asd", "215487", LocalDate.of(2000, Month.JANUARY, 12)));
		listaEleitores.add(new Eleitores("enor", "2454548", LocalDate.of(2000, Month.MARCH, 12)));
		listaEleitores.add(new Eleitores("odair", "354584", LocalDate.of(2000, Month.JUNE, 12)));
		listaEleitores.add(new Eleitores("jorge", "02145", LocalDate.of(2000, Month.NOVEMBER, 12)));
		ResultadoEleicao resultados = new ResultadoEleicao();
		
		
		listaEleitores.get(0).votar(015, listaCandidatos);
		listaEleitores.get(1).votar(015, listaCandidatos);
		listaEleitores.get(2).votar(015, listaCandidatos);
		listaEleitores.get(3).votar(015, listaCandidatos);
		
		
		resultados.atribuicaoVotos(listaEleitores);
		resultados.resultadoEleicao(listaCandidatos);
		
		int resultadoObtido = listaCandidatos.get(0).getVotos();
		int resultadoEsperado = 4;
		
		assertEquals(resultadoEsperado, resultadoObtido);	
	}
}
