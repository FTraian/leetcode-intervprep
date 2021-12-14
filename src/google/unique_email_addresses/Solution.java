package google.unique_email_addresses;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Solution {

    private static final Pattern UNDESIRED = Pattern.compile("\\.(.*@)|(\\+).*(@)");

    /**
     * https://leetcode.com/problems/unique-email-addresses
     * 
     * This solution does not work for multiple dots in local name
     */
    // public int numUniqueEmails(String[] emails) {
    //     Set<String> results = new HashSet<>();
    //     for (String email : emails) {
    //         results.add(UNDESIRED.matcher(email).replaceAll(""));
    //     }
    //     return results.size();
    // }

    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            String[] splits = email.split("@");
            
            String[] local = splits[0].split("\\+");

            uniqueEmails.add(local[0].replace(".", "") + "@" + splits[1]);
        }
        return uniqueEmails.size();
    }
}
