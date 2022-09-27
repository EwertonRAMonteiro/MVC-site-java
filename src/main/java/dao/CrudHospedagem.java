package dao;

import java.util.List;

import model.Hospedagem;

public interface CrudHospedagem {
	
	public static void create(Hospedagem hospedagem) {};
	public static void delete(int hospedagemId) {};
	public static List<Hospedagem> find(String pesquisa){return null;}
	public static Hospedagem findByPk(int hospedagemId) {return null;}
	public static void update(Hospedagem hospedagem) {}

}
