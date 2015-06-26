public class Main
{
  public static void main(String[] args)
  {
      Animal a2 = new Animal();
      Animal a3 = new Fox();
      System.out.println(((Fox)a3).name);
      System.out.println(((Animal)a3).name);
  }
}
