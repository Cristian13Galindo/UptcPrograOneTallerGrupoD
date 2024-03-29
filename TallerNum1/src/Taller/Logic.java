package Taller;

import java.time.LocalDate;
import java.time.Month;

import javax.swing.JOptionPane;

public class Logic {
    static boolean repetir;


    public static void menu() {
        String myMenu = "<<<<<<MENU PRINCUPAL>>>>>>\n\n" +
                "A. Convertir numeros romanos a decimal\n" +
                "B. calculo factores primos\n" +
                "C. Borrar espacios de cadenas\n" +
                "D. Verificador numeros egolatras\n"+
                "E. Verificador número magico\n"+
                "F. Fechas\n\n"+
                "X. Salir";

        char option = '0';
        do {

            try{
                option = JOptionPane.showInputDialog(myMenu).charAt(0);
            }catch(NullPointerException e ){

            }

            switch (Character.toUpperCase(option)) {
                case 'A':
                    inputRomano();
                    break;

                case 'B':
                    inputFactor();
                    break;

                case 'C':
                    inputCadena();
                    break;

                case 'D':
                    inputEgolatra();
                    break;

                case 'E':
                    inputMagic();
                    break;

                case 'F':
                    inputFecha();
                    break;
            }

        } while (Character.toUpperCase(option) != 'X');
    }

    /**
     * este metodo convierte un numero romano a u numero decimal
     */
    private static void inputRomano() {//1.NUMEROS ROMANOS

        String cadena = JOptionPane.showInputDialog("Digite un numero romano");

        int tamcadena=cadena.length();
        String [] cadenaSeparada=new String[tamcadena];
        int cadenaNumerica[]=new int[tamcadena];
        int numDecimal=0;
        int aux=0;

        for(int i=0;i<cadenaSeparada.length;i++) {
            cadenaSeparada[i]=cadena.substring(i,i+1);// SEPARAR CADA LETRA Y GUARDARLA EN UNA POSICION DEL ARREGLO
        }

        for(int i=0;i<cadenaSeparada.length;i++) {

            if(cadenaSeparada[i].equals("i") || cadenaSeparada[i].equals("I")) {
                cadenaNumerica[i]=1;
            }else if(cadenaSeparada[i].equals("v") || cadenaSeparada[i].equals("V")) {
                cadenaNumerica[i]=5;
            }else if(cadenaSeparada[i].equals("x") || cadenaSeparada[i].equals("X")) {
                cadenaNumerica[i]=10;
            }else if(cadenaSeparada[i].equals("l") || cadenaSeparada[i].equals("l")){
                cadenaNumerica[i]=50;
            }else if(cadenaSeparada[i].equals("c") || cadenaSeparada[i].equals("C")) {
                cadenaNumerica[i]=100;
            }else if(cadenaSeparada[i].equals("d") || cadenaSeparada[i].equals("D")) {
                cadenaNumerica[i]=500;
            }else if(cadenaSeparada[i].equals("m") || cadenaSeparada[i].equals("M")) {
                cadenaNumerica[i]=1000;
            }else {
                aux=1;
            }
        }

        for(int i=0;i<cadenaNumerica.length;i++) {
            if(i<tamcadena-1) {
                if(cadenaNumerica[i]<cadenaNumerica[i+1]){//SI LA LETRA ANTERIOR ES MENOR A LA SIGUIENTE SE RESTA
                    numDecimal=numDecimal-cadenaNumerica[i];
                }else {
                    numDecimal=numDecimal+cadenaNumerica[i];
                }
            }else {
                numDecimal=numDecimal+cadenaNumerica[i];
            }
        }
        if(aux!=1) {
            JOptionPane.showMessageDialog(null, "El numero "+cadena+" es equivalente a "+numDecimal);
        }else {
            JOptionPane.showMessageDialog(null, "Entrada no valida");
        }
    }
    /**
     * este metodo halla los factores primos de un numero y lo expresa en forma de potencia
     */

    private static void inputFactor() {//2.NUMEROS PRIMOS

        int num=0;
        int listafactores[]=new int[10];
        int cont=1;
        String cadena="";

        do {
            try {
                num = Integer.parseInt(JOptionPane.showInputDialog("Digite Numero"));
                repetir=false;
            }catch(java.lang.NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"error");
                repetir=true;
            }
        }while(repetir);
        isFactor(num, listafactores);

