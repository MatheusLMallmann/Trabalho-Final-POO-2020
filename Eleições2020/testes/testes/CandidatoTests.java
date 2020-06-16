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


public class CandidatoTests {
	
	@Test
	public void recebendoVotoCertoTest() throws EleitorJaVotouException, CandidatoNullException, EleitorNullException{
		List<Candidato> listaCandidato = new ArrayList<Candidato>();
		List<Eleitores> listaEleitor = new ArrayList<Eleitores>();
		
		listaCandidato.add(new Candidato("Jose", "PT", 25, 055));
		listaCandidato.add(new Candidato("Sao Manoel", "PS", 25, 024));
		listaEleitor.add(new Eleitores("Agostinho", "021457", LocalDate.of(2000, Month.JANUARY, 12)));
		
		listaEleitor.get(0).votar(055, listaCandidato);
		
		int qtdVotosEsperada = 1;
		
		int qtdVotosRecebida = listaCandidato.get(0).getVotos();
		
		assertEquals(qtdVotosEsperada, qtdVotosRecebida);
		
	}
	
	@Test
	public void toStringCorretoTest() throws EleitorJaVotouException, EleitorNullException, CandidatoNullException {
		List<Candidato> listaCandidato = new ArrayList<Candidato>();
		List<Eleitores> listaEleitor = new ArrayList<Eleitores>();
		
		listaCandidato.add(new Candidato("Jose", "PT", 25, 055));
		listaEleitor.add(new Eleitores("Manuel", "021545", LocalDate.of(2000, Month.JANUARY, 12)));
		
		listaEleitor.get(0).votar(055, listaCandidato);
		
		String resultadoEsperado = "JOSE, PT,  idade: 25,  votos: 1";
		String resultadoRecebido = listaCandidato.get(0).toString();
		
		assertEquals(resultadoEsperado, resultadoRecebido);
		
	}
}
