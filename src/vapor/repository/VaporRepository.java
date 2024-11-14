package vapor.repository;

import jogo.model.Principal;

public interface VaporRepository {
	
	public void procurarPorId(int id);
	public void listarJogos();
	public void cadastrar(Principal principal);
	public void atualizar(Principal principal);
	public void deletar(int id);

}
