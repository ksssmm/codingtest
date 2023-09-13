class targetNumber {
    static int count = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        int answer = count;
        
        return answer;
    }
    public void dfs(int[] numbers, int index, int target, int result){
        if(index == numbers.length){
            if(result == target){
                count++;
            }
            return;
        }
        int plus = result + numbers[index];
        int minus = result - numbers[index];
        dfs(numbers, index +1, target, plus);
        dfs(numbers, index +1, target, minus);
    }
}