/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saalgoritm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Farzaneh
 */
public class SAAlgoritm {
static int n=0;
ArrayList<Integer> array;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SAAlgoritm sa=new SAAlgoritm();
    int a[][]=new int[4][4];
        for (int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                a[j][i]=i+1;
            }
        }
//        int b[][]=new int[4][4];
//        b[0][0]=1;
//          b[0][0]=1;
//          b[0][1]=2;
//          b[0][2]=3;
//          b[0][3]=4;
//          b[1][0]=3;
//          b[1][1]=4;
//          b[1][2]=1;
//          b[1][3]=2;
//          b[2][0]=4;
//          b[2][1]=3;
//          b[2][2]=2;
//          b[2][3]=1;
//          b[3][0]=2;
//          b[3][1]=1;
//          b[3][2]=4;
//          b[3][3]=3;
//          System.out.println("b:"+sa.EvaluatinFunction(b));
        
        //ArrayList<Integer>dd=new ArrayList<Integer>();
        a=sa.generateRandomFazand(a);
        sa.print(a);
        sa.checkFarzand(a);
        
        int x0=sa.EvaluatinFunction(a);
        
//        while(x0>30){
//             System.out.println("farzanehhhh");
//            a=sa.generateRandomFazand(a);
//            int x1=sa.EvaluatinFunction(a);
//            if(x1>x0){
//                double r=sa.exponentionalFunction(x1, x0);
//                double rnd=Math.random();
//                if(rnd<r){
//                    x0=x1;
//                }
//                else if(rnd>r){
//                    System.out.println("ghable continu");
//                    continue;
//                }
//                
//            }
//          if(x1<x0){
//              System.out.println("x1 behtare");
//              x0=x1;
//          }
//        }
//  
//        sa.print(a);
//        System.out.println("fun"+sa.EvaluatinFunction(a)); 
//    }
//    
    }
    
    public int [][]generateRandomFazand(int [][]a){
      ArrayList<Integer> arrayList = new ArrayList<Integer>();
      for(int i=0;i<a.length;i++){
          for(int j=0;j<a.length;j++){
              arrayList.add(a[i][j]);
          }
      }
     
//      System.out.println("aaaaaaa"+arrayList);
//     System.out.println("size"+arrayList.size());

        Random random=new Random();
        int m=random.nextInt(15)+0;
        for(int i=0;i<m;i++){
           int n1=random.nextInt(15)+0;
         //   System.out.println("n1"+n1);
           int n2=random.nextInt(15)+0;
          // System.out.println("n2"+n2);
           int number1=arrayList.get(n1);
           int number2=arrayList.get(n2);
           arrayList.remove(n2);
           arrayList.remove(n1);
           arrayList.add(n2, number1);
           arrayList.add(n1, number2); 
         //  System.out.println("dddd"+arrayList);
        }
        for(int i=0;i<=3;i++){
            a[0][i]=arrayList.get(i);
        }
         for(int i=0;i<=3;i++){
          a[1][i]=arrayList.get(i+4);
      }
         for(int i=0;i<=3;i++){
            a[2][i]=arrayList.get(i+8);
        }
          for(int i=0;i<=3;i++){
           a[3][i]=arrayList.get(i+12);
        }
        
        return a;
    }
    
    public int[][] tolidFarzand(int [][]a){
        Random rand = new Random();
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                int  n1 = rand.nextInt(3) + 0;
                int  n2 = rand.nextInt(3) + 0;
                int  n3 = rand.nextInt(3) + 0;
                int  n4 = rand.nextInt(3) + 0;

                int temp;
                temp=a[i][n1];
                a[i][n1]=a[i][n2];
                a[i][n2]=temp;
            }
        }
        return a;
    }
    public void print(int [][]a){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                System.out.print(" "+a[i][j]);
            }
            System.out.println();
        }
    }
    
    public int EvaluatinFunction(int a[][]){
        int sum1=checkcloums(a);
        int sum2=checkSquars(a);
        int sum3=checkRows(a);
        int sum=sum1+sum2+sum3; 
        return sum;
    }
    
    
     public int checkcloum(int number,int j,int a[][]){
        int counter=0;
        
       for(int i=0;i<4;i++){
           if(a[i][j]==number){
               counter++;
               
           }  
       }
       if(counter==1){
           counter=0;
       }
       else if(counter>1){
           counter=counter;
       }
  
       return counter;
    }
     
     public int checkcloums(int a[][]){
         int sum=0;
        int counter;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                int temp=a[j][i];
               counter= checkcloum(temp,j,a);
               sum=sum+counter;
            }
        }
        return sum;
     }
     
     
     public int checksquar(int number,int i,int j,int a[][]){
        int counter=0;
       
          i = (i / 2) * 2 ;
          j = (j / 2) * 2 ;

      for( int r = 0; r < 2; r++ )
         for( int c = 0; c < 2; c++ )
         if( a[i+r][j+c] == number ){
             counter++;
         }
         
         if(counter==1){
             counter=0;
         }
         else if(counter>1){
             counter=counter;
         }
         return counter;
    }
     
     public int checkSquars(int a[][]){
        int sum=0;
        int counter;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){   
                int temp=a[i][j];
               counter= checksquar(temp, i, j, a);
               sum=sum+counter;
            }
        }
        return sum/2;
     }
     
     public int checkRow(int number, int i, int j,int [][]a){
          int counter=0;   
        
          for(int p=j;p<a.length;p++){
             if(a[i][p]==number){
                 counter++;
             }
         }
          if(counter==1){
             counter=0;
         }
         else if(counter>1){
             counter=counter;
         }
    //   System.out.println("number"+number       +"counter          "+counter);
         
         return  counter;
     }
     
     public int checkRows(int[][]a){
         int sum=0;
         array = new ArrayList<Integer>();
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                int temp=a[i][j];
                if(checkArray(array, temp)==true){
                    continue;
                }
                else{
               int counter= checkRow(temp, i,j, a);
               array.add(temp);
               sum=sum+counter;
                }
               
            }
            array.clear();
        }

        return sum;
     }
     
     public double exponentionalFunction(int f1, int f0){
         n++;
         int x=f1-f0;
         double a=- 0.2;
         double y=a*x*n;
         double r=Math.exp(y);
         return r;
     }
     
     public boolean checkArray(ArrayList<Integer> array,int number){
         boolean state=false;
         for(int i=0;i<array.size();i++){
             if(number==array.get(i)){
                 state=true;
             }
         }
         return state;
     }
     
     public boolean checkValed(int [][]a){
         boolean state=true;

   
    return state;
     }
     
     public int[][] checkFarzand(int [][]a){
         int sum=0;
         int []array=new int[4];
         for(int i=0;i<a.length;i++){
             for(int j=0;j<a.length;j++){
                 int counter=checkRow(a[i][j], i, j, a);
                 sum+=counter;
             }
             array[i]=sum;
             System.out.println("i:"+i+"         array  " +array[i]);
             sum=0;
         }
         int max=0;
         int index=0;
         for(int i=0;i<array.length;i++){
             if(array[i]>max){
                 max=array[i];
                 index=i;
             }
         }
        System.out.println("max"+max);       
          
         return a;
     }
     
}
