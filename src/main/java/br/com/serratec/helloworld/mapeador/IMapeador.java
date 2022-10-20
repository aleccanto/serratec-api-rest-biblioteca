package br.com.serratec.helloworld.mapeador;

public interface IMapeador<E, DTO> {

	DTO paraDTO(E e);

	E paraEntidade(DTO dto);

}
