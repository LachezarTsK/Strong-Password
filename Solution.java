import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

	static int minimumNumber(int lengthOfString, String password) {
		int minLengthOfPassword = 6;
		int missingKeyChars = 0;

		Pattern pattern_LowercaseEnglishCharacters = Pattern.compile("\\p{Lower}");
		Matcher matcher_LowercaseEnglishCharacters = pattern_LowercaseEnglishCharacters.matcher(password);
		missingKeyChars += matcher_LowercaseEnglishCharacters.find() ? 0 : 1;

		Pattern pattern_UppercaseEnglishCharacters = Pattern.compile("\\p{Upper}");
		Matcher matcher_UppercaseEnglishCharacters = pattern_UppercaseEnglishCharacters.matcher(password);
		missingKeyChars += matcher_UppercaseEnglishCharacters.find() ? 0 : 1;

		Pattern pattern_SpecialhCharacters = Pattern.compile("[!@#$%^&*()+//-]");
		Matcher matcher_SpecialhCharacters = pattern_SpecialhCharacters.matcher(password);
		missingKeyChars += matcher_SpecialhCharacters.find() ? 0 : 1;

		Pattern pattern_Digits = Pattern.compile("\\d");
		Matcher matcher_Digits = pattern_Digits.matcher(password);
		missingKeyChars += matcher_Digits.find() ? 0 : 1;

		int numberOfCharsToBeAdded = Math.max(missingKeyChars, minLengthOfPassword - lengthOfString);
		
		return numberOfCharsToBeAdded;
	}

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int lengthOfString = reader.nextInt();
		reader.nextLine();

		String password = reader.nextLine();
		reader.close();

		int answer = minimumNumber(lengthOfString, password);
		System.out.println(answer);
	}
}
