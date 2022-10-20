package br.com.serratec.biblioteca.mapeador;

public interface IMapeador<E, DTO> {

	DTO paraDTO(E e);

	E paraEntidade(DTO dto);

}
