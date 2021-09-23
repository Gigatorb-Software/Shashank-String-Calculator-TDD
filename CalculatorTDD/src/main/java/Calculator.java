public class Calculator {

        public static int checkEmptyString(String text){
            if(text==null || text.length()==0){
                return 0;
            }

            else{
               String delimiter = ",";
//                String[] res = delimiter.split("[,]", 0);
//                for(String myStr: res) {
//                    System.out.println(myStr);
                if(text.matches("//(.*)\n(.*)")){
                   delimiter = Character.toString(text.charAt(2));
                 text = text.substring(4);

//                    String str=",";
//                    int total=0;
//                    for(int i=0;i<str.length();i++){
//                        boolean check= Character.isDigit(str.charAt(i));
//                        if (check){
//                            total=total+Integer.parseInt(str.charAt(i));
//                        }

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


    /**
     *  checking value is null
     *  logic for negative value
     */


        private static int sumOfTotal(String[] numbers){
            int total = 0;
            String NegativeString = "";

            for(String number : numbers){
                if(stringToInt(number) < 0)
                {
                    if(NegativeString.equals(""))
                        NegativeString = number;
                    else
                        NegativeString += ("," + number);
                }
                if(stringToInt(number) < 1000)
                    total += stringToInt(number);
            }

            if(!NegativeString.equals("")){
                throw new IllegalArgumentException("Negatives not allowed: " + NegativeString);
            }

            return total;
        }
}


