import java.io.*;
import java.util.*;
import java.util.LinkedList; 
import java.util.Queue;
import java.util.HashMap;

public class CS140mp1
{
    public static final String HTML_OUT = "./BattlePlan.html";

    public static String printCity(String city, HashMap<String,Integer> time)
    {
        String out = city + "(" + time.get(city) + ") ";
        return out;
    }
    public static void initializeHtml(String action)
    {
        File html = new File(HTML_OUT);
        try 
        {
            html.createNewFile();
            FileWriter writer = new FileWriter(html);
            writer.write("<html>");
            writer.write("\n");
            writer.write("<head>");
            writer.write("\n");
            writer.write("<meta http-equiv='content-type' content='text/html; charset=ISO-8859-1'>");writer.write("\n");
            writer.write("<title>Battle Scheduler</title>");
            writer.write("\n");
            writer.write("</head>");writer.write("\n");
            writer.write("<body style='font-family: Arial, Helvetica, sans-serif;'>");
            writer.write("\n");
            writer.write("<p></p>");writer.write("\n");
            writer.write("<center>");
            writer.write("\n");
            writer.write(" <font face='Arial'><b> Algorithm : <font color='#660000'>FCFS </font> </b></font>");
            writer.write("\n");
            writer.write("</center>");writer.write("\n");
            writer.write("<center>");
            writer.write("\n");
            writer.write(" <font face='Arial'><font color='#009900'>"+ action + "</font> general </font>");
            writer.write("\n");
            writer.write("</center>");writer.write("\n");
            writer.write("<p></p>");writer.write("\n");
            writer.write("<table border='1'>");
            writer.write("\n");
            writer.write(" <tbody>");
            writer.write("\n");
            writer.write(" <tr>");
            writer.write("\n");
            writer.write(" <th style='color: rgb(0, 255, 0); background-color: black;'>Day</th>");
            writer.write("\n");
            writer.write(" <th style='color: rgb(0, 255, 0); background-color: black;'>"+ action + "</th>");
            writer.write("\n");
            writer.write(" <th style='color: rgb(0, 255, 0); background-color: black;'>Ready Queue</th>");
            writer.write("\n");
            writer.write(" <th style='color: rgb(0, 255, 0); background-color: black;'>Subcommanders</th>");
            writer.write("\n");
            writer.write(" <th style='color: rgb(0, 255, 0); background-color: black;'>Remarks</th>");
            writer.write("\n");
            writer.write("</tr>");
            writer.close();
        }    
        catch (Exception e)
        {
            System.out.println("oopsie");
        }


    }
    public static String getName (String line)
    {
        return line.split(" ")[0];
    }

    public static int getTime (String line)
    {
        return Integer.parseInt(line.split(" ")[1]);
    }

    public static int totalTimeLeft(HashMap<String, Integer> time_left)
    {
        int total = 0;
        for (String key : time_left.keySet())
        {
            total += time_left.get(key);
        }

        return total;
    }
    public static void main (String args[]) 
    {
        Queue<String> war_strats = new LinkedList<>();
        String city_string = "";
        Scanner scanner= new Scanner(System.in);
        String action = "";
        System.out.println("Which team do you want to lead?");
        System.out.println("A. Attack");
        System.out.println("B. Siege");
        System.out.println("C. Defend");
        System.out.println("D. Parley");

        do
        {
            System.out.print("Input> ");
            char input = scanner.nextLine().charAt(0);
            switch(input) 
            {
                case 'A':
                    action = "attack";
                    break;
                case 'B':
                    action = "seige";
                    break;
                case 'C':
                    action = "defend";
                    break;
                case 'D':
                    action = "parley";
                    break;
                default:
                    break;
            }
        }while(action == "");


        initializeHtml(action);
        try
        {

            File war_strat = new File("./testdata/WarStrategy.txt"); 
            BufferedReader br = new BufferedReader(new FileReader(war_strat));

            String st;
            while ((st = br.readLine()) != null) 
            {
                war_strats.add(st);
                city_string += st + " ";
            }
        }
        catch (Exception e) {
            System.out.println("oopsie");
        }

        String[] cities = city_string.split(" ");


        int day = 1;
        String top, curr_name;
        int top_day;
        String curr;
        HashMap<String, Queue> strat_queues = new HashMap<String, Queue>();
        HashMap<String, Integer> time_left = new HashMap<String,Integer>();
        HashMap<String, Boolean> subprocessing = new HashMap<String,Boolean>();
        HashMap<String, Boolean> joined_battle = new HashMap<String,Boolean>();
        String remarks = "";

        //Queue<String>[] strat_queues;
        //strat_queues = new Queue[war_strats.size()];
        Queue<String> ready_queue = new LinkedList<>();
        String main_task = "";
        String task;

        for(int i = 0; i < cities.length; i++)
        {
            strat_queues.put(cities[i], new LinkedList<>() );
            time_left.put(cities[i], 0);
            subprocessing.put(cities[i], false);
            joined_battle.put(cities[i], false);
        }
        while(war_strats.size() > 0 || totalTimeLeft(time_left) > 0)
        {
            remarks = "";
            if(war_strats.size() > 0 )
            {
                top = war_strats.peek();
                top_day = Integer.parseInt(top.split(" ")[1]);
                if(day == top_day)
                {
                    Queue<String> curr_queue = new LinkedList<>();

                    curr = war_strats.remove();
                    remarks += (getName(curr) + " joins the field. ");
                    curr_name= curr.split(" ")[0];
                    try 
                    {
                        File curr_strat = new File("./testdata/"+ curr_name + ".txt"); 
                        BufferedReader br = new BufferedReader(new FileReader(curr_strat));
                        String st;

                        while ((st = br.readLine()) != null) 
                        {
                            curr_queue.add(st);
                        }
                        strat_queues.put(curr_name, curr_queue);
                        joined_battle.put(curr_name, true);

                    }
                    catch (Exception e)
                    {
                        System.out.println("oopsie");

                    }
                } 
            }

            for(int i = 0; i < cities.length; i++)
            {
                if(joined_battle.get(cities[i]))
                {
                    Queue curr_queue;
                    curr_queue = strat_queues.get(cities[i]);
                    if(time_left.get(cities[i]) <= 0 && curr_queue.size() > 0)
                    {
                        curr = String.valueOf(curr_queue.remove());
                        time_left.put(cities[i], getTime(curr));
                        task = getName(curr);
                        if(task.equals(action))
                        {
                            remarks += (cities[i] + " is ready for you. ");
                            ready_queue.add(cities[i]);
                        }
                        else
                        {
                            subprocessing.put(cities[i], true);
                        }
                    }
                }

            }
            if(main_task.equals("") && ready_queue.size() > 0)
            {
                main_task = ready_queue.remove();
                remarks += (main_task + " is taken under your command. ");
            }


            try{
                FileWriter fileWriter = new FileWriter(HTML_OUT, true);
                PrintWriter writer = new PrintWriter(fileWriter);
                writer.write("<tr>\n") ;
                writer.write("<td>\n");
                writer.write(String.valueOf(day));
                writer.write("</td>\n");
                writer.write("<td>\n");
                if(main_task != "")
                    writer.write(printCity(main_task, time_left));
                writer.write("\n");
                writer.write("</td>\n");
                writer.write("<td>\n");
                for (String item: ready_queue)
                {
                    String name = getName(item);
                    writer.write(printCity(name,time_left));
                }
                writer.write("</td>\n");
                writer.write("<td>\n");
                for(int i = 0; i < cities.length; i++)
                {
                    if(subprocessing.get(cities[i]))
                    {
                        writer.write(printCity(cities[i], time_left));
                    }
                }
                writer.write("</td>\n");
                writer.write("<td>\n");
                writer.write(remarks);
                writer.write("</td>\n");
                writer.write("<td>\n") ;
                writer.close();


            }
            catch (Exception e)
            {
                System.out.println("oopsie");
            }

            for(int i = 0; i < cities.length; i++)
            {
                if(main_task.equals(cities[i])|| subprocessing.get(cities[i]))
                {
                    time_left.put(cities[i], time_left.get(cities[i]) - 1);
                }
                if(subprocessing.get(cities[i]) && time_left.get(cities[i]) <= 0 )
                {
                    subprocessing.put(cities[i], false);
                }
                if(main_task.equals(cities[i]) && time_left.get(cities[i]) <= 0)
                {
                    main_task = "";
                }
            }

            day++;
        }


    }
}
