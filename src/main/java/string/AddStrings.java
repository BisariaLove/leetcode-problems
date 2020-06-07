package string;

//https://leetcode.com/problems/add-strings

public class AddStrings {

    public String addStrings(String num1, String num2) {

        StringBuilder sb = new StringBuilder();

        int carry = 0;
        int sum = 0;

        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;

        while(index1>=0 && index2>=0) {
            sum = ((int) num1.charAt(index1) - '0' )  + ((int) num2.charAt(index2) - '0' ) + carry;

            carry = sum/10;
            sum = sum%10;

            sb.insert(0, String.valueOf(sum));

            index1--;
            index2--;
        }

        while(index1>=0) {
            sum = carry + ((int) num1.charAt(index1) - '0' ) ;
            carry = sum/10;
            sum = sum%10;

            sb.insert(0, String.valueOf(sum));

            index1--;

        }

        while(index2>=0) {
            sum = carry + ((int) num2.charAt(index2) - '0' ) ;
            carry = sum/10;
            sum = sum%10;

            sb.insert(0, String.valueOf(sum));

            index2--;

        }

        if(carry > 0 ) {
            sb.insert(0, String.valueOf(carry));
        }

        return sb.toString();

    }
}
