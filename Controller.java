class Controller {
    private double memoryValue;
    private double[] memory = new double[6];

    public double Addition(double num1, double num2) {
        return num1 + num2;
    }

    public double Subtraction(double num1, double num2) {
        return num1 - num2;
    }

    public double multiplication(double num1, double num2) {
        return num1 * num2;
    }

    public double division(double num1, double num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
    }

    public double sqRoot(double num) {
        return Math.sqrt(num);
    }

    public int squared(int num) {
        return num * num;
    }

    public double reciprocal(double num) {
        return 1 / num;
    }

    public double percent(double num) {
        return num / 100;
    }

    public double invertValue(double num) {
        return num * -1;
    }

   public void memoryClear() {
       memoryValue = 0;

           for (int i = 0; i < memory.length; i++) {
               memory[i] = 0;
           }
    }

    public double getMemoryValue() {
        return memoryValue;
    }

    public double memoryRecall() {
        return memoryValue;
    }

  public void memoryAdd(double currentValue) {
        memoryValue += currentValue;
        System.out.println("Memory Value after Addition: " + memoryValue);

        storeInMemoryArray(currentValue);
    }


 public void memorySubstract(double currentValue) {
        memoryValue -= currentValue;
        System.out.println("Memory Value after Subtraction: " + memoryValue);

        storeInMemoryArray(currentValue);
    }

  public void memoryStore(double value) {
        memoryValue = value;
        System.out.println("Memory Value stored: " + memoryValue);

        storeInMemoryArray(value);
    }

        private void storeInMemoryArray(double value) {

	        for (int i = memory.length - 1; i > 0; i--) {
	            memory[i] = memory[i - 1];
	        }

	        memory[0] = value;
    }
  public String memoryShow() {
      StringBuilder memoryContents = new StringBuilder();

      for (double value : memory) {
          if (value != 0) {
              memoryContents.append(value).append("\n");
          }
      }
      return memoryContents.toString().trim();
  }





}
