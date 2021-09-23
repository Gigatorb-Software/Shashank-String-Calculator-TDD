public class Calculator {



        public static int checkEmptyString(String text){
            if(text==null || text.length()==0){
                return 0;
            }


            else {
               String delimiter = ",";
//                String[] res = delimiter.split("[,]", 0);
//                for(String myStr: res) {
//                    System.out.println(myStr);
                if(text.matches("//(.*)\n(.*)")){
                   delimiter = Character.toString(text.charAt(2));
                 text = text.substring(4);
//
                }
                String strArr[] = null;

                if(text.trim().startsWith("//")){
                    String newStr = text.trim().replaceAll("//","");
                    String delimiter1  = newStr.charAt(0)+"";
                    String subStr = newStr.substring(1);
                    subStr = subStr.replaceAll("\n",delimiter1);
                    strArr = subStr.split(delimiter1);
                }
                else{
                    strArr = text.trim().replaceAll("\n",",")
                            .split(",");
                }
                String numList[] = splitNumbers(text, delimiter + "|\n");
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


