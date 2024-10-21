package org.example.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "Humano")
public class Humano extends EntidadBase{

    private List<String> dna = new ArrayList<String>();
    private boolean esMutante;

/*METODOS*/

    //obtiene la cantidad de columnas mutantes
    private int obtenerColumnas(Character[][] arrayDnaColumnas){
        int cantidadDeColumnasMutantes = 0;
        List<Character> columnaEvaluada = new ArrayList<Character>();

        for (int i = 0; i < arrayDnaColumnas.length; i++) {
            columnaEvaluada.removeAll(columnaEvaluada);

            for (int j = 0; j < arrayDnaColumnas.length; j++) {
                columnaEvaluada.add(arrayDnaColumnas[j][i]);
            }
            var primerLetra = columnaEvaluada.get(0);
            int contadorLetras = 1;

            for (int m = 1; m < columnaEvaluada.size(); m++) {

                if (primerLetra == columnaEvaluada.get(m)) {
                    primerLetra = columnaEvaluada.get(m);
                    contadorLetras++;

                    if (contadorLetras == 4) {
                        cantidadDeColumnasMutantes++;
                        break;
                    }

                } else {
                    primerLetra = columnaEvaluada.get(m);
                    contadorLetras = 1;
                }
            }
        }
        return cantidadDeColumnasMutantes;
    }

    //obtiene la cantidad de filas mutantes
    private int obtenerFilas(Character[][] arrayDnaFilas) {
        int cantidadDeFilasMutantes = 0;

        for (int i = 0; i < arrayDnaFilas.length; i++) {
            var filaEvaluada = Arrays.asList(arrayDnaFilas[i]);
            var primerLetra = filaEvaluada.get(0);
            int contadorLetras = 1;

            for (int m = 1; m < filaEvaluada.size(); m++) {

                if (primerLetra == filaEvaluada.get(m)) {
                    primerLetra = filaEvaluada.get(m);
                    contadorLetras++;

                    if (contadorLetras == 4) {
                        cantidadDeFilasMutantes++;
                        break;
                    }

                } else {
                    primerLetra = filaEvaluada.get(m);
                    contadorLetras = 1;
                }
            }
        }
        return cantidadDeFilasMutantes;
    }

    //obtiene la cantidad de diagonales mutantes
    private int obtenerDiagonales (List<List<Character>> arrayDnaDiagonales){
        int cantidadDeDiagonalesMutantes = 0;


        for (int i = 0; i < arrayDnaDiagonales.size() ; i++) {
            List<Character> diagonalEvaluada = arrayDnaDiagonales.get(i);
            int contadorLetras = 1;
            for (int j = 0; j < diagonalEvaluada.size() - 1; j++) {
                if (diagonalEvaluada.get(j) == diagonalEvaluada.get(j+1)) {
                    contadorLetras++;
                } else {
                    contadorLetras = 1;
                }

                if (contadorLetras == 4) {
                    cantidadDeDiagonalesMutantes++;
                    contadorLetras = 1;
                    break;
                }
            }

        }

        return cantidadDeDiagonalesMutantes;
    }

    //obtiene las diagonales de izq a derecha
    private List<List<Character>> obtenerMatrizDiagonalIzquierdaADerecha (Character[][] arrayDna) {
        List<List<Character>> diagonals = new ArrayList<>();
        int n = arrayDna.length;

        // Empezamos desde cada fila de la primera columna
        for (int row = 0; row < n; row++) {
            List<Character> diagonal = new ArrayList<>();
            int r = row;
            int c = 0;
            while (r < n && c < n) {
                diagonal.add(arrayDna[r][c]);
                r++;
                c++;
            }
            diagonals.add(diagonal);
        }

        // Empezamos desde cada columna de la primera fila (excluyendo la primera diagonal ya calculada)
        for (int col = 1; col < n; col++) {
            List<Character> diagonal = new ArrayList<>();
            int r = 0;
            int c = col;
            while (r < n && c < n) {
                diagonal.add(arrayDna[r][c]);
                r++;
                c++;
            }
            diagonals.add(diagonal);
        }

        return diagonals;
    }


    //obtiene las diagonales de derecha  a izq
    private List<List<Character>> obtenerMatrizDiagonalDerechaAIzquierda (Character[][] arrayDna) {
        List<List<Character>> diagonals = new ArrayList<>();
        int n = arrayDna.length;

        // Empezamos desde cada fila de la última columna, desde la diagonal principal para abajo
        for (int row = 0; row < n; row++) {
            List<Character> diagonal = new ArrayList<>();
            int r = row;
            int c = n - 1;
            while (r < n && c >= 0) {
                diagonal.add(arrayDna[r][c]);
                r++;
                c--;
            }
            diagonals.add(diagonal);
        }

        // Empezamos desde cada columna de la primera fila (excluyendo la primera diagonal ya calculada), desde la diagonal principal para arriba
        for (int col = n - 2; col >= 0; col--) {
            List<Character> diagonal = new ArrayList<>();
            int r = 0;
            int c = col;
            while (r < n && c >= 0) {
                diagonal.add(arrayDna[r][c]);
                r++;
                c--;
            }
            diagonals.add(diagonal);
        }
        return diagonals;
    }



    public boolean esMutante(List<String> dna) {

        var cantidadDeSecuencias = 0;
        Character[][] arrayDna = new Character[dna.size()][dna.size()];

        //formo el array de nXn
        for (var i = 0; i < dna.size(); i++) {
            //selecciono la fila 1 de dna
            String fila = dna.get(i);

            for (var j = 0; j < fila.length(); j++) {

                arrayDna[i][j] = (Character.valueOf(fila.charAt(j)));

            }
        }

        //llamo a las funciones que me analizan la cantidad de filas, columnas y diagonales mutantes que tengo
        cantidadDeSecuencias += obtenerFilas(arrayDna);

        if (cantidadDeSecuencias <= 1) {
            cantidadDeSecuencias += obtenerColumnas(arrayDna);
        }

        if (cantidadDeSecuencias <= 1) {
            List<List<Character>> arrayDiagonalesDeIzquierdaADerecha = obtenerMatrizDiagonalIzquierdaADerecha(arrayDna);
            cantidadDeSecuencias += obtenerDiagonales(arrayDiagonalesDeIzquierdaADerecha);
        }

        if (cantidadDeSecuencias <= 1) {
            List<List<Character>> arrayDiagonalesDeDerechaAIzquierda = obtenerMatrizDiagonalDerechaAIzquierda(arrayDna);
            cantidadDeSecuencias += obtenerDiagonales(arrayDiagonalesDeDerechaAIzquierda);
        }

        //asigno una variable local al metodo que va a ser true si tengo mas de una secuencia de mutacion
        boolean esMutante = (cantidadDeSecuencias > 1);
        //seteo el atributo esMutante
        setEsMutante(esMutante);

        return esMutante;
    }
/*METODOS*/
}

