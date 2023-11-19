import java.util.*;
class first_fit{
    void First_Fit(int memory[] , int m, int process[] , int p)
    {
        //create an array to store the block id for each processes with size equal to number of processes
        //and allocate -1 to it
        int allocation[] = new int[p];
        for(int i=0;i<p ;i++)
            allocation[i] = -1;

        //logic
        for(int i=0;i<p;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(memory[j] >= process[i])
                {
                    allocation[i] = j;
                    memory[j] = memory[j]-process[i];
                    break;
                }
            }
        }
        //printing result
        System.out.println("Process No. || Process Size || Block No.");
        for(int i=0;i<p ; i++)
        {
            System.out.print(" "+(i+1)+" "+process[i]+" ");
            if(allocation[i] != -1)
                System.out.print(allocation[i]+1);
            else 
                System.out.print("Not allocated");
            System.out.println();
        }
    }
}
class best_fit{
    void Best_Fit(int memory[] ,int m ,int process[],int p)
    {
        //declare an array allocation to hold the process ids
        int allocate[] = new int[p];
        for(int i=0;i<p;i++)
            allocate[i]=-1;
        //logic
        for(int i=0 ; i<p ;i++)
        {
            int bestIndex = -1;
            for(int j=0 ; j<m ;j++)
            {
                if(memory[j]>=process[i])
                {
                    if(bestIndex == -1)
                        bestIndex = j;
                    else if(memory[bestIndex] > memory[j])
                        bestIndex = j;
                }
            }
            if(bestIndex != -1)
            {
                allocate[i] = bestIndex;
                memory[bestIndex] = memory[bestIndex] - process[i];
            }
        }
        //printing result
        System.out.println("Process No. || Process Size || Block No.");
        for(int i=0;i<p ; i++)
        {
            System.out.print(" "+(i+1)+" "+process[i]+" ");
            if(allocate[i] != -1)
                System.out.print(allocate[i]+1);
            else 
                System.out.print("Not allocated");
            System.out.println();
        }
    }
}
class next_fit{
    void Next_Fit(int memory[] , int m,int process[] , int p)
    {
        int allocate[] = new int[p];
        for(int i=0 ; i<p ;i++)
        {
            allocate[i] = -1;
        }
        //logic
        int j=0;
        for(int i=0;i<p;i++)
        {
            int count=0;
            while(count<m)
            {
                if(memory[j]>=process[i])
                {
                    allocate[i] = j;
                    memory[j] -= process[i];
                    j=(j+1)%m;
                    break;
                }
                j=(j+1)%m;
                count++;
            }
        }
        System.out.println("Process No. || Process Size || Block No.");
        for(int i=0;i<p ; i++)
        {
            System.out.print(" "+(i+1)+" "+process[i]+" ");
            if(allocate[i] != -1)
                System.out.print(allocate[i]+1);
            else 
                System.out.print("Not allocated");
            System.out.println();
        }
    }
}
class worst_fit{
    void Worst_Fit(int memory[] , int m ,int process[], int p)
    {
        int allocate[] = new int[p];
        for(int i=0;i<p;i++)
            allocate[i] = -1;
        //logic

        for(int i=0 ;i<p;i++)
        {
            int worstIndex = -1;
            for(int j=0 ; j< m ;j++)
            {
                if(memory[j] >= process[i])
                {
                    if(worstIndex == -1)
                        worstIndex = j;
                    else if(memory[worstIndex] < memory[j])
                        worstIndex = j;
                }
            }
            if(worstIndex != -1)
            {
                allocate[i] = worstIndex;
                memory[worstIndex] -=process[i];
            }
        }

        System.out.println("Process No. || Process Size || Block No.");
        for(int i=0;i<p ; i++)
        {
            System.out.print(" "+(i+1)+" "+process[i]+" ");
            if(allocate[i] != -1)
                System.out.print(allocate[i]+1);
            else 
                System.out.print("Not allocated");
            System.out.println();
        }
    }
}
public class practice1 {
    public static void main(String args[])
    {
        first_fit obj1 = new first_fit();
        best_fit obj2 = new best_fit();
        next_fit obj3 = new next_fit();
        worst_fit obj4 = new worst_fit();
        Scanner sc = new Scanner(System.in);
        int num_pro , num_mem ; 
        System.out.println("Enter The number of Memory Blocks :");
        num_mem = sc.nextInt();
        System.out.println("Enter The number of Processes : ");
        num_pro = sc.nextInt();
        int memory[] = new int[num_mem];
        int processes[] = new int[num_pro];
        System.out.println("Enter the Sizes of each memory Blocks: ");
        for(int i=0 ;i<num_mem;i++)
        {
            memory[i]=sc.nextInt();
        }
        System.out.println("Enter the Sizes of each processes: ");
        for(int i=0 ;i<num_pro;i++)
        {
            processes[i]=sc.nextInt();
        }
        while(true)
        {
        System.out.println("Menu");
        System.out.println("\t1. First Fit");
        System.out.println("\t2. Best Fit");
        System.out.println("\t3. Next Fit");
        System.out.println("\t4. Worst Fit");
        System.out.println("\t5. Exit");
        int choice;
        choice = sc.nextInt();
        switch (choice) {
            case 1:
            System.out.println("First Fit Output");
            obj1.First_Fit(memory ,num_mem,processes,num_pro);
                break;
            case 2:
            System.out.println("First Fit Output");
            obj2.Best_Fit(memory ,num_mem,processes,num_pro);
                break;
            case 3:
            System.out.println("Next Fit Output");
            obj3.Next_Fit(memory ,num_mem,processes,num_pro);
                break;
            case 4:
            System.out.println("Worst Fit Output");
            obj4.Worst_Fit(memory ,num_mem,processes,num_pro);
                break;
            case 5:
                return;
            default:
                System.out.println("Wrong input");
                break;
        }
        }
    }
}
