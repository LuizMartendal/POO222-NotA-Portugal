package module_portugal;

import java.awt.Image;
import java.nio.file.Path;

/**
 * Interface que define o comportamento de um software que retorna dados a respeito dos integrantes de uma sele��o participante da Copa do Mundo 2022
 * <br>
 * <br>Desenvolvido em Java 11.
 * 
 * @author Marcel Hugo e turma de POO 22/2 (BCC)
 *
 * @version 1.0.0
 *
 */
public interface NationalTeamInfos {
	/**
	 * M�todo para retornar a quantidade de integrantes da comitiva da sele��o.
	 * @return int - quantidade de integrantes.
	 * 
	*/
	int getHowManyMembers();
	
	/**
	 * M�todo para indicar o jogador com a maior idade (mais velho) da sele��o.
	 * 
	 * @return int - o n�mero do jogador mais velho
	 * 
	*/
	int getOldestPlayer();
	
	/**
	 * M�todo para indicar o jogador com a menor idade (mais novo) da sele��o.
	 * 
	 * @return int - o n�mero do jogador mais novo
	 * 
	*/
	int getYoungestPlayer();

	/**
	 * M�todo para retornar a idade m�dia dos jogadores da sele��o.
	 *  
	 * @return double - idade m�dia dos jogadores da sele��o.
	 * 
	*/
	double getAverageAge();

	/**
	 * M�todo para retornar os dados do jogador solicitado. 
	 * <br>
	 * Os dados retornam em uma String no formato JSON contendo os atributos em ingl�s: n�mero da camisa, nome, apelido, altura, peso, data de nascimento, posi��o.  
	 * <br>
	 * number; name; nickname; height (cm); weight (kg); birthDate (yyyy-MM-dd); position; currentClub 
	 * <br>
	 * Exemplo: {number:1, name:"Alisson Ramses Becker", nickname:"Alisson", height:191, weight:91.2, birthDate:"1992-10-02", position:"goalkeeper", currentClub:"Liverpool"}
	 * <br>
	 * <br>
	 * @param number (int) - n�mero do jogador
	 * @return String - JSON com os dados do jogador
	 * <br>  Caso o n�mero n�o seja v�lido, a String deve retornar nula (null).
	*/
	String getPlayer(int number);

	/**
	 * M�todo que retorna os dados de contato do dirigente respons�vel pela rela��o com a imprensa (assessor de imprensa ou porta-voz).
	 * <br>
	 * Os dados retornam em uma String no formato JSON contendo os atributos em ingl�s: nome, telefone1, telefone2, conta de email.  
	 * <br>
	 * name; tel1; tel2; emailAccount 
	 * <br>
	 * Exemplo: {name:"Paulo Castro Soares", tel1:"+5521989876543", tel2:"+974992008765", emailAccount:"pcsoares@cbf.com.br"}
	 * <br>
	 * @return String - JSON com os dados de contato do assessor de imprensa
	 * 
	*/
	String getPressOfficerContacts();

	/**
	 * M�todo que retorna o nome do pa�s representado pela sele��o.
	 *   
	 * @return String - nome do pa�s.
	 * 
	*/
	String getCountryName();
	
	/**
	 * M�todo que retorna a imagem da bandeira do pa�s.
	 *   
	 * @return Image - um objeto de Image contendo a imagem da bandeira do pa�s.
	 * 
	*/
	Image getFlagImage();

	/**
	 * M�todo para retornar o Path do arquivo JSON criado com os dados de todos os membros da comiss�o t�cnica da sele��o.
	 * <br>
	 * Os dados de um membro contendo os atributos em ingl�s: nome, apelido, fun��o, idade.  
	 * <br>
	 * name; nickname; role; age 
	 * <br>
	 * Exemplo: {name:"Adenor Leonardo Bachi", nickname:"Tite", role:"Main coach", age:61}
	 * <br> Lembre-se que ser�o v�rios membros da comiss�o t�cnica.
	 * 
	 * @return Path - o caminho de onde foi gravado o arquivo JSON. 
	 * 
	*/
	Path getTechnicalCommittee();

	/**
	 * M�todo para retornar o objeto que responde pelas estat�sticas de consulta - interface NationalTeamStats.
	 * <br>
	 * 
	 * 
	 * @return NationalTeamStats - objeto que implementa a interface NationalTeamStats. 
	 * 
	*/
	NationalTeamStats getStatsResponsible();
	

}

