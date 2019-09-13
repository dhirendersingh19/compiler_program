package compiler_program;
import java.io.*;
import java.util.*;
public class Eliminating_Left_Recursion {
   LinkedHashMap<Character,String> production;
    Eliminating_Left_Recursion(){
        production = new LinkedHashMap<>();
    }
    void LeftRecurrsion(int no_of_production){
        Character LhsStore;
        String RhsStore;
        String[] RhsString;
        char[] RhsCharacter;
        
        char[] temp,mainTemp;
       for(Map.Entry<Character,String> entry : production.entrySet()) 
       {
          LhsStore = entry.getKey();
          RhsStore= entry.getValue();
          
          RhsCharacter=RhsStore.toCharArray();
          int count=0,flag=0;
          
          for(int i=0;i<RhsCharacter.length;i++){
              if(RhsCharacter[i]=='|')
                  count++;
          }
          RhsString=RhsStore.split("\\|");
          
          for(int j=0;j<=count;j++){
              flag=0;
              temp=RhsString[j].toCharArray();
              if(LhsStore.equals(temp[0])){
                  flag=1;
                  break;
              } 
          }
          if(flag==1){
              for(int k=0;k<=count;k++){
                  mainTemp=RhsString[k].toCharArray();
                  if(LhsStore.equals(mainTemp[0])){
                      System.out.print(LhsStore+"'"+"-->");
                      for(int l=1;l<mainTemp.length;l++)
                          System.out.print(mainTemp[l]);
                      System.out.print(LhsStore+"'");
                      System.out.print("|ε");
                  }
                  else{
                        System.out.print(LhsStore+"-->");
                        for(int l=0;l<mainTemp.length;l++)
                            System.out.print(mainTemp[l]);
                        System.out.print(LhsStore+"'");
                  }
                  System.out.println();
              }
          }
          else{
                System.out.println(entry.getKey()+"-->" + entry.getValue());
          }
       }    
    }
    
    public static void main(String... args)throws IOException{
        
        Scanner s = new Scanner(System.in); 
        Eliminating_Left_Recursion product = new Eliminating_Left_Recursion();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
        Character Lhs;
        String Rhs;
        int no_of_production;
        System.out.print("Enter Total Number of Production : ");
        no_of_production=s.nextInt();
        for(int i=0;i<no_of_production;i++){
            System.out.println("Enter Production "+(i+1));
            System.out.println("Lhs? ");
            Lhs=s.next().charAt(0);
            System.out.println("Rhs? ");
            Rhs=br.readLine();
            product.production.put(Lhs, Rhs);
        } 
        System.out.println("Production Before Elimination of Left Recurrsion");
        for (Map.Entry<Character,String> entry : product.production.entrySet())  
            System.out.println( entry.getKey()+"-->" + entry.getValue());
        System.out.println("Production After Elimination of Left Recurrsion");
        product.LeftRecurrsion(no_of_production);
    }
}