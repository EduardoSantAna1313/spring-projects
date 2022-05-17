package br.com.edu.start.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Model to Client
 * 
 * @author Eduardo
 */
@Entity
@Table(name = "Client")
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8052578332535735995L;

	/**
	 * codCli - Integer</br>
	 */
	@Id
	@Column(name = "cod_cli")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codCli;

	/**
	 * nomeCli - String</br>
	 */
	@Column(name = "nome_cli", length = 100)
	private String nomeCli;

	/**
	 * dataNasc - Date</br>
	 */
	@Column(name = "data_nasc")
	private Date dataNasc;

	/**
	 * cidadeNasc - String</br>
	 */
	@Column(name = "cidade_nasc", length = 100)
	private String cidadeNasc;

	/**
	 * paiCli - String</br>
	 */
	@Column(name = "pai_cli", length = 100)
	private String paiCli;

	/**
	 * maeCli - String</br>
	 */
	@Column(name = "mae_cli", length = 100)
	private String maeCli;

	/**
	 * cpfCli - String</br>
	 */
	@Column(name = "cpf_cli", length = 14)
	private String cpfCli;

	/**
	 * rgCli - String</br>
	 */
	@Column(name = "rg_cli", length = 20)
	private String rgCli;

	/**
	 * dataCad - Timestamp</br>
	 */
	@Column(name = "data_cad")
	private Timestamp dataCad;

	/**
	 * @return the codCli
	 */
	public Integer getCodCli() {
		return codCli;
	}

	/**
	 * @param codCli
	 *                   the codCli to set
	 */
	public void setCodCli(Integer codCli) {
		this.codCli = codCli;
	}

	/**
	 * @return the nomeCli
	 */
	public String getNomeCli() {
		return nomeCli;
	}

	/**
	 * @param nomeCli
	 *                    the nomeCli to set
	 */
	public void setNomeCli(String nomeCli) {
		this.nomeCli = nomeCli;
	}

	/**
	 * @return the dataNasc
	 */
	public Date getDataNasc() {
		return dataNasc;
	}

	/**
	 * @param dataNasc
	 *                     the dataNasc to set
	 */
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	/**
	 * @return the cidadeNasc
	 */
	public String getCidadeNasc() {
		return cidadeNasc;
	}

	/**
	 * @param cidadeNasc
	 *                       the cidadeNasc to set
	 */
	public void setCidadeNasc(String cidadeNasc) {
		this.cidadeNasc = cidadeNasc;
	}

	/**
	 * @return the paiCli
	 */
	public String getPaiCli() {
		return paiCli;
	}

	/**
	 * @param paiCli
	 *                   the paiCli to set
	 */
	public void setPaiCli(String paiCli) {
		this.paiCli = paiCli;
	}

	/**
	 * @return the maeCli
	 */
	public String getMaeCli() {
		return maeCli;
	}

	/**
	 * @param maeCli
	 *                   the maeCli to set
	 */
	public void setMaeCli(String maeCli) {
		this.maeCli = maeCli;
	}

	/**
	 * @return the cpfCli
	 */
	public String getCpfCli() {
		return cpfCli;
	}

	/**
	 * @param cpfCli
	 *                   the cpfCli to set
	 */
	public void setCpfCli(String cpfCli) {
		this.cpfCli = cpfCli;
	}

	/**
	 * @return the rgCli
	 */
	public String getRgCli() {
		return rgCli;
	}

	/**
	 * @param rgCli
	 *                  the rgCli to set
	 */
	public void setRgCli(String rgCli) {
		this.rgCli = rgCli;
	}

	/**
	 * @return the dataCad
	 */
	public Timestamp getDataCad() {
		return dataCad;
	}

	/**
	 * @param dataCad
	 *                    the dataCad to set
	 */
	public void setDataCad(Timestamp dataCad) {
		this.dataCad = dataCad;
	}

	@Override
	public String toString() {
		return "Cliente [codCli=" + codCli + ", nomeCli=" + nomeCli + ", dataNasc=" + dataNasc + ", cidadeNasc="
				+ cidadeNasc + ", paiCli=" + paiCli + ", maeCli=" + maeCli + ", cpfCli=" + cpfCli + ", rgCli=" + rgCli
				+ ", dataCad=" + dataCad + "]";
	}

}