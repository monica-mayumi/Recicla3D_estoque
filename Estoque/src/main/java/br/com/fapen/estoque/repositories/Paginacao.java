package br.com.fapen.estoque.repositories;

import org.springframework.data.domain.PageRequest;

public class Paginacao {
	private int paginacorrente = 1;
	private int totalPaginas;
	private Long totalLinhas;
	private static final Integer REGISTROS_POR_PAGINA = 5;

	public int getPaginacorrente() {
		return paginacorrente;
	}

	public void setPaginacorrente(int paginacorrente) {
		this.paginacorrente = paginacorrente;
	}

	public int getTotalPaginas() {
		return totalPaginas;
	}

	public void setTotalPaginas(int paginas) {
		this.totalPaginas = paginas;
	}

	public Long getTotalLinhas() {
		return totalLinhas;
	}

	public void setTotalLinhas(Long totalLinhas) {
		this.totalLinhas = totalLinhas;
	}

	public static Integer getRegistrosPorPagina() {
		return REGISTROS_POR_PAGINA;
	}

	public static PageRequest getPaginacao(Integer pagina) {
		if (pagina <= 0) {
			pagina = 1;
		}
		return PageRequest.of(pagina - 1, REGISTROS_POR_PAGINA);

	}

	public boolean hasContent() {
		return getTotalPages() > 0 ? true : false;
	}

	public boolean hasPrevious() {
		boolean valida = false;
		if (getNumber() > 1) {
			valida = true;
		}
		return valida;
	}

	public boolean hasNext() {
		boolean valida = false;
		if (getNumber() < getTotalPages()) {
			valida = true;
		}
		return valida;
	}

	public int getNumber() {
		return getPaginacorrente();
	}

	public int getTotalPages() {
		
		int resto = (getTotalLinhas().intValue() % REGISTROS_POR_PAGINA);
		int paginas = (getTotalLinhas().intValue() / REGISTROS_POR_PAGINA);
		
		if ( resto > 0 ) {
			setTotalPaginas(paginas + 1);
		}else {
			setTotalPaginas(paginas);
		}
		return getTotalPaginas();
	}

}
