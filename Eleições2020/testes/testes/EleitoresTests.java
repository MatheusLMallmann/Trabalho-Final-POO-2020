package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import classes.Candidato;
import classes.Eleitores;
import exceptions.CandidatoNullException;
import exceptions.EleitorJaVotouException;
import exceptions.EleitorNullException;

import java.util.List;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;


public class EleitoresTests {

	@Test
	public void eleitorVotarDuasVezesTest() throws EleitorJaVotouException, EleitorNullException, CandidatoNullException {
		List<Eleitores> listaEleitores = new ArrayList<Eleitores>();
		List<Candidato> listaCandidatos = new ArrayList<Candidato>();
		
		listaEleitores.add(new Eleitores("Eduardo", "215487", LocalDate.of(2004, Month.JUNE, 12)));
		listaCandidatos.add(new Candidato("Matias", "Partido Progressista", 57, 035));
		listaCandidatos.add(new Candidato("Malton", "Partido Regressista", 57, 0100));
		
		String mensagemEsperada = "Seu voto já foi computado.";
		
		try {
			listaEleitores.get(0).votar(035, listaCandidatos);
			listaEleitores.get(0).votar(0100, listaCandidatos);
		} catch (EleitorJaVotouException e) {	
			String mensagemRecebida = e.getMessage();
			assertTrue(mensagemRecebida.contains(mensagemEsperada));
		}
	}
	
	@Test
	public void votoNuloComSucessoTest() throws EleitorJaVotouException, EleitorNullException, CandidatoNullException {
		List<Eleitores> listaEleitor = new ArrayList<Eleitores>();
		List<Candidato> listaCandidato = new ArrayList<Candidato>();
		
		listaEleitor.add(new Eleitores("Gerson Ribeiro", "215487", 
				LocalDate.of(2000, Month.SEPTEMBER, 12)));
		listaCandidato.add(new Candidato("Jose Alves", "Partido Monarquista", 57, 025));
		
		Boolean retornoRecebido = listaEleitor.get(0).votar(null, listaCandidato);
		
		Boolean retornoEsperado = true;
		
		assertEquals(retornoEsperado, retornoRecebido);		
	}
	
	@Test
	public void votoBrancoComSucessoTest() throws EleitorJaVotouException, CandidatoNullException, EleitorNullException {
		List<Eleitores> listaEleitor = new ArrayList<Eleitores>();
		List<Candidato> listaCandidato = new ArrayList<Candidato>();
		
		listaEleitor.add(new Eleitores("Gerson Ribeiro", "215487", 
				LocalDate.of(2000, Month.SEPTEMBER, 12)));
		listaCandidato.add(new Candidato("Jose Alves", "Partido Monarquista", 57, 025));
		
		Boolean retornoRecebido = listaEleitor.get(0).votar(025, listaCandidato);
		
		Boolean retornoEsperado = true;
		
		assertEquals(retornoEsperado, retornoRecebido);		
	}
	
	@Test
	public void nomeEleitorNuloExceptionTest() throws EleitorNullException {
		List<Eleitores> listaEleitores = new ArrayList<Eleitores>();			
		
		String mensagemEsperada = "Nenhum campo pode ser nulificado.";
		
		try {
			listaEleitores.add(new Eleitores(null, "215487", LocalDate.of(2004, Month.JUNE, 12)));
		} catch (EleitorNullException e) {	
			String mensagemRecebida = e.getMessage();
			assertEquals(mensagemEsperada, mensagemRecebida);
		}
	}		
}
