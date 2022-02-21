package Paytm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
	// Java implementation of the approach
	static int MAX = 26;

	// Function to return the lexicographically
	// smallest string after swapping all the
	// occurrences of any two characters
	static String smallestStr(char []str, int n)
	{
		int i, j = 0;
		int []chk = new int[MAX];
		for (i = 0; i < MAX; i++)
			chk[i] = -1;

		for (i = 0; i < n; i++)
		{

			if (chk[str[i] - 'a'] == -1)
				chk[str[i] - 'a'] = i;
		}
		for (i = 0; i < n; i++)
		{
			boolean flag = false;

			for (j = 0; j < str[i] - 'a'; j++)
			{
				if (chk[j] > chk[str[i] - 'a'])
				{
					flag = true;
					break;
				}
			}

			if (flag)
				break;
		}

		if (i < n)
		{
			char ch1 = str[i];
			char ch2 = (char) (j + 'a');
			for (i = 0; i < n; i++)
			{
				if (str[i] == ch1)
					str[i] = ch2;

				else if (str[i] == ch2)
					str[i] = ch1;
			}
		}

		return String.valueOf(str);
	}

	public static void main(String[] args)
	{
		String str = "bdea    ";
		int n = str.length();

		System.out.println(smallestStr(
						str.toCharArray(), n));
	}
	}

