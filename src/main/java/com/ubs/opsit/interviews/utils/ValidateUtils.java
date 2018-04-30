package com.ubs.opsit.interviews.utils;

import org.apache.commons.lang.Validate;

public class ValidateUtils {

	private ValidateUtils(){}

	public static void validateRangeFromZeroUntil(int maxExcl, int arg, String argName){
		Validate.isTrue(arg >= 0, "Argument '" + argName + "' should be greater or equal to zero");
		Validate.isTrue(arg < maxExcl, "Argument '" + argName + "' should be lower than " + maxExcl);
	}

	public static void validateRangeFromZeroUpTo(int maxIncl, int arg, String argName){
		Validate.isTrue(arg >= 0, "Argument '" + argName + "' should be greater or equal to zero");
		Validate.isTrue(arg <= maxIncl, "Argument '" + argName + "' should be lower or equal to " + maxIncl);
	}

	public static void validateMatchesPattern(String pattern, String arg, String argName){
		Validate.isTrue(arg.matches(pattern), "Argument '"+argName+"' argument should match "+pattern+" pattern");
	}

}