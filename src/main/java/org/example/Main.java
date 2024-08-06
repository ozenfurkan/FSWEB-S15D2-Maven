package org.example;

import org.example.entity.Priority;
import org.example.entity.Status;
import org.example.entity.Task;
import org.example.entity.TaskData;
import org.example.entity.StringSet;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Task task1 = new Task("Java Collections", "Write List Interface", "Ann", Status.IN_QUEUE, Priority.LOW);
        Task task2 = new Task("Java Collections", "Write Set Interface", "Ann", Status.ASSIGNED, Priority.MED);
        Task task3 = new Task("Java Collections", "Write Map Interface", "Bob", Status.IN_QUEUE, Priority.HIGH);

        Set<Task> annsTasks = new HashSet<>();
        annsTasks.add(task1);
        annsTasks.add(task2);

        Set<Task> bobsTasks = new HashSet<>();
        bobsTasks.add(task3);

        Set<Task> carolsTasks = new HashSet<>();
        Set<Task> unassignedTasks = new HashSet<>();

        TaskData taskData = new TaskData(annsTasks, bobsTasks, carolsTasks, unassignedTasks);

        System.out.println("Ann's Tasks: " + taskData.getTasks("ann"));
        System.out.println("Bob's Tasks: " + taskData.getTasks("bob"));
        System.out.println("Carol's Tasks: " + taskData.getTasks("carol"));
        System.out.println("All Tasks: " + taskData.getTasks("all"));

        Task task4 = new Task("Java Collections", "Write Queue Interface", "Carol", Status.IN_PROGRESS, Priority.HIGH);
        carolsTasks.add(task4);
        taskData.setCarolsTasks(carolsTasks);

        System.out.println("Carol's Tasks after adding a new task: " + taskData.getTasks("carol"));

        Set<Task> taskSet1 = new HashSet<>();
        taskSet1.add(task1);
        taskSet1.add(task2);

        Set<Task> taskSet2 = new HashSet<>();
        taskSet2.add(task2);
        taskSet2.add(task3);

        System.out.println("Union of taskSet1 and taskSet2: " + taskData.getUnion(taskSet1, taskSet2));
        System.out.println("Intersection of taskSet1 and taskSet2: " + taskData.getIntersection(taskSet1, taskSet2));
        System.out.println("Difference of taskSet1 and taskSet2: " + taskData.getDifferences(taskSet1, taskSet2));

        String text = "Carroll began writing the manuscript of the story the next day, although that earliest version is lost. " +
                "The girls and Carroll took another boat trip a month later, when he elaborated the plot to the story of Alice, " +
                "and in November he began working on the manuscript in earnest. To add the finishing touches he researched " +
                "natural history in connection with the animals presented in the book and then had the book examined " +
                "by other children—particularly those of George MacDonald. Though Carroll did add his own illustrations " +
                "to the original copy, on publication he was advised to find a professional illustrator so the pictures " +
                "were more appealing to its audiences. He subsequently approached John Tenniel to reinterpret " +
                "Carroll's visions through his own artistic eye, telling him that the story had been well liked by the" +
                " children.\n" +
                "\n" +
                "Carroll began planning a print edition of the Alice story in 1863. " +
                "He wrote on 9 May 1863 that MacDonald's family had suggested he publish Alice. " +
                "A diary entry for 2 July says that he received a specimen page of the print edition around that date. " +
                "On 26 November 1864, Carroll gave Alice the manuscript of Alice's Adventures Under Ground, with illustrations " +
                "by Carroll, dedicating it as \"A Christmas Gift to a Dear Child in Memory of a Summer's Day\". " +
                "The published version of Alice's Adventures in Wonderland is about twice the length of " +
                "Alice's Adventures Under Ground and includes episodes, such as the Mad Tea-Party, " +
                "that did not appear in the manuscript. The only known manuscript copy of Under Ground " +
                "is held in the British Library. Macmillan published a facsimile of the manuscript in 1886.";

        Set<String> uniqueWords = StringSet.findUniqueWords(text);
        System.out.println("Unique words: " + uniqueWords);
        System.out.println("Number of unique words: " + uniqueWords.size());
    }
}
