class ProductOfNumbers {
    private List<Integer> prod = new ArrayList<>();
    int size = 0;
    public ProductOfNumbers() {
        prod.add(1);
    }
    
    public void add(int num) {
        if(num == 0){
            prod = new ArrayList<>();
            prod.add(1);
            size = 0;
        }
        else{
            prod.add(prod.get(size) * num);
            size++;
        }
    }
    
    public int getProduct(int k) {
        if(k > size){
            return 0;
        }
        return prod.get(size) / prod.get(size - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */