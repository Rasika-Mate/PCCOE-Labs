import java.util.*;

/*
INPUT:
7

J1 4 30
J2 2 20
J3 4 25
J4 3 35
J5 3 15
J6 2 5
J7 1 12

OUTPUT:
J4 J1 J3 J2
PROFIT : 110

INPUT:
5

J1 1 10
J2 2 15
J3 2 20
J4 3 5
J5 3 1

OUTPUT:
J3 J2 J4
PROFIT: 40
*/

class Jobs{
    String id;
    int deadline;
    int profit;
    Jobs(String id,int deadline, int profit){
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
    @Override
    public String toString() {
        return "Job ID: " + id + ", Deadline: " + deadline + ", Profit: " + profit;
    }
}
public class Ass2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList <Jobs> arr = new ArrayList<>();

        System.out.print("Enter total Jobs : ");
        int n = sc.nextInt();
        System.out.println("Job Id : Job Deadline : Job Profit : ");
        for (int i=0; i<n;i++){
            String id = sc.next();
            int deadline = sc.nextInt();
            int profit = sc.nextInt();

            arr.add(new Jobs(id,deadline,profit));
        }

        // Sort the arr in descending order based on profit without using lambda
Collections.sort(arr, new Comparator<Jobs>() {
    @Override
    public int compare(Jobs job1, Jobs job2) {
        return Integer.compare(job2.profit, job1.profit); // Sort in descending order of profit
    }
});

        // find max deadline
        int maxDeadline = 0;
        for (Jobs job: arr) {
            if (job.deadline > maxDeadline){
                maxDeadline = job.deadline;
            }
        }
        System.out.println("Max deadline is : "+maxDeadline);

        // print
        System.out.println("Sorting jobs : ");
        for (Jobs jobs : arr) {
            System.out.println(jobs);
        }

        // initialise an array
        int[] deadlineBool = new int[maxDeadline+1];
        Arrays.fill(deadlineBool,0);
        
        // logic
        int count =0;
        int profit =0;
        ArrayList <Jobs> resultArr = new ArrayList<>();

        for (Jobs job: arr){
                    for (int i = job.deadline;i>=1; i--){
                        if (deadlineBool[i]==0){
                            deadlineBool[i] = 1;
                            profit+= job.profit;
                            count+=1;
                            resultArr.add(job);
                            break;
                        }
                    }
                }
        

        System.out.println("\nSequence of Jobs according to maximum profit : ");
        for (Jobs job: resultArr){
            System.out.println(job);
        }
        System.out.println("Total profit is : "+profit);
    }
}
