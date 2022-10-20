package br.com.serratec.helloworld.controlador;

import java.util.List;

public interface IControlador<ENTIDADE> {

	public List<ENTIDADE> encontrarTodos();

	public ENTIDADE encontrarPorId(Long id);

	public ENTIDADE criar(ENTIDADE entidade);

	public ENTIDADE atualizar(Long id, ENTIDADE entidade);

	public ENTIDADE deletarPorId(Long id);

}
