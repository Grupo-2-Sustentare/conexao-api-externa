package school.sptech.democonexaoapiexterna.dto;

public class QtdItensResponse {
    private int somaQtdItens;

    public QtdItensResponse(int somaQtdItens) {
        setSomaQtdItens(somaQtdItens);
    }

    public int getSomaQtdItens() {
        return somaQtdItens;
    }

    public void setSomaQtdItens(int somaQtdItens) {
        this.somaQtdItens = somaQtdItens;
    }
}
