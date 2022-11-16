

/**
 * Interface que retorna estat�sticas sobre as consultas efetuadas por meio da interface NationalTeamInfos a uma sele��o participante da Copa do Mundo 2022.
 * <br>
 * <br>Desenvolvido em Java 11.
 * 
 * @author Marcel Hugo e turma de POO 22/2 (BCC)
 *
 * @version 1.0.1
 *
 */

public interface NationalTeamStats {
	/**
	 * M�todo para retornar a quantidade de vezes que os m�todos que foram chamados externamente (interface NationalTeamInfos) em todas as execu��es da classe representado a sele��o participante.
	 * @return int - quantidade de chamadas de todos os m�todos.
	 * 
	*/
	int getHowManyQuestions();
	
	/**
	 * M�todo para retornar a quantidade de consultas sobre um determinado jogador (m�todo getPlayer). 
	 * <br>
	 * @param number (int) - n�mero do jogador
	 * @return int - quantidade de vezes que o m�todo getPlayer foi acionado para o jogador indicado.
	*/
	int getHowManyCallsToPlayer(int number);

}
