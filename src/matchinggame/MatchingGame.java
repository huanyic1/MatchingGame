/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchinggame;
import java.util.Scanner; 
import java.util.Random; 
/**
 *
 * @author DELL
 */
public class MatchingGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 
      int[][] board = CreateBoard(); 
       for(int r1 =0; r1<4; r1++){
           System.out.print(r1+ "| ");
           for(int c =0; c<4; c++){
               System.out.print(board[r1][c]+" ");
           }
           System.out.println("");
       }      
        System.out.println("-----------");
        System.out.println("   0 1 2 3 ");
        
         String[][] sboard = new String[4][4]; 
       for(int r =0; r<4; r++){
           for(int c =0; c<4; c++){
               sboard[r][c]="[ ]";
           }
       }
        int moves = 0;
       while(true){
        System.out.println("");
        
           System.out.println("Moves: "+ moves);
           System.out.println("");
         for(int r1 =0; r1<4; r1++){
           System.out.print(r1+ "|");
           for(int c =0; c<4; c++){
               System.out.print(sboard[r1][c]+"");
           }
           System.out.println("");
       }      
        System.out.println("-------------");
        System.out.println("   0  1  2  3 ");
        
        System.out.println("Please enter in row of first guess");
        int a = input.nextInt(); 
         System.out.println("Please enter in column of first guess");
        int b = input.nextInt();
           System.out.println("Please enter in row of second guess");
        int c1 = input.nextInt(); 
         System.out.println("Please enter in column of second guess");
        int d = input.nextInt();
        //remember to add in while loop preventing them for entering in same location
       
        sboard[a][b]= "["+Integer.toString(board[a][b])+"]"; 
         sboard[c1][d]= "["+Integer.toString(board[c1][d])+"]"; 
        System.out.println("");
         for(int r =0; r<4; r++){
           System.out.print(r+ "|");
           for(int c =0; c<4; c++){
               System.out.print(sboard[r][c]+"");
           }
           System.out.println("");
       }      
        System.out.println("-------------");
        System.out.println("   0  1  2  3 ");
        
        if(board[a][b]==board[c1][d]){
            System.out.println("You've got a match!!");
        }
        else{
            System.out.println("Sorry! No Match!");
             sboard[a][b]= "[ ]"; 
         sboard[c1][d]="[ ]"; 
        }
        moves++; 
        int boxFilled=0; 
         for(int r =0; r<4; r++){
           for(int c =0; c<4; c++){
              if(sboard[r][c]!="[ ]"){
                  boxFilled++;  
              }
              
           }
       }    
         if(boxFilled==16){
             System.out.println("You have won!");
             System.out.println("Total Moves Taken: "+ moves);
             break; 
         }
       }
    }
    
    public static int[][] CreateBoard(){
        Random r = new Random(); 
    
        int[][] board = new int[4][4]; 
       for(int r1 =0; r1<4; r1++){
           for(int c =0; c<4; c++){
               board[r1][c]=-1;
           }
       }
        for(int i=0; i<16; i++){
            int a = r.nextInt(4);
            int b = r.nextInt(4);
            while(true){
                 if(board[a][b]!=-1){
                     a = r.nextInt(4);
                     b = r.nextInt(4);
                 }
                 else{
                     break; 
                 }
            }
            if(board[a][b]==-1){
                board[a][b]=i/2; 
            }
            
        }
        
        return board; 
    }
}
