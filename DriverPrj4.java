/*
  Alfredo Tigolo III
  CS 312
  Project 4

  This is a modified Project 3, but now, it stores the word via hashtable.  I used
  the countToken() number to store the word in the hashtable class.
*/
//package prj3;

import java.io.IOException;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
//import jdsl.pInteger;
//import prj3.StringBST;
import java.util.StringTokenizer;
import java.util.Hashtable;

public class DriverPrj4
{
  public static void main (String[] args)
  {
    if ( args.length < 2 )
    {
    System.out.println
      ("Usage Error, missing filename in commandline and word length.");
    System.out.println
      ("Example Usage: java prj3/Driver2 filename word_length");
    System.exit(1);
    }

    int length = Integer.parseInt(args[1]);
    String line="";
    String word="";
    String words_list="";
    StringTokenizer st;
    String delimiters= " \",,#<>()[]?{}.&!'\\+=@*:;_-/1234567890";
    //StringBST t = new StringBST();
    Hashtable T = new Hashtable();

    try
    {
      //FileReader would have worked also
      DataInputStream fin = new DataInputStream(new FileInputStream(args[0]));
                  BufferedReader d = new BufferedReader(new InputStreamReader(fin));

      line = d.readLine();
      st = new StringTokenizer(line, delimiters);

      /*
        First while statement parses the text into the approiate word length.
        Pulls words with the approiate word length.
      */

      while ( line != null)
      {
      while ( st.hasMoreTokens() && line != null)
      {
        word = st.nextToken();
        if (word.length() == length)
        {
          words_list+= word.toLowerCase()+" ";
        }
      }//end inner while

      line = d.readLine();//reads the next line
      if ( line != null)
          st = new StringTokenizer(line, delimiters);
      }//end outer while

      /*
        Takes the 'words_list that contain all the words and Tokenizes again
        so it can be placed in the appropriate nodes.
      */
      st = new StringTokenizer(words_list);
      while ( st.hasMoreTokens())
      {
         word = st.nextToken();

         if (T.contains(word))
         {
         	//System.out.println("duplicate");
         	//System.out.println(word.hashCode()+"=hashcode for word "+word);
		}
         else
         {
            T.put(new Integer(word.hashCode()),  word);
		}

      }
      //System.out.println(T);  //displays hashtable, keys and values
      System.out.println(T.size()+" Number of values in Hashtable");//size at the end
      //System.out.println(T.keySet() +" "+T.values());
      System.out.println(T.values());

    }//end try
    catch (IOException x)
    {
      System.out.println(x);
    }//end catch
  }//end main
}//end class


