public class Fox extends Animal {
  String name;
  public Fox(){
    name = "dog";
  }
  public Fox(String s) {
    name = s;
    //System.out.println(name);
  }
  public void speak() {
    System.out.println("Ringding"+name);
  }
  public void bark()
  {
    System.out.println("bark");
  }
}
