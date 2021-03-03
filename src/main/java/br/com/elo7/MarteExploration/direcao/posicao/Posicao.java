package br.com.elo7.MarteExploration.direcao.posicao;

import java.util.*;
import br.com.elo7.MarteExploration.direcao.*;

public class Posicao {
    private static int x;
    private static int y;

    public Posicao(int x, int y) {
        Posicao.x = x;
        Posicao.y = y;
    }

    public void moveNaDirecao(char direcao) {
        if (direcao == 'n') {
            Posicao.y += 1;
        } else if (direcao == 'e') {
            Posicao.x += 1;
        } else if (direcao == 's') {
            Posicao.y -= 1;
        } else {
            Posicao.x -= 1;
        }
    }

    private static boolean estaoNaMesmaPosicao(int x1, int y1, int x2, int y2) {
        if (x1 == x2 && y1 == y2) {
            return true;
        }

        return false;
    }

    private static boolean naoEstaoNaAreaDelimitada(Direcao d) {
        if (d.getX() < 0 || d.getX() > d.getLargura() || d.getY() < 0 || d.getY() > d.getAltura()) {
            return true;
        }

        return false;
    }

    private static boolean posicaoInicialInvalida(Direcao d) {
        if (d.getXInicial() < 0 ||d.getXInicial() > d.getLargura() || d.getYInicial() < 0 || d.getYInicial() > d.getAltura()) {
            return true;
        }

        return false;
    }

    private static boolean areaDelimitadaInvalida(Direcao d) {
        if (d.getLargura() <= 0 || d.getAltura() <= 0) {
            return true;
        }

        return false;
    }

    public int getX() {
        return Posicao.x;
    }

    public int getY() {
        return Posicao.y;
    }


    public static void verificaErros(ArrayList <Direcao> naves){
        for(int i = 0; i < naves.size(); i++){
            naves.get(i).ondeANaveChegou();
            if(Posicao.areaDelimitadaInvalida(naves.get(i))){
                System.out.print("\n==========================================================================================\n");
                System.out.print("Parece que algum buraco negro destruiu as dimensões de Marte! São inválidas ou nulas :(\n");
                System.out.print("==========================================================================================\n");
                System.exit(0);
            }
            else if(Posicao.posicaoInicialInvalida(naves.get(i))){
                System.out.print("\n==========================================================================================\n");
                System.out.print("Parece que a nave não pousou em Marte! Posição inicial inválida :(\n");
                System.out.print("==========================================================================================\n");
                System.exit(0);
            }
            else if(Posicao.naoEstaoNaAreaDelimitada(naves.get(i))){
                System.out.print("\n===================================================================================\n");
                System.out.print("Parece que a nave nem Marte está explorando mais! Acabou saindo do perímetro :(\n");
                System.out.print("===================================================================================\n");
                System.exit(0);
            }
            for(int j = i + 1; j < naves.size(); j++){
                naves.get(j).ondeANaveChegou();
                if(Posicao.estaoNaMesmaPosicao(naves.get(i).getX(), naves.get(i).getY(), naves.get(j).getX(), naves.get(j).getY())){
                    System.out.print("\n===================================================================================\n");
                    System.out.print("Sem mais explorações intragaláticas! As naves se chocaram :s\n");
                    System.out.print("===================================================================================\n");
                    System.exit(0);
                }
            }
            System.out.print("POSICAO FINAL NAVE " + i + ": " + naves.get(i).getX() + " " + naves.get(i).getY() + " " + naves.get(i).getDirecao() + "\n");
        }
    }
}
