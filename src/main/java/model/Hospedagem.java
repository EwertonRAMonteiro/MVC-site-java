package model;

public class Hospedagem {
	private int id;
	private String nomeHotel;
	private String endereco;
	private String estado;
	private String valorIntegral;
	private String checkIn;
	private String checkOut;
	private String numeroHotel;
	public Cliente cliente;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeHotel() {
		return nomeHotel;
	}
	public void setNomeHotel(String nomeHotel) {
		this.nomeHotel = nomeHotel;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getValorIntegral() {
		return valorIntegral;
	}
	public void setValorIntegral(String valorIntegral) {
		this.valorIntegral = valorIntegral;
	}
	public String getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	public String getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	public String getNumeroHotel() {
		return numeroHotel;
	}
	public void setNumeroHotel(String numeroHotel) {
		this.numeroHotel = numeroHotel;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	@Override
	public String toString() {
		return "Hospedagem [id=" + id + ", nomeHotel=" + nomeHotel + ", endereco=" + endereco + ", estado=" + estado
				+ ", valorIntegral=" + valorIntegral + ", checkIn=" + checkIn + ", checkOut=" + checkOut
				+ ", numeroHotel=" + numeroHotel + ", cliente=" + cliente + "]";
	}
	
	

}
