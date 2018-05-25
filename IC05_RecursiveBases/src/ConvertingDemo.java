import java.util.Scanner;

public class ConvertingDemo
{
    public static String decimal2Binary(int num)
    {
        int quotient = num / 2;
        int r = num % 2;
        // Base case to stop if q =0
        if(quotient == 0)
           return String.valueOf(r);
        return decimal2Binary(quotient) + String.valueOf(r);
    }

    public static String decimal2Hex(int num)
    {
        int quotient = num / 16;
        int r = num % 16;
        String hex;
        switch(r)
        {
            case 10:
                hex = "A";
                break;
            case 11:
                hex = "B";
                break;
            case 12:
                hex = "C";
                break;
            case 13:
                hex = "D";
                break;
            case 14:
                hex = "E";
                break;
            case 15:
                hex = "F";
                break;
                default:
                    hex = String.valueOf(r);
                    break;
        }
        // Base case to stop if q =0
        if(quotient == 0)
           return hex;
        return decimal2Hex(quotient) + hex;
    }



    public static int binary2Decimal(String binaryString)
    {
        int StringLength = binaryString.length();
        if (StringLength == 0) return 0;

        String digit = binaryString.substring(0,1);
        String rest = binaryString.substring(1);

        return Integer.parseInt(digit) * (int)Math.pow(2, StringLength-1) + binary2Decimal(rest);
    }

    public static int hex2Decimal(String hexString)
    {
        int decimal = 0;
        String hexCode = "0123456789ABCDEF";
        hexString = hexString.toUpperCase();
        int length = hexString.length();
        if (length > 0) {
            char ch = hexString.charAt(0);
            int digit = hexCode.indexOf(ch);
            String substring = hexString.substring(1);
            decimal = digit * (int) Math.pow(16, length - 1) + hex2Decimal(substring);
        }
        return decimal;
    }
    public static void main (String[] args)
    {
        /*System.out.println("Enter a number");
        Scanner cin = new Scanner(System.in);
        int num = 0;
        num = cin.nextInt();
        System.out.println("In Binary:" + decimal2Binary(num));
        System.out.println("In Hex: " + decimal2Hex(num));
        */
        System.out.println("Enter a Binary String");
        Scanner cin = new Scanner(System.in);
        String user = cin.nextLine();
        System.out.println(binary2Decimal(user));


        System.out.println("Enter a Hex String");
         user = cin.nextLine();
        System.out.println(hex2Decimal(user));
    }
}