        for(int i=0;i<listafactores.length-1;i++) {
            if(listafactores[i]==listafactores[i+1]) {//VECES QUE EL NUMERO ESTA REPETIDO
                cont++;

            }else {
                cadena=listafactores[i]+"^"+cont+"*"+cadena;
                cont=1;
            }
        }
        JOptionPane.showMessageDialog(null, cadena);
    }
    /**
     *
     * @param num es el número que el usuario ingresa
     * @param listafactores este erreglo guarda los factores primos del numero ingresado
     * @return un arreglo con los numeros primos del numero
     */

    private static int[] isFactor( int num, int[]listafactores ){//2.NUMEROS PRIMOS - LOGICA

        int k=0;
        int divisor=2;

        while(num !=1) {
            if(num%divisor==0) {
                listafactores[k]=divisor;
                num=num/divisor;
                k++;
            }else {
                divisor++;
            }
        }

        return listafactores;
    }
    /**
     * Este metodo borra los espacios de una cadena ingresada por el usuario
     */
    private static void inputCadena() {//3.CADENA
        // TODO Auto-generated method stub
        String cadena=JOptionPane.showInputDialog("Digite el texto");

        String result = cadena.replaceAll("\\s+","");
        JOptionPane.showMessageDialog(null, result);
    }

    /**
     * Este metodo valida si el numero ingresado por el usuario es un numero egolatra
     */
    private static void inputEgolatra() {//4.NUMERO EGOLATRA

        int number=0;

        do {
            try {
                number =Integer.parseInt(JOptionPane.showInputDialog("Digite Numero"));
                repetir=false;
            }catch(java.lang.NumberFormatException e) {
                repetir=true;
                JOptionPane.showMessageDialog(null,"error");
            }
        }while(repetir);
        String numEgolatra=String.valueOf(number);

        if( isEgolatra( numEgolatra ) ){
            JOptionPane.showMessageDialog(null,"El numero "+ numEgolatra + " es un número egolatra","SUCCEES",JOptionPane.PLAIN_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"El numero "+ numEgolatra + " no es un numero egolatra","SUCCEES",JOptionPane.ERROR_MESSAGE);
        }

    }
    /**
     *
     * @param numEgolatra recibe un numero para ser evaluado si es o no egolatra
     * @return un boolean que determina si es o no un numero egolatra
     */
    private static boolean isEgolatra( String numEgolatra ){//4.NUMERO EGOLATRA - LOGICA

        int tamNumero=numEgolatra.length();
        int [] numerosSeparados=new int[tamNumero];
        int [] sumaEgolatra=new int[tamNumero];

        int exponente=1;
        int totalEgolatra=0;


        for(int i=0;i<numerosSeparados.length;i++) {
            numerosSeparados[i]=Integer.parseInt(numEgolatra.substring(i,i+1));// SE SEPARA EL NUMERO EN DIGITO PARA GUARDAR CADA UNO EN UNA POSICION

        }
        for(int i=0;i<numerosSeparados.length;i++) {
            sumaEgolatra[i]=numerosSeparados[i];//
            while(exponente!=tamNumero) {
                sumaEgolatra[i]=sumaEgolatra[i]*numerosSeparados[i];
                exponente++;
            }
            exponente=1;
        }
        for(int i=0;i<numerosSeparados.length;i++) {
            totalEgolatra+=sumaEgolatra[i];
        }

        return totalEgolatra==Integer.parseInt(numEgolatra);
    }

    /**
     * Este metodo valida si el numero ingresado por el usuario es un numero magico
     */
    private static void inputMagic() {//5.NUMERO MAGICO
        int number=0;

        do {
            try {
                number = Integer.parseInt(JOptionPane.showInputDialog("Digite Numero"));
                repetir=false;
            }catch(java.lang.NumberFormatException e) {
                repetir=true;
                JOptionPane.showMessageDialog(null,"error");
            }
        }while(repetir);
        String numMagic=String.valueOf(number);

        if( isMagic( numMagic ) ){
            JOptionPane.showMessageDialog(null,"El numero "+ number + " es un número magico","SUCCEES",JOptionPane.PLAIN_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"El numero "+ number + " no es un numero magico","SUCCEES",JOptionPane.ERROR_MESSAGE);
        }

    }
    /**
     *
     * @param numMagic contiene el numero ingresado por el usuario para ser evaluado
     * @return un boolean que determina si es o no un numero magico
     */
    private static boolean isMagic(String numMagic) {//5.NUMERO MAGICO - LOGICA

        int tamnumber;
        int aux=0;
        String numAscendente="";
        String numDescendente="";


        tamnumber=numMagic.length();
        int cadenaNumerica[]=new int[tamnumber];
        int cadenaDescendente[]=new int [tamnumber];

        for(int i=0;i<cadenaNumerica.length;i++) {
            cadenaNumerica[i]=Integer.parseInt(numMagic.substring(i,i+1));// SEPARAR CADA LETRA Y GUARDARLA EN UNA POSICION DEL ARREGLO
            cadenaDescendente[i]=Integer.parseInt(numMagic.substring(i,i+1));
        }


        for(int i=0;i<cadenaNumerica.length;i++) {
            for(int j=0;j<cadenaNumerica.length-1;j++) {
                if(cadenaNumerica[j]>cadenaNumerica[j+1]){
                    aux=cadenaNumerica[j];
                    cadenaNumerica[j]=cadenaNumerica[j+1];
                    cadenaNumerica[j+1]=aux;
                }
            }
        }

        for(int i=0;i<cadenaDescendente.length;i++) {
            for(int j=0;j<cadenaDescendente.length-1;j++) {
                if(cadenaDescendente[j]<cadenaDescendente[j+1]){
                    aux=cadenaDescendente[j];
                    cadenaDescendente[j]=cadenaDescendente[j+1];
                    cadenaDescendente[j+1]=aux;
                }
            }
        }

        for(int i=0;i<cadenaNumerica.length;i++){
            numAscendente=numAscendente+String.valueOf(cadenaNumerica[i]);
            numDescendente=numDescendente+String.valueOf(cadenaDescendente[i]);
        }


        return (Integer.parseInt(numDescendente)-Integer.parseInt(numAscendente))==Integer.parseInt(numMagic);

    }

    /**
     * Este metodo recibe una fecha ingresada por el usuario, la valida y muestra por pantalla la fecha con el mes en letra
     */
    private static void inputFecha() {//6.FECHA

        do {

            String number =JOptionPane.showInputDialog("Digite la fecha en formto dd/mm/aaaa");

            String[] fechaSeparada = number.split("/");
            try {

                switch (fechaSeparada[1]) {
                    case "01":

                        LocalDate.of(Integer.parseInt(fechaSeparada[2]), Month.JANUARY,Integer.parseInt(fechaSeparada[0]));
                        JOptionPane.showMessageDialog(null,fechaSeparada[0]+" de enero de "+fechaSeparada[2]);
                        break;

                    case "02":

                        LocalDate.of(Integer.parseInt(fechaSeparada[2]), Month.FEBRUARY,Integer.parseInt(fechaSeparada[0]));
                        JOptionPane.showMessageDialog(null,fechaSeparada[0]+" de febrero de "+fechaSeparada[2]);

                        break;

                    case "03":

                        LocalDate.of(Integer.parseInt(fechaSeparada[2]), Month.MARCH,Integer.parseInt(fechaSeparada[0]));
                        JOptionPane.showMessageDialog(null,fechaSeparada[0]+" de marzo de "+fechaSeparada[2]);
                        break;

                    case "04":

                        LocalDate.of(Integer.parseInt(fechaSeparada[2]), Month.APRIL,Integer.parseInt(fechaSeparada[0]));
                        JOptionPane.showMessageDialog(null,fechaSeparada[0]+" de abril de "+fechaSeparada[2]);
                        break;

                    case "05":

                        LocalDate.of(Integer.parseInt(fechaSeparada[2]), Month.MAY,Integer.parseInt(fechaSeparada[0]));
                        JOptionPane.showMessageDialog(null,fechaSeparada[0]+" de mayo de "+fechaSeparada[2]);
                        break;

                    case "06":

                        LocalDate.of(Integer.parseInt(fechaSeparada[2]), Month.JUNE,Integer.parseInt(fechaSeparada[0]));
                        JOptionPane.showMessageDialog(null,fechaSeparada[0]+" de junio de "+fechaSeparada[2]);
                        break;

                    case "07":

                        LocalDate.of(Integer.parseInt(fechaSeparada[2]), Month.JULY,Integer.parseInt(fechaSeparada[0]));
                        JOptionPane.showMessageDialog(null,fechaSeparada[0]+" de julio de "+fechaSeparada[2]);
                        break;

                    case "08":

                        LocalDate.of(Integer.parseInt(fechaSeparada[2]), Month.AUGUST,Integer.parseInt(fechaSeparada[0]));
                        JOptionPane.showMessageDialog(null,fechaSeparada[0]+" de agosto de "+fechaSeparada[2]);
                        break;

                    case "09":

                        LocalDate.of(Integer.parseInt(fechaSeparada[2]), Month.SEPTEMBER,Integer.parseInt(fechaSeparada[0]));
                        JOptionPane.showMessageDialog(null,fechaSeparada[0]+" de septiembre de "+fechaSeparada[2]);
                        break;

                    case "10":

                        LocalDate.of(Integer.parseInt(fechaSeparada[2]), Month.OCTOBER,Integer.parseInt(fechaSeparada[0]));
                        JOptionPane.showMessageDialog(null,fechaSeparada[0]+" de octubre de "+fechaSeparada[2]);
                        break;

                    case "11":

                        LocalDate.of(Integer.parseInt(fechaSeparada[2]), Month.NOVEMBER,Integer.parseInt(fechaSeparada[0]));
                        JOptionPane.showMessageDialog(null,fechaSeparada[0]+" de noviembre de "+fechaSeparada[2]);
                        break;

                    case "12":

                        LocalDate.of(Integer.parseInt(fechaSeparada[2]), Month.DECEMBER,Integer.parseInt(fechaSeparada[0]));
                        JOptionPane.showMessageDialog(null,fechaSeparada[0]+" de diciembre de "+fechaSeparada[2]);
                        break;
                }
                repetir=false;
            }catch(java.time.DateTimeException e){
                JOptionPane.showMessageDialog(null,"error digite la fecha nuevamente");
                repetir=true;
            }
        }while(repetir);
    }
}