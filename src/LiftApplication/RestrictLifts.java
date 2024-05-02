package LiftApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class RestrictLifts {
    private static List<String> liftdetails=new ArrayList<>();
    private static List<Integer> currentPostion=new ArrayList<>();

    private static void getLift(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the Current floor");
        int currentFloor=scanner.nextInt();
        System.out.println("Destination floor");
        int destination=scanner.nextInt();

        System.out.println(checkLifts(currentFloor, destination)+" is assigned");
        System.out.println(liftdetails);
        System.out.println(currentPostion);
    }

    private static String checkLifts(int currentFloor, int destination) {
        int index=0;
        String result="";
        if(destination>5 && destination<=10){
            String []lift={"L3","L4","L6"};
            for(int i=0;i<lift.length;i++){
                index=liftdetails.indexOf(lift[i]);
                if(checkFreelift(index, currentFloor, destination)){
                    result= lift[i];
                    break;
                }
            }

        }else if(destination<5){
            String []lift1={"L1","L2"};
            for(int i=0;i<lift1.length;i++){
                index=liftdetails.indexOf(lift1[i]);
                if(checkFreelift(index, currentFloor, destination)){
                    result= lift1[i];
                    break;
                }
            }

        }else{
            index=liftdetails.indexOf("L5");
            currentPostion.set(index,destination);
            result=liftdetails.get(index);
        }
        return result;
    }

    private static boolean checkFreelift(int index, int currentFloor, int destination){
        if(currentPostion.get(index)==0 || currentPostion.get(index)==currentFloor){
            currentPostion.set(index,destination);
            return true;
        }else if(currentFloor<destination){
            //downwards moves
            if(currentPostion.get(index)==currentFloor+1){
                currentPostion.set(index,destination);
                return true;
            }else if(currentPostion.get(index)==currentFloor-1){
                currentPostion.set(index,destination);
                return true;
            }
        }else if(currentFloor>destination){
            // Upward moves
            if(currentPostion.get(index)==currentFloor-1){
                currentPostion.set(index,destination);
                return true;
            }else if(currentPostion.get(index)==currentFloor+1){
                currentPostion.set(index,destination);
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int n = 6;
        MainClass m = new MainClass();
        liftdetails = m.createLift(n);
        for (int i = 1; i <= n; i++) {
            currentPostion.add(0);
        }
        //System.out.println(liftdetails);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to Zoho");
            System.out.println("1.Enter Lift \n2.Exit");
            System.out.println("Enter the choice:");
            int choice = scanner.nextInt();
            switch (choice) {
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
