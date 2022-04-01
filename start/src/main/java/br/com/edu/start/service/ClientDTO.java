package br.com.edu.start.service;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Business Object para a API de Clientes.
 *
 * @author Eduardo
 */
@NoArgsConstructor
@Getter
@Setter
@ToString(of = {
	"nomeCli", "dateNasc", "cidadeNasc"
})
public class ClientDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2052164217044248040L;

	/**
	 * Integer - codCli.
	 */
	private Integer codCli;

	/**
	 * String - nomeCli.
	 */
	private String nomeCli;

	/**
	 * Date - dateNasc.
	 */
	private Date dateNasc;

	/**
	 * String - cidadeNasc.
	 */
	private String cidadeNasc;

	/**
	 * String - paiCli.
	 */
	private String paiCli;

	/**
	 * String - maeCli.
	 */
	private String maeCli;

	/**
	 * String - cpfCli.
	 */
	private String cpfCli;

	/**
	 * String - rgCli.
	 */
	private String rgCli;

	/**
	 * Date - dataCad.
	 */
	private Date dataCad;

}