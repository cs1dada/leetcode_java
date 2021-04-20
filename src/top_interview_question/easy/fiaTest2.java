package top_interview_question.easy;

/**
 * RemoveDuplicatesfromSortedArraySolution
 */
public class fiaTest2 {

    public boolean isPalindrome(String s) {

        char [] charArray = s.toCharArray();
        int head = 0;
        int tail = charArray.length - 1;
        
        while (head<=tail) {
            if(!Character.isLetterOrDigit(charArray[head])){
                head++;
            } else if(!Character.isLetterOrDigit(charArray[tail])) {
                tail--;
            } else {
                if(Character.toLowerCase(charArray[head]) != Character.toLowerCase(charArray[tail])) {
                    return false;
                } else {
                    head++;
                    tail--;
                }
            }            
        }

        return true;
    }

//民國年轉西元
//     本(110)年提供的資料格式為：
// 序號(7位)+身分證號(10位)+出生日期(8位：7位民國年月日及1位民國年示意符號+)+出境日期(7位民國年月日)+入境日期(7位民國年月日)+姓名（以上每欄位之間含有一個空格）。
// 範例如下：
// 0000008 B123456789 0410506+ 1080601 1090121 楊測試
// 0000056 K123456789 0481206+ 1080601 1090308 王測試

    String toADYear(String year){
        String out = "";
        if(year.length() == 7){
            out = String.valueOf(Integer.parseInt(year)+1911*10000);

        } else if(year.length() == 8) {  
            String mark = ("+".equals(year.substring(7, 8)) ? "+" : "-" );
            if (mark == "+") {
                //0481206+ => 19591206                
                out = String.valueOf(Integer.parseInt(year.substring(0, 7))+1911*10000);
            } else if (mark == "-"){
                //0481206- => 18631206
                out = String.valueOf((1911-Integer.parseInt(year.substring(0, 3)))*10000 +
                                      Integer.parseInt(year.substring(3, 7)));
            }            
            
        }

        return out;

    }

    public static void main(String[] args) {
        // int[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        String s = "A man, a plan, a canal: Panama";

        fiaTest2 aa = new fiaTest2();

        System.out.println(aa.isPalindrome(s));

        String test = "0000056 K123456789 0481206+ 0980601 1090308 王測試";

        String [] testArr = test.split(" ");
        // 證號(10)
        String idn = testArr[1];
        // 出生日期(8)
        String bornDate = aa.toADYear(testArr[2]);
        // 出境日期(7)
        String dprtDate = aa.toADYear(testArr[3]);
        // 入境日期(7)
        String entryDate = aa.toADYear(testArr[4]);

        // System.out.println(idn +" "+ bornDate );
        System.out.println(idn +" "+ bornDate +" "+ dprtDate +" "+ entryDate);


        //
        String pickYm="19612";
        if (pickYm.substring(0, 1).equals("0")){
            //096
            System.out.println(pickYm.substring(1, 3));
        } else {
            //100
            System.out.println(pickYm.substring(0, 3));
        }

        


    }
}