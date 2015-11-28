package restaurante.modelo.lote;

/**
 * 
 * @author Thiago
 * @version 1.0
 */


import java.util.List;


import restaurante.util.DAOFactory;

public class LoteRN {
	
private LoteDAO loteDAO;
	

	public LoteRN(){
		this.loteDAO = DAOFactory.criarLoteDAO();
	}
	
	
	public Lote carregar(Integer idLote){
		return this.loteDAO.carregar(idLote);
	}

	
	public void alterar(Lote lote){
		this.loteDAO.alterar(lote);
	}
	
	
	public void salvar(Lote lote){
		Integer idLote = lote.getIdLote();
		if (idLote == null || idLote == 0){
			this.loteDAO.salvar(lote);
		} else{
			this.loteDAO.alterar(lote);
		}
	}
	
	public void excluir(Lote lote){
		this.loteDAO.excluir(lote);
	}
	
	public List<Lote> listar() {
		return this.loteDAO.listarLotes();
	}

	

}
