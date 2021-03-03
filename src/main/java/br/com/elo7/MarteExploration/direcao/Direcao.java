package br.com.elo7.MarteExploration.direcao;
import br.com.elo7.MarteExploration.direcao.posicao.Posicao;


public class Direcao {
    private int x;
    private int y;
    private int xInicial;
    private int yInicial;
    private char direcao;
    private String movimentos;
    private int altura;
    private int largura;


    public Direcao(int x, int y, int altura, int largura, String movimentos, char direcaoInicial) {
        this.x = x;
        this.y = y;
        this.xInicial = x;
        this.yInicial = y;
        this.altura = altura;
        this.largura = largura;
        this.movimentos = movimentos.toLowerCase();
        this.direcao = Character.toLowerCase(direcaoInicial);
    }
    
    public char getdirecaoInicial() {
        return this.direcao;
    }

    public int getXInicial(){
        return this.xInicial;
    }

    public int getYInicial(){
        return this.yInicial;
    }

    public int getX(){
        return this.x;
    
    }

    public int getY(){
        return this.y;
    }

    public char getDirecao(){
        return Character.toUpperCase(this.direcao);
    }

    public int getAltura(){
        return this.altura;
    }

    public int getLargura(){
        return this.largura;
    }

    private char verificaDirecao(char aleatorio) {
        if (aleatorio == 'n') {
            return 'n';
        } else if (aleatorio == 'e') {
            return 'e';
        } else if (aleatorio == 's') {
            return 's';
        } else if (aleatorio == 'w') {
            return 'w';
        } else {
            throw new RuntimeException();
        }
    }

    public String retornaRotacao() {
        char direcaoInicial = this.getdirecaoInicial();
        if (direcaoInicial == 'n') {
            return "nwse";
        } else if (direcaoInicial == 'e') {
            return "enws";
        } else if (direcaoInicial == 's') {
            return "senw";
        } else {
            return "wsen";
        }
    }

    public String ondeANaveChegou() {
        Posicao posicao = new Posicao(this.x, this.y);
        int qtL = 0;
        int qtR = 0;
        int diferenca = 0;

        this.verificaDirecao(this.direcao);
        String rotacaoInicial = this.retornaRotacao();

        for (int i = 0; i < this.movimentos.length(); i++) {
            if (this.movimentos.charAt(i) == 'l') {
                qtL++;
                diferenca = qtL - qtR;
                if (diferenca >= 0) {
                    this.direcao = rotacaoInicial.charAt(diferenca % 4);
                } else if(diferenca < 0 && diferenca < -4){
                    this.direcao = rotacaoInicial.charAt((-1 * diferenca) % 4);
                }else{
                    this.direcao = rotacaoInicial.charAt((4 + diferenca) % 4);
                }
                
            } else if (this.movimentos.charAt(i) == 'r') {
                qtR++;
                diferenca = qtL - qtR;
                if (diferenca >= 0) {
                    this.direcao = rotacaoInicial.charAt(diferenca % 4);
                } else if(diferenca < 0 && diferenca < -4){
                    this.direcao = rotacaoInicial.charAt((-1 * diferenca) % 4);
                } else {
                    this.direcao = rotacaoInicial.charAt((4 + diferenca) % 4);
                }

            } else if (this.movimentos.charAt(i) == 'm') {
                posicao.moveNaDirecao(this.direcao);
                
            } else {
                throw new RuntimeException();
            }
        }
        
        this.x = posicao.getX();
        this.y = posicao.getY();
        

        return x + " " + y + " " + this.direcao;
    }

}
