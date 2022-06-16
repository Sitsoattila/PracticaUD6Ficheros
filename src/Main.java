import java.io.*;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        String opcion = "";

        final String FILE_NAME = "data/plane.dat";

        FileInputStream inputFile;
        BufferedInputStream bufferedInput;
        ObjectInputStream objectInput;

        Plane f18 = null;


        try {
            inputFile = new FileInputStream(FILE_NAME);
            bufferedInput = new BufferedInputStream(inputFile);
            objectInput = new ObjectInputStream(bufferedInput);

            try{
                f18 = (Plane) objectInput.readObject();
                System.out.println("Se ha guardado el archivo correctamente.");
            }catch (IOException e){

                System.out.println("Se ha prodicido un error de entrada/salida");
            }catch (ClassNotFoundException e){
                System.out.println("Error de lectura.");
            }
        }catch (FileNotFoundException ex){
            System.out.println("No se ha encontrado un archivo con información.");
        }catch(IOException e){
            System.out.println("Se ha preoducido un error de entrada/salida.");
        }

        FileOutputStream outputFile = null;
        BufferedOutputStream  bufferedOutput = null;
        ObjectOutputStream objectOutput = null;

        boolean menu = false;

        while (!menu) {
            System.out.println("1 - Inicializar F18\n" +
                    "2 - Alternar estado de los flaps.\n" +
                    "3 - Alternar estado del tren de aterrizaje.\n" +
                    "4 - Armar sistema de eyección \n" +
                    "5 - Eyectar piloto \n" +
                    "Q - Salir.\n");

            System.out.print("Seleccione una opción: ");
            opcion = lector.nextLine();

            switch (opcion) {

                case "1":

                    f18 = f18.createPlane();

                break;


                case "2":
                    if (f18 != null) {
                        f18.toggleFlaps();
                        System.out.println(f18);
                    } else {
                        System.out.println("Aun no se ha creado un avión");
                    }


                break;

                case "3":

                    if (f18 != null) {
                        f18.toggleLandingGear();
                        System.out.println(f18);
                    } else {
                        System.out.println("Aun no se ha creado un avión");
                    }

                break;

                case "4":

                    if (f18 != null) {
                        f18.ejectionSystem();
                        System.out.println(f18);
                    } else {
                        System.out.println("Aun no se ha creado un avión");
                    }

                break;

                case "5":

                    if (f18 != null) {
                        if (f18.getEyectionSystem()) {
                            f18.setSeatOccupation(false);
                            System.out.println(f18);
                        } else {
                            System.out.println("El sistema de eyección está desactivado");
                        }

                    } else {
                        System.out.println("Aun no se ha creado un avión");
                    }

                break;

                case "Q":
                case "q":

                    try{

                        outputFile = new FileOutputStream(FILE_NAME);
                        bufferedOutput = new BufferedOutputStream(outputFile);
                        objectOutput = new ObjectOutputStream(bufferedOutput);

                        objectOutput.writeObject(f18);


                    } catch (FileNotFoundException e) {
                        System.out.println("No se ha encontrado el archivo o la ruta especificada no existe.");;
                    } catch (IOException e) {
                        System.out.println("Se ha producido un error de entrada/salida.");;
                    }finally {

                        try{
                            if (objectOutput != null) objectOutput.close();
                            if (bufferedOutput != null) objectOutput.close();
                            if (outputFile != null) objectOutput.close();


                        }catch (IOException e) {
                            System.out.println("No se ha podido cerrar el archivo");
                        }
                    }

                    menu = true;
                    break;

                default:
                    System.out.println("Introduzca un valor valido");
                }
            }
        }
    }


