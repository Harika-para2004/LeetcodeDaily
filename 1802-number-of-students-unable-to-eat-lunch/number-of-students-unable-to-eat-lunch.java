class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int circulatSandwiches = 0;
        int SquareSandwiches = 0;

        for(int choice : students){
            if(choice == 0){
                circulatSandwiches++;
            }else{
               SquareSandwiches++;
            }
        }
         
         for(int check : sandwiches){
            if(check == 0 && circulatSandwiches == 0){
                return SquareSandwiches;
            }
            if(check == 1 &&SquareSandwiches == 0){
                return circulatSandwiches;
            }

            if(check == 0 ){
                circulatSandwiches--;
            }else{
                SquareSandwiches--;
            }
            
         }

            return 0;
    }
}