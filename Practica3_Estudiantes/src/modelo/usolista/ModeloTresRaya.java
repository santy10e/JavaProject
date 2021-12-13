package modelo.usolista;

// @author "Santiago Tene"
public class ModeloTresRaya {

    private byte turno = 1;
    private String X = "X";
    private String O = "O";
    private boolean error = false;
    private byte ganador = 0;
    private String tab[][] = {{"", "", ""}, {"", "", ""}, {"", "", ""}};

    public ModeloTresRaya() {
    }

    public void JugarNuevamente() {
        for (int j = 0; j < tab.length; j++) {
            for (int k = 0; k < tab.length; k++) {
                tab[j][k] = "";
                this.error = false;
                this.ganador = 0;
                this.turno = 1;
            }
        }
    }

    public String setearMovimiento(int posicion) {
        String out = "";
        if (turno == 1) {
            out = marcarJugador(posicion, this.X);
            turno = 2;
            if (gana(this.tab, this.X)) {
                this.ganador = 1;
            } else if (empate()) {
                this.ganador = 3;
            }
        } else {
            out = marcarJugador(posicion, this.O);
            turno = 1;
            if (gana(this.tab, this.O)) {
                this.ganador = 2;
            } else if (empate()) {
                this.ganador = 3;
            }
        }
        return out;
    }

    private String marcarJugador(int Posicion, String value) {
        String señal = "";
        switch (Posicion) {
            case 1:
                señal = subSeñal(0, 0, value);
                break;
            case 2:
                señal = subSeñal(0, 1, value);
                break;
            case 3:
                señal = subSeñal(0, 2, value);
                break;
            case 4:
                señal = subSeñal(1, 0, value);
                break;
            case 5:
                señal = subSeñal(1, 1, value);
                break;
            case 6:
                señal = subSeñal(1, 2, value);
                break;
            case 7:
                señal = subSeñal(2, 0, value);
                break;
            case 8:
                señal = subSeñal(2, 1, value);
                break;
            case 9:
                señal = subSeñal(2, 2, value);
                break;
        }
        return señal;
    }

    private String subSeñal(int x, int y, String value) {
        String marca = "";
        this.error = false;
        if (this.tab[x][y].equals("")) {
            this.tab[x][y] = value;
            marca = value;
        } else {
            marca = this.tab[x][y];
            this.error = true;
        }
        return marca;
    }

    public boolean get_error() {
        return this.error;
    }

    public String get_turno() {
        return (this.turno == 1) ? "Turno: X" : "Turno: O";
    }

    public byte ganador() {
        return this.ganador;
    }

    public boolean gana(String matriz[][], String marca) {
        for (int i = 0; i < matriz.length; i++) {
            byte count = 0;
            for (int j = 0; j < matriz.length; j++) {
                count += (matriz[i][j].equals(marca)) ? 1 : 0;
            }
            if (count == 3) {
                return true;
            }
        }
        for (int j = 0; j < matriz.length; j++) {
            byte count = 0;
            for (int i = 0; i < matriz.length; i++) {
                count += (matriz[i][j].equals(marca)) ? 1 : 0;
            }
            if (count == 3) {
                return true;
            }
        }
        if (matriz[0][0].equals(marca) && matriz[1][1].equals(marca) && matriz[2][2].equals(marca)) {
            return true;
        }

        if (matriz[0][2].equals(marca) && matriz[1][1].equals(marca) && matriz[2][0].equals(marca)) {
            return true;
        }

        return false;
    }

    private boolean empate() {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                if (tab[i][j].equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

}
