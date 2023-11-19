import java.util.*;
import java.io.*;

public class LRU_Practice {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        //taking input
        int frame_size;
        int length_of_string;
        System.out.println("Enter the Size of frame : ");
        frame_size = sc.nextInt();
        System.out.println("Enter the length of reference string : ");
        length_of_string = sc.nextInt();
        int reference_string[] = new int[length_of_string];
        System.out.println("Enter the reference string : ");
        for(int i=0;i<length_of_string ; i++)
        {
            reference_string[i] = sc.nextInt();
        }
        //logic
        int pointer = 0 , hit = 0 , fault = 0;
        boolean isFull = false;
        //declaring stack
        ArrayList<Integer> stack = new ArrayList<Integer>();
        int memory_layout[][] = new int[length_of_string][frame_size];
        int buffer[] = new int[frame_size];
        for(int i=0;i<frame_size;i++)
        {
            buffer[i] = -1;
        }

        for(int i=0 ; i<length_of_string; i++)
        {
            if(stack.contains(reference_string[i]))
            {
                stack.remove(stack.indexOf(reference_string[i]));
            }
            stack.add(reference_string[i]);
            int search = -1;
            for(int j=0;j<frame_size;j++)
            {
                if(buffer[j] == reference_string[i])
                {
                    search = j;
                    hit++;
                    break;
                }
            }
            if(search == -1)
            {
                if(isFull)
                {
                    int min_loc=length_of_string;
                    for(int j=0;j<frame_size;j++)
                    {
                        if(stack.contains(buffer[j]))
                        {
                            int temp = stack.indexOf(buffer[j]);
                            if (temp<min_loc)
                            {
                                min_loc = temp;
                                pointer = j;
                            }
                        }
                    }
                }
                buffer[pointer] = reference_string[i];
                fault++;
                pointer++;
                if(pointer == frame_size)
                {
                    pointer = 0;
                    isFull = true;
                }
            }
            for(int j=0 ; j<frame_size;j++)
                memory_layout[i][j] = buffer[j];
        }
        for(int i=0;i<frame_size;i++)
        {
            for(int j=0;j<length_of_string;j++)
            {
                System.out.printf("%3d",memory_layout[j][i]);
            }
            System.out.println();
        }
        System.out.println("The number of Hits: "+hit);
        System.out.println("Hit Ratio : "+(float)((float)hit/length_of_string));
        System.out.println("The number of page Faults: "+fault);
    }     
}
