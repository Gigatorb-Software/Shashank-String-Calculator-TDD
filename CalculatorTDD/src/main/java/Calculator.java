public class Calculator {

        public static int checkEmptyString(String InputText){
            if(InputText==null || InputText.length()==0){
                return 0;
            }
            else {
               String delimiter = ",";
//                String[] res = delimiter.split("[,]", 0);
//                for(String myStr: res) {
//                    System.out.println(myStr);
                if(InputText.matches("//(.*)\n(.*)")){
                   delimiter = Character.toString(InputText.charAt(2));
                    InputText = InputText.substring(4);
//
                }
                String strArr[] = null;

                if(InputText.trim().startsWith("//")){
                    String newStr = InputText.trim().replaceAll("//","");
                    String delimiter1  = newStr.charAt(0)+"";
                    String subStr = newStr.substring(1);
                    subStr = subStr.replaceAll("\n",delimiter1);
                    strArr = subStr.split(delimiter1);
                }
                else{
                    strArr = InputText.trim().replaceAll("\n",",")
                            .split(",");
                }
                String numList[] = splitNumbers(InputText, delimiter + "|\n");
                return sumOfTotal(numList);
            }
        }


    private static int stringToInt(String number){
        return Integer.parseInt(number);
    }

    private static String[] splitNumbers(String numbers, String divider){
        return numbers.split(divider);
    }

    private static int sumOfTotal(String[] numbers){
        int total = 0;
        String NegativeString = "";

        for(String nvm : numbers){
            if(stringToInt(nvm) < 0)
            {
                if(NegativeString.equals(""))
                    NegativeString = nvm;
                else
                    NegativeString += ("," + nvm);
            }
            if(stringToInt(nvm) < 1000)
                total += stringToInt(nvm);
        }

        if(!NegativeString.equals("")){
            throw new IllegalArgumentException("Negatives not allowed: " + NegativeString);
        }

        return total;
        }



}


