class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        // result[0][0] = arr[0][0] * arr2[0][0] + arr[0][1] * arr2[1][0]
        // result[0][1] = arr[0][0] * arr2[0][1] + arr[0][1] * arr2[1][1]
        
        // result[1][0] = arr[1][0] * arr2[0][0] + arr[1][1] * arr2[1][0]
        // result[1][1] = arr[1][0] * arr2[0][1] + arr[1][1] * arr2[1][1]
        
        // result[2][0] = arr[2][0] * arr2[0][0] + arr[2][1] * arr2[1][0]
        // result[2][1] = arr[2][0] * arr2[0][1] + arr[2][1] * arr2[1][1]
        
        int arr1Row = arr1.length; //3, 3
        int arr1Val = arr1[0].length; //2, 3
        int arr2Col = arr2[0].length; //2, 3
        int arr2Val = arr2.length; //2, 3
        
        
        int[][] answer = new int[arr1Row][arr2Col];
        
        for(int i = 0; i < arr1Row; i++) { // 3
            for(int j = 0; j < arr2Col; j++) { // 2
                for(int k = 0; k < arr1Val; k++) { // 2
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}