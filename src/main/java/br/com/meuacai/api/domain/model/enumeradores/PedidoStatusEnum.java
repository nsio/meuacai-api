package br.com.meuacai.api.domain.model.enumeradores;

public enum PedidoStatusEnum {
	
	ABERTO("Em aberto"),
	FINALIZADO("Finalizado");
	
    private String status;
 
    PedidoStatusEnum(String status) {
        this.status = status;
    }
 
    public String getUrl() {
        return status;
    }
	
}
