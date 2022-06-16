import java.io.*;
import java.util.Scanner;

public class Plane implements Serializable{

    private  float fuelLevel;
    private String pilotCallSign;
    private String squadNumber;

    private boolean flaps = true;
    private boolean landingGear = true;
    private boolean ejectionSystem = false;

    private boolean seatOccupation = true;

    public Plane() {

    }

    public Plane(float fuelLevel, String pilotCallSign, String squadNumber) {
            this.fuelLevel = fuelLevel;
            this.pilotCallSign = pilotCallSign;
            this.squadNumber = squadNumber;
        }

    public boolean isSeatOccupation() {
        return seatOccupation;
    }

    public static Plane createPlane(){
        Scanner scanner = new Scanner(System.in);
        float nivelCombustible = 0;
        String apodoPiloto = "";
        String numeroEscuadron = "";

        System.out.println("Introduzca los litros de autonomía: ");
        nivelCombustible = scanner.nextFloat();
        scanner.nextLine();

        System.out.println("Introduzca el apodo del piloto: ");
        apodoPiloto = scanner.nextLine();


        System.out.println("Introduzca el número de escuadrón: ");
        numeroEscuadron = scanner.nextLine();

        Plane plane = new Plane(nivelCombustible,apodoPiloto,numeroEscuadron);
        System.out.println(plane);

        return plane;
    }

        public void toggleFlaps() {
            flaps = !flaps;
        }

        public void toggleLandingGear() {
            landingGear = !landingGear;
        }

        public void ejectionSystem() {
            ejectionSystem = !ejectionSystem;
        }

        public boolean getEyectionSystem() {
            return ejectionSystem;
        }

        public void setSeatOccupation(boolean pilotSeated) {
            seatOccupation = pilotSeated;

        }

        @Override
        public String toString() {
            return  "\n <><><><><>Plane<><><><><>" + '\n' +
                    "FuelLevel:      " + fuelLevel + '\n' +
                    "PilotCallSign:  " + pilotCallSign + '\n' +
                    "SquadNumber=:   " + squadNumber + '\n' +
                    "--------------------------"+ '\n' +
                    "Flaps:          " +  flaps  + '\n' +
                    "LandingGear:    " + landingGear + '\n' +
                    "EjectionSystem: " + ejectionSystem + '\n' +
                    "SeatOccupation: " + seatOccupation ;
        }

    }
