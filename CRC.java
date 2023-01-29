import java.io.*;
import java.util.*;

public class Main
{ 
    public static void main(String[]args) throws IOException
    {
      int data[],div[],rem[],crc[],divisor[];
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      int data_bits,divisor_bits;
      
      System.out.println("enter the number of data bits");
      data_bits=Integer.parseInt(br.readLine());
      data=new int[data_bits];
      System.out.println("enter the number of divisor bits");
      divisor_bits=Integer.parseInt(br.readLine());
      divisor=new int[divisor_bits];
      
      int total_len=data_bits+divisor_bits-1;
      div=new int[total_len];
      rem=new int[total_len];
      crc=new int[total_len];
      System.out.println("Enter the data bits");
      for(int i=0;i<data_bits;i++)
      {
          data[i]=Integer.parseInt(br.readLine());
      }
      System.out.println("Enter the divisor bits");
      for(int i=0;i<divisor_bits;i++)
      {
          divisor[i]=Integer.parseInt(br.readLine());
      }
      System.out.println("copying data into div");
      for(int i=0;i<data.length;i++)
      {
          div[i]=data[i];
      }
      System.out.println("appending zeros");
      //System.out.println("");
      
      for(int i=0;i<total_len;i++)
      {
         System.out.println(div[i]);
      }
      for(int i=0;i<div.length;i++)
      {
          rem[i]=div[i];
      }
      rem=divide(div,divisor,rem);
      for(int i=0;i<div.length;i++)
      {
          crc[i]=(div[i]^rem[i]);
      }
      System.out.println("the generated crc is ");
      for(int i=0;i<crc.length;i++)
      {
          System.out.println(crc[i]);
      }
      System.out.println("Enter the crc code");
      for(int i=0;i<crc.length;i++)
      {
          crc[i]=Integer.parseInt(br.readLine());
      }
      for(int i=0;i<crc.length;i++)
      {
          rem[i]=crc[i];
      }
      rem=divide(crc,divisor,rem);
      for(int i=0;i<rem.length;i++)
      {
          if(rem[i]!=0)
          {
             System.out.println("Error"); 
             break;
          }
          if(i==rem.length-1)
          {
              System.out.println("No error");
          }
      }
      
    }
static int [] divide(int div[],int divisor[],int rem[]){
    
    int cur=0;
    while(true)
    {
        for(int i=0;i<divisor.length;i++)
        {
            rem[cur+i]=(rem[cur+i]^divisor[i]);
        }
        while(rem[cur]==0&& cur!=rem.length-1)
        cur++;
        if((rem.length-cur)<(divisor.length))
        break;
    }
    return rem;
}

}
    
    

