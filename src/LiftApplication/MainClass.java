package LiftApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {
    private static List<String> liftdetails=new ArrayList<>();
    private static List<Integer> currentPostion=new ArrayList<>();

    public static List<String> createLift(int n) {
        for(int i=1;i<=n;i++){
            liftdetails.add("L"+i);
        }
        return liftdetails;
    }

    //Enter the source and destination
    private static void getLift() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the Current floor");
        int currentFloor=scanner.nextInt();
        System.out.println("Destination floor");
        int destination=scanner.nextInt();
        System.out.println(checkNearByLift(currentFloor, destination)+" is assigned");
        System.out.println(liftdetails);
        System.out.println(currentPostion);

    }

    //Check the nearest lift to the source
    private static String checkNearByLift(int currentFloor, int destination) {
        int index=0;
        if(currentPostion.contains(currentFloor)) {
            index=currentPostion.indexOf(currentFloor);
            currentPostion.set(index,destination);
            return liftdetails.get(index);
        }
        if(currentFloor<destination){
            // downwards
            if(currentPostion.contains(currentFloor+1)){
                index=currentPostion.indexOf(currentFloor+1);
                currentPostion.set(index,destination);
                return liftdetails.get(index);
            }
            else if (currentPostion.contains(currentFloor-1)) {
                index=currentPostion.indexOf(currentFloor-1);
                currentPostion.set(index,destination);
                return liftdetails.get(index);
            }
        }else if (currentFloor>destination){
            // upward moves
            if (currentPostion.contains(currentFloor-1)) {
                index=currentPostion.indexOf(currentFloor-1);
                currentPostion.set(index,destination);
                return liftdetails.get(index);
            }else if(currentPostion.contains(currentFloor+1)){
                index=currentPostion.indexOf(currentFloor+1);
                currentPostion.set(index,destination);
                return liftdetails.get(index);
            }
        }else{
            index=currentPostion.indexOf(0);
            currentPostion.set(index, destination);
            return liftdetails.get(index);
        }

        if (currentPostion.contains(currentFloor-1)) {
            index=currentPostion.indexOf(currentFloor-1);
            currentPostion.set(index,destination);
            return liftdetails.get(index);
        }else{
            index=currentPostion.indexOf(0);
            currentPostion.set(index, destination);
            return liftdetails.get(index);
        }
    }
    public static void main(String[] args) {
        int n=5;
        liftdetails=createLift(n);

        for(int i=1;i<=n;i++){
            currentPostion.add(0); // let me consider as all in the 0 floor
        }
        System.out.println(liftdetails);
        Scanner scanner=new Scanner(System.in);
        while(true){
            System.out.println("Welcome to Zoho");
            System.out.println("1.Enter Lift \n2.Exit");
            System.out.println("Enter the choice:");
            int choice=scanner.nextInt();
            switch (choice){
                case 1:
                    getLift();
                    break;
                case 2:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid input");
                    System.exit(0);
            }
        }


    }


}
